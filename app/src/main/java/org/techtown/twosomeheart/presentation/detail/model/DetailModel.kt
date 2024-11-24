package org.techtown.twosomeheart.presentation.detail.model

data class DetailModel(
    val menuId: Long,
    val menuName: String,
    val menuStatus: String,
    val menuDescription: String,
    val menuPrice: Int,
    val menuCaution: String?,
    val menuNutrition: List<String>?,
    val menuAllergy: String?,
    val menuImageUrl: String
)