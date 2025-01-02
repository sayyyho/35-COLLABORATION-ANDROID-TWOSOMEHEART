package org.techtown.twosomeheart.domain.repository

import org.techtown.twosomeheart.domain.model.MyMenuEntity

interface MyMenuRepository {
    suspend fun getMyMenu(): Result<MyMenuEntity>
}