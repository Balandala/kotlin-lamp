package com.example.lamp.di

import com.example.lamp.data.local.UrlRepository
import com.example.lamp.data.local.UrlRepositoryImpl
import com.example.lamp.data.remote.LampRepository
import com.example.lamp.data.remote.LampRepositoryImpl
import com.example.lamp.domain.ChangeBaseUrlUseCase
import com.example.lamp.domain.ChangeBaseUrlUseCaseImpl
import com.example.lamp.domain.SetStateUseCase
import com.example.lamp.domain.SetStateUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindsModule {
    @Binds
    fun bindLampRepository(repository: LampRepositoryImpl) : LampRepository

    @Binds
    fun bindUrlRepository(urlRepository: UrlRepositoryImpl) : UrlRepository

    @Binds
    fun bindSetStateUseCase(setStateUseCaseImpl: SetStateUseCaseImpl) : SetStateUseCase

    @Binds
    fun bindChangeBaseUrlUseCase(changeBaseUrlUseCaseImpl: ChangeBaseUrlUseCaseImpl) : ChangeBaseUrlUseCase

}