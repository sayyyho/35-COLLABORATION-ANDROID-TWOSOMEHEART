package org.techtown.twosomeheart.presentation.dummy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.data.ApiFactory

class DummyViewModel : ViewModel() {
    private val twosomeService by lazy { ApiFactory.ServicePool.twosomeService }

    private val _state = MutableStateFlow(DummyState())
    val state: StateFlow<DummyState>
        get() = _state.asStateFlow()

    private val _sideEffect = MutableSharedFlow<DummySideEffect>()
    val sideEffect: SharedFlow<DummySideEffect>
        get() = _sideEffect.asSharedFlow()

    fun getMyJogboList() {
        viewModelScope.launch {
            runCatching {
                twosomeService.getDummyLists()
            }.onSuccess { dummyList ->
                _state.value = _state.value.copy(
                    uiState = UiState.Success(
                        dummyList.data.toPersistentList()
                    )
                )
            }.onFailure { throwable ->
                _state.value = _state.value.copy(
                    uiState = UiState.Failure
                )
                _sideEffect.emit(DummySideEffect.ShowToast(R.string.dummy_example_string))
            }
        }
    }

}
