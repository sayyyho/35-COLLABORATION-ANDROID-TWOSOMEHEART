package org.techtown.twosomeheart.data.datasourceimpl

import org.techtown.twosomeheart.data.datasource.MyMenuDataSource
import org.techtown.twosomeheart.data.dto.response.ResponseMyMenuDto
import org.techtown.twosomeheart.data.service.MyMenuService
import javax.inject.Inject

class MyMenuDataSouceImpl @Inject constructor(
    private val mymenuService : MyMenuService,
) : MyMenuDataSource {
    override suspend fun getMyMenu(): ResponseMyMenuDto = mymenuService.getMyMenu()
}
