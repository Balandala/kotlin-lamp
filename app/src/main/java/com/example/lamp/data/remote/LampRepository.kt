package com.example.lamp.data.remote

import com.example.lamp.data.remote.dto.BrightnessLevelsDTO
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

interface LampRepository {
    suspend fun setState(isOn: Boolean): Result<Boolean?>
    suspend fun getBrightnessLevels(): Result<BrightnessLevelsDTO?>
    suspend fun getCurrentBrightness(): Result<Int?>
    suspend fun setBrightness(level: Int): Result<Boolean?>
    suspend fun getColors(): Result<List<String>?>
    suspend fun setColor(color: String): Result<Boolean?>
}

class LampRepositoryImpl @Inject constructor(
    val service: LampService
) : LampRepository {
    override suspend fun setState(isOn: Boolean): Result<Boolean?> {
        kotlin.runCatching {
            if (isOn)
                service.turnOn()
            else
                service.turnOff()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun setBrightness(level: Int): Result<Boolean?> {
        kotlin.runCatching {
            service.setBrightness(level)
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getBrightnessLevels(): Result<BrightnessLevelsDTO?> {
        kotlin.runCatching {
            service.getBrightnessLevels()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getCurrentBrightness(): Result<Int?> {
        kotlin.runCatching {
            service.getCurrentBrightness()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun getColors(): Result<List<String>?> {
        kotlin.runCatching {
            service.getColors()
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

    override suspend fun setColor(color: String): Result<Boolean?> {
        kotlin.runCatching {
            service.setColor(color)
        }.fold(
            onSuccess = {
                return if (it.isSuccessful)
                    Result.success(it.body())
                else Result.failure(HttpException(it))
            },
            onFailure = {
                return Result.failure(it)
            }
        )
    }

}