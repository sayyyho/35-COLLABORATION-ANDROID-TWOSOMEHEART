package org.techtown.twosomeheart.presentation.detail

import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
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
        menuPrice = 5500,
        menuCaution = "고카페인, 우유",
        menuNutrition = splitNutritionText(
            "1회 제공량: 325ml\n총 제공량: 1잔\n열량(Kcal): 260\n당류(g/%): 30/30\n단백질(g/%): 7/13\n포화지방(g/%): 5/33\n나트륨(mg/%): 160/8\n카페인(mg/%): 92"
        ),
        menuAllergy = "우유",
        menuImageUrl = "https://private-user-images.githubusercontent.com/69308068/389300533-8d353883-fb4b-4608-b0b4-24d2bc074133.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MzI1MzI2OTksIm5iZiI6MTczMjUzMjM5OSwicGF0aCI6Ii82OTMwODA2OC8zODkzMDA1MzMtOGQzNTM4ODMtZmI0Yi00NjA4LWIwYjQtMjRkMmJjMDc0MTMzLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDExMjUlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQxMTI1VDEwNTk1OVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTMwZTViNmNmMDUwODlmYjRiNGUzZDYzYmY5MmQxOTE0ZTkyMzI3ODJkNDk2MjljZjZjMTRkODE1MzNiM2JkMzkmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.BcvGmMQweWhlRzbTBNEGhu9K6WTQOUE6Fkntktloog0"
    )

    private fun splitNutritionText(nutritionTexts: String): PersistentList<String>? {
        return nutritionTexts.split("\n").toPersistentList()
    }
}