package com.example.lamp.di

import com.example.lamp.data.local.UrlRepository
import com.example.lamp.data.local.UrlRepositoryImpl
import com.example.lamp.data.remote.LampRepository
import com.example.lamp.data.remote.LampRepositoryImpl
import com.example.lamp.domain.ChangeBaseUrlUseCase
import com.example.lamp.domain.ChangeBaseUrlUseCaseImpl
import com.example.lamp.domain.GetBrightnessLevelsUseCase
import com.example.lamp.domain.GetBrightnessLevelsUseCaseImpl
import com.example.lamp.domain.GetCurrentBrightnessUseCase
import com.example.lamp.domain.GetCurrentBrightnessUseCaseImpl
import com.example.lamp.domain.SetBrightnessUseCase
import com.example.lamp.domain.SetBrightnessUseCaseImpl
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

    @Binds
    fun bindGetBrightnessLevelsUseCase(getBrightnessLevelsUseCaseImpl: GetBrightnessLevelsUseCaseImpl) : GetBrightnessLevelsUseCase

    @Binds
    fun bindGetCurrentBrightnessUseCase(getCurrentBrightnessUseCaseImpl: GetCurrentBrightnessUseCaseImpl) : GetCurrentBrightnessUseCase

    @Binds
    fun bindSetBrightnessUseCase(setBrightnessUseCaseImpl: SetBrightnessUseCaseImpl) : SetBrightnessUseCase

}