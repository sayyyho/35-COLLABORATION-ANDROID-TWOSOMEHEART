package org.techtown.twosomeheart.presentation.mymenu

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.data.ApiFactory
import org.techtown.twosomeheart.presentation.mymenu.model.MyMenuModel

class MyMenuViewModel : ViewModel() {

    private val twosomeService by lazy { ApiFactory.ServicePool.twosomeService }

    private val _state = MutableStateFlow(MyMenuState())
    val state: StateFlow<MyMenuState>
        get() = _state.asStateFlow()

    fun getMyMenu() {
        viewModelScope.launch {
            runCatching {
                twosomeService.getMyMenu() // BaseResponse<ResponseMyMenuDto> 반환
            }.onSuccess { response ->
                val favoriteList = response.data.favoriteList.map { item ->
                    MyMenuModel(
                        menuName = item.name,
                        menuPrice = item.price,
                        menuImage = item.imageUrl,
                        menuOption = "${item.temperature}/${item.size}/${item.coffeeBean}/${item.togo}${if(item.personal){"/개인컵"}else{""}}",
                        isChecked = false // 기본값 설정
                    )
                }.toPersistentList()

                _state.value = _state.value.copy(
                    uiState = UiState.Success(favoriteList)
                )
            }.onFailure { throwable ->
                _state.value = _state.value.copy(
                    uiState = UiState.Failure
                )
            }
        }
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
}
