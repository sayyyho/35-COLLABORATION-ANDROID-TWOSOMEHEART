package org.techtown.twosomeheart.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.data.ApiFactory.ServicePool.twosomeService
import org.techtown.twosomeheart.data.dto.request.RequestMenuLikeDto
import org.techtown.twosomeheart.presentation.detail.modal.DetailModalSideEffect
import org.techtown.twosomeheart.presentation.detail.modal.DetailModalState
import org.techtown.twosomeheart.presentation.detail.model.CoffeeBeanType
import org.techtown.twosomeheart.presentation.detail.model.DetailModel
import org.techtown.twosomeheart.presentation.detail.model.PickUpType
import org.techtown.twosomeheart.presentation.detail.model.SizeType
import org.techtown.twosomeheart.presentation.detail.model.TemperatureType

class DetailViewModel: ViewModel() {

    private val _detailState = MutableStateFlow(DetailState())
    val detailState: StateFlow<DetailState>
        get() = _detailState.asStateFlow()

    private val _detailModalState = MutableStateFlow(DetailModalState())
    val detailModalState: StateFlow<DetailModalState>
        get() = _detailModalState.asStateFlow()

    private var _sideEffect = MutableSharedFlow<DetailModalSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun getMenuDetail() {
        viewModelScope.launch {
            runCatching {
                twosomeService.getMenuLists()
            }.onSuccess { detail ->
                _detailState.value = _detailState.value.copy(
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
                _detailState.value = _detailState.value.copy(
                    uiState = UiState.Failure
                )
            }
        }
    }

    fun onStarButtonClick() {
        if (detailModalState.value.likeModel.isEnabled) {
            viewModelScope.launch {
                runCatching {
                    twosomeService.likeMenu(
                        menuId = detailModalState.value.likeModel.menuId,
                        requestBody = RequestMenuLikeDto(
                            name = detailModalState.value.likeModel.name,
                            price = detailModalState.value.likeModel.price,
                            temperature = detailModalState.value.likeModel.temperature,
                            size = detailModalState.value.likeModel.size,
                            coffeeBean = detailModalState.value.likeModel.coffeeBean,
                            togo = detailModalState.value.likeModel.togo,
                            personal = detailModalState.value.likeModel.personal
                        )
                    )
                }.onSuccess { response ->
                    _detailModalState.value = _detailModalState.value.copy(uiState = UiState.Success(response.status))
                    _sideEffect.emit(DetailModalSideEffect.SnackBar(R.string.menu_detail_modal_like_success))
                }.onFailure { throwable ->
                    if (throwable is retrofit2.HttpException) {
                        when (throwable.code()) {
                            400 -> {
                                _sideEffect.emit(DetailModalSideEffect.SnackBar(R.string.menu_detail_modal_like_failure_duplicate))
                            }
                            else -> {
                                _sideEffect.emit(DetailModalSideEffect.SnackBar(R.string.menu_detail_modal_like_failure))
                            }
                        }
                    } else {
                        _sideEffect.emit(DetailModalSideEffect.SnackBar(R.string.menu_detail_modal_like_failure))
                    }
                    _detailModalState.value = _detailModalState.value.copy(
                        uiState = UiState.Failure
                    )
                }
            }
        }
    }

    private fun splitNutritionText(nutritionTexts: String): PersistentList<String>? {
        return nutritionTexts.split("\n").toPersistentList()
    }

    fun updateLikeMenuId(menuId: Long) {
        _detailModalState.value = _detailModalState.value.copy(
            likeModel = _detailModalState.value.likeModel.copy(menuId = menuId)
        )
    }

    fun updateLikeName(name: String) {
        _detailModalState.value = _detailModalState.value.copy(
            likeModel = _detailModalState.value.likeModel.copy(name = name)
        )
    }

    fun updateLikePrice(price: Int) {
        _detailModalState.value = _detailModalState.value.copy(
            likeModel = _detailModalState.value.likeModel.copy(price = price)
        )
    }

    fun updateIsEnabled(){
        _detailModalState.value = _detailModalState.value.copy(
            isEnabled = _detailModalState.value.likeModel.isEnabled
        )
    }

    fun onTempatureButtonClick(temperatureType: TemperatureType) {
        _detailModalState.value = _detailModalState.value.copy(
            likeModel = _detailModalState.value.likeModel.copy(temperature = temperatureType.number)
        )
    }

    fun onSizeButtonClick(sizeType: SizeType) {
        _detailModalState.value = _detailModalState.value.copy(
            likeModel = _detailModalState.value.likeModel.copy(size = sizeType.number)
        )
    }

    fun onCoffeeBeanButtonClick(coffeeBeanType: CoffeeBeanType) {
        _detailModalState.value = _detailModalState.value.copy(
            likeModel = _detailModalState.value.likeModel.copy(coffeeBean = coffeeBeanType.number)
        )
    }

    fun onPickUpButtonClick(pickUpType: PickUpType) {
        _detailModalState.value = _detailModalState.value.copy(
            likeModel = _detailModalState.value.likeModel.copy(togo = pickUpType.number)
        )
    }

    fun onPersonalCupButtonClick(personalCup: Boolean) {
        _detailModalState.value = _detailModalState.value.copy(
            likeModel = _detailModalState.value.likeModel.copy(personal = personalCup)
        )
    }

    fun snackBarListActionButtonClick() = viewModelScope.launch {
        _sideEffect.emit(DetailModalSideEffect.NavigateToMyMenu)
    }

    fun updateIsShowBottomSheet() {
        _detailState.value = _detailState.value.copy(isShowBottomSheet = !_detailState.value.isShowBottomSheet)
    }

    fun onClickOrderButton() = viewModelScope.launch {
        _sideEffect.emit(DetailModalSideEffect.OnClickOrderButton)
    }
}