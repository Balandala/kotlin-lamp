package com.example.lamp.domain

import com.example.lamp.data.remote.LampRepository
import javax.inject.Inject

interface GetCurrentBrightnessUseCase {
    suspend operator fun invoke(): Result<Int?>
}

class GetCurrentBrightnessUseCaseImpl @Inject constructor(
    val lampRepository: LampRepository
) : GetCurrentBrightnessUseCase {
    override suspend operator fun invoke(): Result<Int?> {
        return lampRepository.getCurrentBrightness()
    }
}