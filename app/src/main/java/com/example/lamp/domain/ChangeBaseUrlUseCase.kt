package com.example.lamp.domain

import com.example.lamp.data.local.UrlRepository
import javax.inject.Inject

interface ChangeBaseUrlUseCase {
    suspend operator fun invoke(baseUrl: String)
}

class  ChangeBaseUrlUseCaseImpl @Inject constructor(
    val urlRepository: UrlRepository
) : ChangeBaseUrlUseCase{
    override suspend fun invoke(baseUrl: String) {
        if (!baseUrl.contains(Regex("^https?://")))
            throw IllegalArgumentException("Invalid URL: $baseUrl")
       urlRepository.changeBaseUrl(baseUrl)
    }
}