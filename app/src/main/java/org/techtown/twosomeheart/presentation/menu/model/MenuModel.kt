package org.techtown.twosomeheart.presentation.menu.model

import androidx.annotation.DrawableRes

data class MenuModel(
    val menuName: String,
    val menuPrice: Int,
    @DrawableRes val menuImage: Int,
    val isBestMenu: Boolean = false
)
