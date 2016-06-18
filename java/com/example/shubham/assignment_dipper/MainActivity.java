    package com.example.shubham.assignment_dipper;

    import android.content.Context;
    import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class MainActivity extends AppCompatActivity implements LocationListener{
        private static final Timer timer = new Timer();
        private static Data reciveddata;
        private Button update;
        private EditText price;
        private TextView source,destination,LMVrate,HMLrate,id;
        private static boolean dataRecived = false;
        private static LocationManager locationManager;
        private RecyclerView recyclerView;
        private RecyclerView.LayoutManager mLayoutManager;
        private RecyclerView.Adapter mAdapter;
        private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            source = (TextView) findViewById(R.id.textView);
            destination = (TextView) findViewById(R.id.textView3);
            LMVrate = (TextView)findViewById(R.id.textView7);
            id = (TextView)findViewById(R.id.textView54);
            HMLrate = (TextView) findViewById(R.id.textView11);
            recyclerView = (RecyclerView) findViewById(R.id.truckList);
            recyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(mLayoutManager);
            update = (Button) findViewById(R.id.button);
            price = (EditText) findViewById(R.id.price);
            price.addTextChangedListener(textWatcher);

            /**Crashlytics Integration to the application...**/
            Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
            setContentView(R.layout.activity_main);

            final NetworkService service = MyServiceGenerator.createService(NetworkService.class);

            /**Sending Location to the server after every 15 minutes**/

            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 10, this);

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Handler handler = new Handler(getApplicationContext().getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                            String latitude = String.valueOf(location.getLatitude());
                            String longitude = String.valueOf(location.getLongitude());
                            LocationData locationData = new LocationData();
                            locationData.setLatitude(latitude);
                            locationData.setLongitude(longitude);
                            NetworkService service1 = MyServiceGenerator.createService(NetworkService.class);
                            Call<ResponseMessage> call1 = service1.sendLocation(locationData);
                            call1.enqueue(new Callback<ResponseMessage>() {
                                @Override
                                public void onResponse(Call<ResponseMessage> call, Response<ResponseMessage> response) {
                                    if (response.code() == 200) {
                                        ResponseMessage res = response.body();
                                        Log.i("RESPONSE call1", ":" + res.getResponseMessage());
                                        Toast.makeText(getApplicationContext(), "response from server:" + res.getResponseMessage(), Toast.LENGTH_SHORT).show();
                                        Toast.makeText(getApplicationContext(), "Location Send to the server...", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Log.w(response.code() + "\t" + "Response call1", "Something wrong on the server side");
                                    }

                                }

                                @Override
                                public void onFailure(Call<ResponseMessage> call, Throwable t) {
                                    Log.e("Error call1", ":" + t.getMessage());
                                    Toast.makeText(getApplicationContext(),"Error while sending the location:"+t.getMessage(),Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    });
                }
            }, 0,900000);




                          /**Get the Json data from the Server and  Update the User Interface**/
             Call<Data> call = service.getData();
             call.enqueue(new Callback<Data>() {
                 @Override
                  public void onResponse(Call<Data> call, Response<Data> response) {
                     Log.d("call response code",String.valueOf(response.code()));
                     if(response.code() == 200) {
                        reciveddata = response.body();
                        /***UI updation..........................***/
                         id.setText(String.valueOf(reciveddata.getId()));
                        Trucker_Request trucker_request = reciveddata.getTrucker_request();
                         source.setText(trucker_request.getRoute_start());
                         destination.setText(trucker_request.getRoute_end());
                         LMVrate.setText(String.valueOf(trucker_request.getQuoted_price()));
                         List<Trucks> truckses = reciveddata.getTrucks();
                         mAdapter = new MyAdapter(truckses);
                         recyclerView.setAdapter(mAdapter);
                         /***.......................................***/

                         dataRecived = true;
                      }
                     else{
                         Toast.makeText(getApplicationContext(),"Response Code:"+response.code(),Toast.LENGTH_LONG).show();

                     }
                  }

                  @Override
                  public void onFailure(Call<Data> call, Throwable t) {
                      Toast.makeText(getApplicationContext(),"Error while fetching the data:"+t.getMessage(),Toast.LENGTH_LONG).show();
                      Log.e("call failure", ":" + t.getMessage());

                    }
                });


                                                         /**GCM Integration to the application**/
            if(playservices()){
                Intent intent = new Intent(MainActivity.this, RegistrationIntentService.class);
                startService(intent);
            }
        }


        private boolean playservices() {
            GoogleApiAvailability availability = GoogleApiAvailability.getInstance();
            int resCode = availability.isGooglePlayServicesAvailable(this);
            if(resCode != ConnectionResult.SUCCESS){
                if(availability.isUserResolvableError(resCode)){
                    availability.getErrorDialog(this,resCode,PLAY_SERVICES_RESOLUTION_REQUEST).show();

                }else{
                    Log.i("info","This Device is not supported");
                    finish();
                }
                return false;
            }
            return true;
        }

                                          /**TEXT WATCHER for the EditText***/
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("Message","s:"+s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String t = s.toString();
                if(t.equals("5000")){
                    update.setBackgroundColor(getResources().getColor(R.color.update));
                }else{
                    update.setBackgroundColor(getResources().getColor(R.color.update2));
                    Log.d("Message", t);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                Log.d("s:",s.toString());


            }
        };

        public  void onUpdate(View view){
                    if(price.getText().toString().equals("5000")){
                        if(dataRecived){
                            Intent intent = new Intent(getApplicationContext(),BookedScreen.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(),"Data not recived",Toast.LENGTH_LONG).show();
                        }

                    }else {
                        Toast.makeText(getApplicationContext(),"Price must be equal to 5000",Toast.LENGTH_LONG).show();
                    }


        }



                                                /***Method Implementation for the Interface...**/
        @Override
        public void onLocationChanged(Location location) {
            Log.i("message:", "Location Changed");
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.i("message:","StatusChanged");
        }

        @Override
        public void onProviderEnabled(String provider) {
            Log.i("message:",provider+"Enabled");
        }

        @Override
        public void onProviderDisabled(String provider) {
            Log.i("message", provider + "Disabled");
        }

        public static Data getdata(){
            return reciveddata;
        }


    }
                /***RecyclerView to show the vehicle available***/
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<Trucks> trucksList;
        private int count;

        public static class ViewHolder extends  RecyclerView.ViewHolder{

            private final TextView v_Number;
            private final TextView v_Type;
            private final TextView v_company;
            private final TextView v_ton;

            public ViewHolder(View tv) {
                super(tv);
                v_Number = (TextView) tv.findViewById(R.id.textView49);
                v_Type = (TextView)   tv.findViewById(R.id.textView50);
                v_company = (TextView) tv.findViewById(R.id.textView51);
                v_ton = (TextView)    tv.findViewById(R.id.textView52);
            }
        }
        public MyAdapter(List<Trucks> truckList){
            trucksList = truckList;
            count = truckList.size();
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.v_Number.setText(trucksList.get(position).getTruck_number());
            holder.v_company.setText(trucksList.get(position).getTruck_company());
            holder.v_ton.setText(String.valueOf(trucksList.get(position).getTonnage())+" "+"ton");
            holder.v_Type.setText(trucksList.get(position).getTruck_type());

        }

        @Override
        public int getItemCount() {
            return count;
        }

    }