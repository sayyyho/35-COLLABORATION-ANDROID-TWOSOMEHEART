package org.techtown.twosomeheart.presentation.mymenu

import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.presentation.mymenu.model.MyMenuModel

class MyMenuViewModel : ViewModel() {

    private val _state = MutableStateFlow(MyMenuState())
    val state: StateFlow<MyMenuState> = _state.asStateFlow()

    fun getMenuDummy() {
        _state.value = _state.value.copy(
            uiState = UiState.Success(menuDummy)
        )
    }

    fun toggleItemChecked(index: Int, isAll: Boolean = false, selectState: Boolean = true) {
        val currentState = _state.value
        if (currentState.uiState is UiState.Success) {
            val updatedList = currentState.uiState.data.toMutableList()

            if (isAll) {
                for (i in updatedList.indices) {
                    updatedList[i] = updatedList[i].copy(isChecked = selectState)
                }
            } else {
                val currentItem = updatedList[index]
                updatedList[index] = currentItem.copy(isChecked = !currentItem.isChecked)
            }

            _state.value = currentState.copy(
                uiState = UiState.Success(updatedList.toPersistentList())
            )
        }
    }

    private val menuDummy: PersistentList<MyMenuModel> = persistentListOf(
        MyMenuModel(
            menuName = "바나나 샷 라떼",
            menuPrice = 5500,
            menuImage = "https://github.com/user-attachments/assets/4b7b216c-0ea9-4034-a88c-953a6f761f98",
            menuOption = "아이스/라지/블랙그라운드/포장",
            isChecked = false
        ),
        MyMenuModel(
            menuName = "바나나 샷 아메리카노",
            menuPrice = 5800,
            menuImage = "https://github.com/user-attachments/assets/4b7b216c-0ea9-4034-a88c-953a6f761f98",
            menuOption = "/블랙그라운드/포장",
            isChecked = false
        ),
        MyMenuModel(
            menuName = "바나나 샷 아메리카노",
            menuPrice = 5800,
            menuImage = "https://github.com/user-attachments/assets/4b7b216c-0ea9-4034-a88c-953a6f761f98",
            menuOption = "/블랙그라운드/포장",
            isChecked = false
        ),
        MyMenuModel(
            menuName = "바나나 샷 아메리카노",
            menuPrice = 5800,
            menuImage = "https://github.com/user-attachments/assets/4b7b216c-0ea9-4034-a88c-953a6f761f98",
            menuOption = "/블랙그라운드/포장",
            isChecked = false
        ),
    )
}
