package com.example.lamp.di

import android.content.Context
import com.example.lamp.di.network.NetworkModule
import com.example.lamp.di.network.OkHttpModule
import com.example.lamp.presenter.ui.MainFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class
])
interface AppComponent {
    fun inject(fragment: MainFragment)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }
}
@Module (includes = [
    // Bindings classes here
    AppBindsModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    DataStoreModule::class,
    OkHttpModule::class,
])
class AppModule