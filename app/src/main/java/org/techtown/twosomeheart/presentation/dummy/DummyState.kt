package org.techtown.twosomeheart.presentation.dummy

import kotlinx.collections.immutable.PersistentList
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.data.dto.response.ResponseDummyDto

data class DummyState (
    val uiState: UiState<PersistentList<ResponseDummyDto>> = UiState.Loading
)
