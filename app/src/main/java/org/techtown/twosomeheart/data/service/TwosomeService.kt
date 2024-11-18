package org.techtown.twosomeheart.data.service

import org.techtown.twosomeheart.data.dto.response.DummyBaseResponse
import org.techtown.twosomeheart.data.dto.response.ResponseDummyDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TwosomeService {
    //dummy
    @GET("api/users")
    suspend fun getDummyLists(
        @Query("page") page: Int = 2
    ): DummyBaseResponse<ResponseDummyDto>
}
