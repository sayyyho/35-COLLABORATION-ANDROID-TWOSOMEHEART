package org.techtown.twosomeheart.presentation.mymenu

import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.presentation.mymenu.model.MyMenuModel

class MyMenuViewModel : ViewModel() {

    private val _state = MutableStateFlow(MyMenuState())
    val state: StateFlow<MyMenuState>
        get() = _state.asStateFlow()

    fun getMenuDummy() {
        _state.value = _state.value.copy(
            uiState = UiState.Success(menuDummy)
        )
    }

    private val menuDummy: PersistentList<MyMenuModel> = persistentListOf(
        MyMenuModel(
            menuName = "바나나 샷 라떼",
            menuPrice = 5500,
            menuImage = R.drawable.img_menu_banana_latte,
            menuOption = "아이스/라지/블랙그라운드/포장"
        ),
        MyMenuModel(
            menuName = "바나나 샷 아메리카노",
            menuPrice = 5800,
            menuImage = R.drawable.img_menu_banana_ameicano,
            menuOption = "아이스/라지/블랙그라운드/포장"
        ),

    )
}
