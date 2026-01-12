package com.example.lamp.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface UrlRepository {

    suspend fun changeBaseUrl(baseUrl: String)
    suspend fun getBaseUrl() : String
}

class  UrlRepositoryImpl @Inject constructor (
    private  val dataStore: DataStore<Preferences>
) : UrlRepository {

    companion object {
        private val keyBaseUrl = stringPreferencesKey("KEY_BASE_URL")
    }

    override suspend fun changeBaseUrl(baseUrl: String) {
        dataStore.updateData {
            it.toMutablePreferences().also { preferences ->
                preferences[keyBaseUrl] = baseUrl
            }
        }
    }
    override suspend fun getBaseUrl(): String {
        return dataStore.data.map { preferences ->
            preferences[keyBaseUrl]}
            .firstOrNull().orEmpty()
    }
}