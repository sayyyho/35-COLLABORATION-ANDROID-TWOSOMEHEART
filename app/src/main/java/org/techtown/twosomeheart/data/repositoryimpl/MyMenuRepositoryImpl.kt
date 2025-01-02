package org.techtown.twosomeheart.data.repositoryimpl

import org.techtown.twosomeheart.data.datasource.MyMenuDataSource
import org.techtown.twosomeheart.domain.model.MyMenuEntity
import org.techtown.twosomeheart.domain.repository.MyMenuRepository

class MyMenuRepositoryImpl @Inject constructor(
    private val myMenuDataSource: MyMenuDataSource,
):MyMenuRepository{
    override suspend fun getMyMenu(): Result<MyMenuEntity> =
        runCatching {
            myMenuDataSource.getMyMenu().
        }
}