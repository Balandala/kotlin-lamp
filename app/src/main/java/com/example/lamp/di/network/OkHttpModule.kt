package com.example.lamp.di.network

import com.example.lamp.AppConstants
import com.example.lamp.data.local.UrlRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient

@Module
object OkHttpModule {

    @Provides
    fun provideOkHttpClient(
        urlInterceptor: Interceptor
    ) : OkHttpClient {
        return OkHttpClient.Builder().apply {
                addInterceptor(urlInterceptor)
            }.build()
        }

    @Provides
    fun provideUrlInterceptor(
        urlRepository: UrlRepository
    ) : Interceptor {
        return Interceptor { chain ->

            val request = chain.request()
            val url = request.url().toString()
            val builder = request.newBuilder()

            val currentBaseUrl = runBlocking {
                urlRepository.getBaseUrl()
            }

            if (!currentBaseUrl.isEmpty()) {
                builder.url(
                    url.replaceFirst(AppConstants.BASE_URL, currentBaseUrl)
                )
            }
            chain.proceed(builder.build())
        }
    }
}
