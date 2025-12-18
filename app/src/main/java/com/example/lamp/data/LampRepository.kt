package com.example.lamp.data

import retrofit2.Response
import javax.inject.Inject

interface LampRepository {

    suspend fun setState(isOn: Boolean): Boolean

    suspend fun setColor(): Boolean

    suspend fun setBrightness(): Boolean
}

class LampRepositoryImpl @Inject constructor(
    val service: LampService
) : LampRepository {
    override suspend fun setState(isOn: Boolean): Boolean {
        try {
            var response: Response<Boolean>
            if (isOn)
                response = service.turnOn()
            else
                response = service.turnOff()

            return response.isSuccessful

        } catch (e : Exception){
            println(e)
            return false
        }
    }

    override suspend fun setColor(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun setBrightness(): Boolean {
        TODO("Not yet implemented")
    }

}