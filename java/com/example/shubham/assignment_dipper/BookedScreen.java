package com.example.shubham.assignment_dipper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class BookedScreen extends AppCompatActivity {
    private Data data;
    private TextView shipperName,material,tripId,yourRate,totalRate,loadingCoordinatorname,loadingCoordinatorPh,consignerName,consignerPh,consigneeName,consigneePh,pickupAddress,uploadingAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_screen);
        data = MainActivity.getdata();

        shipperName = (TextView) findViewById(R.id.textView40);
        material = (TextView) findViewById(R.id.textView42);
        tripId = (TextView) findViewById(R.id.textView44);
        yourRate = (TextView) findViewById(R.id.textView46);
        totalRate = (TextView) findViewById(R.id.textView48);
        loadingCoordinatorname = (TextView) findViewById(R.id.textView21);
        loadingCoordinatorPh = (TextView) findViewById(R.id.textView23);
        consigneeName = (TextView) findViewById(R.id.textView30);
        consigneePh = (TextView) findViewById(R.id.textView32);
        consignerName = (TextView) findViewById(R.id.textView26);
        consignerPh = (TextView) findViewById(R.id.textView28);
        pickupAddress = (TextView) findViewById(R.id.textView36);
        uploadingAddress = (TextView) findViewById(R.id.textView38);

        Shipper shipper = data.getShipper();
        shipperName.setText(shipper.getCompany_name());

        Load load = data.getLoad();
        material.setText(load.getMaterial_type());

        Trucker trucker = data.getTrucker();
        loadingCoordinatorname .setText(trucker.getTrucker_name());
        loadingCoordinatorPh.setText(trucker.getOffice_phone_no());

        yourRate.setText(String.valueOf(data.getBooking_price()));
        totalRate.setText(String.valueOf(data.getTotal_amount()));

        pickupAddress.setText(data.getPickup_address());
        uploadingAddress.setText(data.getDrop_address());
    }
    /**Calling when click on the phone number**/

    public void call(View view){
        String phone_number = null;

        switch (view.getId()){
            case R.id.textView32:
                phone_number = consigneePh.getText().toString();
                break;
            case R.id.textView23:
                phone_number = loadingCoordinatorPh.getText().toString();
                break;
            case R.id.textView28:
                phone_number = consignerPh.getText().toString();
                break;
            default:
                Log.e("phone_number", "Not Assigned");

        }
        Intent call = new Intent(Intent.ACTION_CALL);
        call.setData(Uri.parse("tel:+91-" + phone_number));
        try{
            startActivity(call);
        }catch (Exception e){
            Log.e("calling_error", ":" + e.getMessage());
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.detail) {
            return true;
        }
        if (id == R.id.delete) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
