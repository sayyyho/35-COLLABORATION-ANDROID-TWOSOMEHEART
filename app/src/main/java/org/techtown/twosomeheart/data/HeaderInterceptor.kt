package org.techtown.twosomeheart.data

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", 1.toString())
            .build()
        return chain.proceed(request)
    }
}
