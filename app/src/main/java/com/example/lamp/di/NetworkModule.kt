package com.example.lamp.di

import com.example.lamp.data.LampService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    fun provideLampService() : LampService =
        Retrofit.Builder()
            .baseUrl("http://46.17.45.34:1337/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()

}