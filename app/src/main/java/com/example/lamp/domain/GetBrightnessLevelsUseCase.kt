package com.example.lamp.domain

import com.example.lamp.data.remote.LampRepository
import com.example.lamp.data.remote.dto.BrightnessLevelsDTO
import javax.inject.Inject

interface GetBrightnessLevelsUseCase {
    suspend operator fun invoke() : Result<BrightnessLevelsDTO?>
}

class GetBrightnessLevelsUseCaseImpl @Inject constructor(
    val lampRepository: LampRepository
) : GetBrightnessLevelsUseCase {
    override suspend operator fun invoke(): Result<BrightnessLevelsDTO?> {
        return lampRepository.getBrightnessLevels()
    }
}