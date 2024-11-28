package org.techtown.twosomeheart.presentation.detail

import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.presentation.detail.model.DetailModel

data class DetailState(
    val uiState: UiState<DetailModel> = UiState.Loading,
    val isShowBottomSheet: Boolean = false
)