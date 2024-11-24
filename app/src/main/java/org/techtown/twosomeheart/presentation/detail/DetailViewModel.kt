package org.techtown.twosomeheart.presentation.detail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.presentation.detail.model.DetailModel

class DetailViewModel: ViewModel() {

    private val _state = MutableStateFlow(DetailState())
    val state: StateFlow<DetailState>
        get() = _state.asStateFlow()

    fun getDetailDummy() {
        _state.value = _state.value.copy(
            uiState = UiState.Success(detailDummy)
        )
    }

    private val detailDummy = DetailModel(
        menuId = 1,
        menuName = "바나나 샷 라떼",
        menuStatus = "New",
        menuDescription = "달콤한 바나나 라떼에 에스프레소 샷 추가!",
        menuPrice = "5,500",
        menuCaution = "고카페인, 우유",
        menuNutrition = "1회 제공량: 325ml\n총 제공량: 1잔\n열량(Kcal): 260\n당류(g/%): 30/30\n단백질(g/%): 7/13\n포화지방(g/%): 5/33\n나트륨(mg/%): 160/8\n카페인(mg/%): 92",
        menuAllergy = "우유",
        menuImageUrl = "dummy"
    )

}