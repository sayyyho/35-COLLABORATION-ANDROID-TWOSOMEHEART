package org.techtown.twosomeheart.data.service

import org.techtown.twosomeheart.data.dto.response.ResponseMenuDetailDto
import org.techtown.twosomeheart.data.dto.response.ResponseMyMenuDeleteDTO
import org.techtown.twosomeheart.data.dto.response.ResponseMyMenuDto
import retrofit2.http.DELETE
import org.techtown.twosomeheart.data.dto.response.ResponseMyMenuDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TwosomeService {
    //menu detail
    @GET("api/v1/menu/{menuId}")
    suspend fun getMenuLists(
        @Path("menuId") menuId: Long
    ): ResponseMenuDetailDto


    @GET("api/v1/likes")
    suspend fun getMyMenu(): ResponseMyMenuDto

    @DELETE("api/v1/likes")
    suspend fun deleteMyMenu(
        @Query("favoriteIds") favoriteIds: String? = null,
        @Query("all") all: Boolean = false
    ): ResponseMyMenuDeleteDTO}
}
