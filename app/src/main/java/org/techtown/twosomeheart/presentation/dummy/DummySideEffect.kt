package org.techtown.twosomeheart.presentation.dummy

import androidx.annotation.StringRes

sealed class DummySideEffect {
    data class ShowToast(@StringRes val message: Int) : DummySideEffect()
}
