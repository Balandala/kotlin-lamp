package com.example.lamp.di

import dagger.Component
import dagger.Module

@Component(modules = [
    AppModule::class
])
class AppComponent {


}
@Module (includes = [
    // Bindings classes here
    NetworkModule::class
])
class AppModule