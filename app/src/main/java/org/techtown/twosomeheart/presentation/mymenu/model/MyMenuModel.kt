package org.techtown.twosomeheart.presentation.mymenu.model

import androidx.annotation.DrawableRes

data class MyMenuModel(
    val menuName: String,
    val menuPrice: Int,
    val menuImage: String,
    val menuOption: String,
    val isChecked: Boolean,
    val id: Long
)

data class SelectedSummary(
    val totalPrice: Int,
    val itemCount: Int
)