package org.techtown.twosomeheart.data.service

import org.techtown.twosomeheart.data.dto.response.ResponseMyMenuDto
import retrofit2.http.GET

interface MyMenuService {
    @GET("api/v1/likes")
    suspend fun getMyMenu(): ResponseMyMenuDto
}

