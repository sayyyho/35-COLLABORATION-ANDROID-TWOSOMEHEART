package org.techtown.twosomeheart.data.service

import org.techtown.twosomeheart.data.dto.response.BaseResponse
import org.techtown.twosomeheart.data.dto.response.DummyBaseResponse
import org.techtown.twosomeheart.data.dto.response.ResponseDummyDto
import org.techtown.twosomeheart.data.dto.response.ResponseMyMenuDto
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path

interface TwosomeService {
    //dummy
    @GET("api/users")
    suspend fun getDummyLists(
        @Query("page") page: Int = 2
    ): DummyBaseResponse<ResponseDummyDto>

    @GET("api/v1/likes")
    suspend fun getMyMenu(): ResponseMyMenuDto
}

