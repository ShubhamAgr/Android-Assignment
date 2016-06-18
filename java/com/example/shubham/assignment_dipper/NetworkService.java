package com.example.shubham.assignment_dipper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by shubham on 6/4/16.
 */
public interface NetworkService {
    @GET("api/569a05b3e4b01190df49b82f")
    Call<Data> getData();

    @POST("api/5708d53de4b01190df5cfaaa")
    Call<ResponseMessage> sendLocation(@Body LocationData locationData);
}
