package com.example.lamp.di

import com.example.lamp.data.LampRepository
import com.example.lamp.data.LampRepositoryImpl
import com.example.lamp.domain.SetStateUseCase
import com.example.lamp.domain.SetStateUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindLampRepository(repository: LampRepositoryImpl) : LampRepository

    @Binds
    fun bindSetStateUseCase(useCaseImpl: SetStateUseCaseImpl) : SetStateUseCase
}