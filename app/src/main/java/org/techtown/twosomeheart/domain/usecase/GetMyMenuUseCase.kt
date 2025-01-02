package org.techtown.twosomeheart.domain.usecase

import org.techtown.twosomeheart.domain.model.MyMenuEntity
import org.techtown.twosomeheart.domain.repository.MyMenuRepository

class GetMyMenuUseCase(
    private val myMenuRepository: MyMenuRepository
) {
    suspend operator fun invoke(): Result<MyMenuEntity> = myMenuRepository.getMyMenu()
}