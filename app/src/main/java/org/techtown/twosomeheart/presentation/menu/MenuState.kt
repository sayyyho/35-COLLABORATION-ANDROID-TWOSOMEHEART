package org.techtown.twosomeheart.presentation.menu

import kotlinx.collections.immutable.PersistentList
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.presentation.menu.model.MenuModel

data class MenuState(
    val uiState: UiState<PersistentList<MenuModel>> = UiState.Loading
)
