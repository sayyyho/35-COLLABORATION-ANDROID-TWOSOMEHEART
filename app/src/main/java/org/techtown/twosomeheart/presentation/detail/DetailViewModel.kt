package org.techtown.twosomeheart.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.data.ApiFactory.ServicePool.twosomeService
import org.techtown.twosomeheart.presentation.detail.model.DetailModel

class DetailViewModel: ViewModel() {

    private val _state = MutableStateFlow(DetailState())
    val state: StateFlow<DetailState>
        get() = _state.asStateFlow()

    fun getMenuDetail() {
        viewModelScope.launch {
            runCatching {
                twosomeService.getMenuLists()
            }.onSuccess { detail ->
                _state.value = _state.value.copy(
                    uiState = UiState.Success(
                        DetailModel(
                            menuId = detail.menuDetail.id,
                            menuName = detail.menuDetail.name,
                            menuStatus = detail.menuDetail.status,
                            menuDescription = detail.menuDetail.description,
                            menuPrice = detail.menuDetail.price,
                            menuCaution = detail.menuDetail.caution,
                            menuNutrition = splitNutritionText(detail.menuDetail.nutrition),
                            menuAllergy = detail.menuDetail.allergy,
                            menuImageUrl = detail.menuDetail.imageUrl
                        )
                    )
                )
            }.onFailure { throwable ->
                _state.value = _state.value.copy(
                    uiState = UiState.Failure
                )
            }
        }
    }

    private fun splitNutritionText(nutritionTexts: String): PersistentList<String>? {
        return nutritionTexts.split("\n").toPersistentList()
    }
}
