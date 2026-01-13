package com.example.lamp.domain

import com.example.lamp.data.remote.LampRepository
import javax.inject.Inject

interface GetColorsUseCase {
    suspend operator fun invoke(): Result<List<String>?>
}

class GetColorsUseCaseImpl @Inject constructor(
    val lampRepository: LampRepository
) : GetColorsUseCase {
    override suspend fun invoke(): Result<List<String>?> {
        return lampRepository.getColors()
    }
}