package com.example.lamp.domain

import com.example.lamp.data.LampRepository
import javax.inject.Inject

interface SetStateUseCase {
    suspend operator fun invoke(isOn: Boolean): Boolean
}

class SetStateUseCaseImpl @Inject constructor(
    val repository: LampRepository
) : SetStateUseCase {
    override suspend operator fun invoke(isOn: Boolean): Boolean {
        return repository.setState(isOn)
    }
}

