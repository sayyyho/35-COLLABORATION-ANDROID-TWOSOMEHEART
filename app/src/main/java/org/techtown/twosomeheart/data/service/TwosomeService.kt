package org.techtown.twosomeheart.data.service

import org.techtown.twosomeheart.data.dto.response.ResponseMenuDetailDto
import org.techtown.twosomeheart.data.dto.request.RequestMenuLikeDto
import org.techtown.twosomeheart.data.dto.response.ResponseMenuLikeDto
import org.techtown.twosomeheart.data.dto.response.ResponseMyMenuDto
import org.techtown.twosomeheart.data.dto.response.ResponseMyMenuDeleteDTO
import org.techtown.twosomeheart.data.dto.response.ResponseMyMenuDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.POST
import retrofit2.http.DELETE
import retrofit2.http.Query

interface TwosomeService {
    //menu detail
    @GET("api/v1/menu/{menuId}")
    suspend fun getMenuLists(
        @Path("menuId") menuId: Int = 2
    ): ResponseMenuDetailDto

    @GET("api/v1/likes")
    suspend fun getMyMenu(): ResponseMyMenuDto

    @POST("api/v1/menu/{menuId}/likes")
    suspend fun likeMenu(
        @Path("menuId") menuId: Long,
        @Body requestBody: RequestMenuLikeDto
    ): ResponseMenuLikeDto
  
  @DELETE("api/v1/likes")
    suspend fun deleteMyMenu(
        @Query("favoriteIds") favoriteIds: String? = null,
        @Query("all") all: Boolean = false
    ): ResponseMyMenuDeleteDTO}
}
