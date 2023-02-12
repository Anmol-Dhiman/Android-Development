package com.example.retrofit_skylarks_drone


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitRepo {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()


    @Provides
    @Singleton
    fun provideRetrofitInterface(retrofit: Retrofit): RetrofitInterface =
        retrofit.create(
            RetrofitInterface::
            class.java
        )

}