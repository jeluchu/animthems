package com.jeluchu.animthems.core.connection

import com.jeluchu.animthems.core.client.AnimthemsClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

/**
 * Class that handle request.
 */
class RestClient : AnimthemsClient() {
    suspend inline fun <reified T> request(endPoint: String): T? {
        return try {
            jsonClient.get(baseUrl + endPoint).body<T>()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    companion object {
        const val baseUrl = "https://api.animethemes.moe/"
    }

    @PublishedApi
    internal val jsonClient: HttpClient
        get() = httpClient
}