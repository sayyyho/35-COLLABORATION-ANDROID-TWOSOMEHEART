package org.techtown.twosomeheart.presentation.mymenu.model

import androidx.annotation.DrawableRes

data class MyMenuModel(
    val menuName: String,
    val menuPrice: Int,
    @DrawableRes val menuImage: Int,
    val menuOption: String,
    val isChecked: Boolean,
)
