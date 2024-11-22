package org.techtown.twosomeheart.presentation.menu

import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.presentation.menu.model.MenuModel

class MenuViewModel : ViewModel() {

    private val _state = MutableStateFlow(MenuState())
    val state: StateFlow<MenuState>
        get() = _state.asStateFlow()

    fun getMenuDummy() {
        _state.value = _state.value.copy(
            uiState = UiState.Success(menuDummy)
        )
    }

    private val menuDummy: PersistentList<MenuModel> = persistentListOf(
        MenuModel(
            menuName = "바나나 샷 라떼",
            menuPrice = 5500,
            menuImage = R.drawable.img_menu_banana_latte,
        ),
        MenuModel(
            menuName = "바나나 샷 아메리카노",
            menuPrice = 5800,
            menuImage = R.drawable.img_menu_banana_ameicano,
        ),
        MenuModel(
            menuName = "디카페인 오틀리 콜르브루",
            menuPrice = 6300,
            menuImage = R.drawable.img_menu_ortley_coldbrew,
            isBestMenu = true,
        ),
        MenuModel(
            menuName = "레몬 아샷추",
            menuPrice = 5500,
            menuImage = R.drawable.img_menu_lemon_americano,
            isBestMenu = true,
        )
    )
}
