package org.techtown.twosomeheart.data.service

import org.techtown.twosomeheart.data.dto.response.ResponseMenuDetailDto
import org.techtown.twosomeheart.data.dto.response.ResponseMyMenuDto
import retrofit2.http.GET
import retrofit2.http.Path

interface TwosomeService {
    //menu detail
    @GET("api/v1/menu/{menuId}")
    suspend fun getMenuLists(
        @Path("menuId") menuId: Long
    ): ResponseMenuDetailDto


    @GET("api/v1/likes")
    suspend fun getMyMenu(): ResponseMyMenuDto
}
