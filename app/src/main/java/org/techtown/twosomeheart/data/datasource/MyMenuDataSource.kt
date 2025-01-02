package org.techtown.twosomeheart.data.datasource

import org.techtown.twosomeheart.data.dto.response.ResponseMyMenuDto

interface MyMenuDataSource {
    suspend fun getMyMenu(): ResponseMyMenuDto
}