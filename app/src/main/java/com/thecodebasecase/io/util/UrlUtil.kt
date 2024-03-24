package com.thecodebasecase.io.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

object UrlUtil {
    fun isNotEmpty(url: String): Boolean {
        val urlRegex = "^(https?://)?([\\da-z.-]+)\\.([a-z.]{2,6})[/\\w .-]*/?$".toRegex()
        return url.matches(urlRegex)
    }

    fun isValidUrl(url: String): Boolean {
        return try {
            java.net.URL(url).toURI()
            true
        } catch (e: Exception) {
            false
        }
    }
}
