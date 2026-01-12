package com.example.lamp.di

import androidx.fragment.app.Fragment
import com.example.lamp.presenter.ui.MainFragment
import dagger.Component
import dagger.Module

@Component(modules = [
    AppModule::class
])
interface AppComponent {
    fun inject(fragment: MainFragment)
}
@Module (includes = [
    // Bindings classes here
    AppBindsModule::class,
    ViewModelModule::class,
    NetworkModule::class,
])
class AppModule