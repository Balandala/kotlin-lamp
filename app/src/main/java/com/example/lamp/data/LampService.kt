package com.example.lamp.data

import retrofit2.Response
import retrofit2.http.POST

interface LampService {

    @POST("state/on")
    suspend fun turnOn(): Response<Boolean>

    @POST("state/off")
    suspend fun turnOff(): Response<Boolean>
}