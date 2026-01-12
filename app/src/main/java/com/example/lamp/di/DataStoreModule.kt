package com.example.lamp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataStoreModule {

    @Singleton
    @Provides
    fun provideDataStorePreferences (
        context: Context
    ) : DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            context.preferencesDataStoreFile("BASE_URL_DATASTORE")
        }
    }
}