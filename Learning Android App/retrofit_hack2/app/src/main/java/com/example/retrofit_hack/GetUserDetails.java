package com.example.retrofit_hack;


import java.util.ArrayList;

import kotlinx.coroutines.CoroutineExceptionHandler;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GetUserDetails {


    @POST("user/signup")
    Call<String> signUpPostResponse(@Body UserDetails userDetails);

    @POST("user/login")
    Call<String> logInPostResponse(@Body UserDetails userDetails);

    @GET("quotes")
    Call<UserDetails> getQuotes();

    @GET("getpolicedata/d")
    Call<ArrayList<Checkpoints>> getCheckPoints();
}
