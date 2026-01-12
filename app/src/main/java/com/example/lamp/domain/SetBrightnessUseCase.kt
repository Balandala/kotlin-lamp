package com.example.lamp.domain

import com.example.lamp.data.remote.LampRepository
import javax.inject.Inject

interface SetBrightnessUseCase {
    suspend operator fun invoke(level: Int): Result<Boolean?>
}

class SetBrightnessUseCaseImpl @Inject constructor(
    val lampRepository: LampRepository
) : SetBrightnessUseCase {
    override suspend operator fun invoke(level: Int): Result<Boolean?> {
        return lampRepository.setBrightness(level)
    }
}