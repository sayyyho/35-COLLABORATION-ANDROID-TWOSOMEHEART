package org.techtown.twosomeheart.presentation.mymenu

import kotlinx.collections.immutable.PersistentList
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.presentation.mymenu.model.MyMenuModel

data class MyMenuState(
    val uiState: UiState<PersistentList<MyMenuModel>> = UiState.Loading,
)
