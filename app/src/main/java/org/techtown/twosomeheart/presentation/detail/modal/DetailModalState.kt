package org.techtown.twosomeheart.presentation.detail.modal

import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.presentation.detail.model.LikeModel

data class DetailModalState(
    val uiState: UiState<Int> = UiState.Loading,
    val likeModel: LikeModel = LikeModel(),
    val isEnabled: Boolean = LikeModel().isEnabled
)