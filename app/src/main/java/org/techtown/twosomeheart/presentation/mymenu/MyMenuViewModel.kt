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
import org.techtown.twosomeheart.presentation.mymenu.model.SelectedSummary

class MyMenuViewModel : ViewModel() {

    private val _selectedSummary = MutableStateFlow(SelectedSummary(0, 0))
    val selectedSummary: StateFlow<SelectedSummary> = _selectedSummary.asStateFlow()

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
                        id = item.id,
                        isChecked = false // 기본값 설정
                    )
                }.toPersistentList()

                _state.value = _state.value.copy(
                    uiState = UiState.Success(favoriteList),
                )
            }.onFailure { throwable ->
                _state.value = _state.value.copy(
                    uiState = UiState.Failure
                )
            }
        }
    }

    fun deleteSelectedItems(isAll: Boolean = false) {
        viewModelScope.launch {
            val currentState = _state.value
            if (currentState.uiState is UiState.Success) {
                val selectedIds = if (isAll) {
                    currentState.uiState.data.map { it.id } // 전체 삭제 시 모든 ID 가져오기
                } else {
                    currentState.uiState.data.filter { it.isChecked }.map { it.id } // 선택된 ID만 가져오기
                }

                if (selectedIds.isNotEmpty()) {
                    runCatching {
                        twosomeService.deleteMyMenu(
                            favoriteIds = if (!isAll) selectedIds.joinToString(",") else null,
                            all = isAll
                        )
                    }.onSuccess {
                        // 성공 시 UI 업데이트
                        val updatedList = if (isAll) {
                            persistentListOf() // 전체 삭제 시 빈 리스트 반환
                        } else {
                            currentState.uiState.data.filter { !it.isChecked }.toPersistentList()
                        }

                        _state.value = currentState.copy(
                            uiState = UiState.Success(updatedList)
                        )
                    }.onFailure {
                        _state.value = currentState.copy(
                            uiState = UiState.Failure
                        )
                    }
                }
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
            val isAllSelected = updatedList.all { it.isChecked }
            _state.value = currentState.copy(
                uiState = UiState.Success(updatedList.toPersistentList())
            )
            _state.value = currentState.copy(
                uiState = UiState.Success(updatedList.toPersistentList())
            )

            // 총 금액 및 개수 계산
            calculateSummary()
        }
    }

    private fun calculateSummary() {
        val currentState = _state.value
        if (currentState.uiState is UiState.Success) {
            val selectedItems = currentState.uiState.data.filter { it.isChecked }
            val totalPrice = selectedItems.sumOf { it.menuPrice }
            val itemCount = selectedItems.size

            _selectedSummary.value = SelectedSummary(totalPrice, itemCount)
        }
    }
}
