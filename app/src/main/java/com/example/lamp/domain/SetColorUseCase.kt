package com.example.lamp.domain

import com.example.lamp.data.remote.LampRepository
import javax.inject.Inject

interface SetColorUseCase {
    suspend operator fun invoke(color: String): Result<Boolean?>
}

class SetColorUseCaseImpl @Inject constructor(
    val lampRepository: LampRepository
) : SetColorUseCase {
    override suspend fun invoke(color: String): Result<Boolean?> {
        return lampRepository.setColor(color)
    }
}