package com.example.lamp.data.remote

import com.example.lamp.data.remote.dto.BrightnessLevelsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LampService {

    @POST("state/on")
    suspend fun turnOn(): Response<Boolean?>

    @POST("state/off")
    suspend fun turnOff(): Response<Boolean?>

    @GET("brightness/")
    suspend fun getBrightnessLevels(): Response<BrightnessLevelsDTO?>

    @GET("brightness/current")
    suspend fun getCurrentBrightness(): Response<Int?>

    @POST("brightness/")
    suspend fun setBrightness(@Query("level") level : Int): Response<Boolean?>

    @GET("color/names_only")
    suspend fun getColors(): Response<List<String>?>

    @POST("color/")
    suspend fun setColor(@Query("color") color: String): Response<Boolean?>
}