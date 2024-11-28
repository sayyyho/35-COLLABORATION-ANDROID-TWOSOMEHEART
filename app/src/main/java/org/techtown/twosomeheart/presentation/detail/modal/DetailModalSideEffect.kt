package org.techtown.twosomeheart.presentation.detail.modal

import androidx.annotation.StringRes

sealed class DetailModalSideEffect {
    data class SnackBar(@StringRes val message: Int) : DetailModalSideEffect()
    data object NavigateToMyMenu: DetailModalSideEffect()
    data object OnClickOrderButton: DetailModalSideEffect()
}