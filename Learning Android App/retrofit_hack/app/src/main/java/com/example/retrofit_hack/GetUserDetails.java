package com.example.retrofit_hack;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetUserDetails {


    @POST("user/signup")
    Call<UserDetails> signUpPostResponse(@Body UserDetails userDetails);

    @POST("user/login")
    Call<UserDetails> logInPostResponse(@Body UserDetails userDetails);

    @GET("quotes")
    Call<String> getQuotes();
}
