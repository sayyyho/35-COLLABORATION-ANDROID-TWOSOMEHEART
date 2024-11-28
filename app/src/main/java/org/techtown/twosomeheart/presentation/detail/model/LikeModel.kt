package org.techtown.twosomeheart.presentation.detail.model

data class LikeModel(
    val menuId: Long = 0,
    val name: String = "",
    val price: Int = 0,
    val temperature: Int = TemperatureType.NOTHING.number,
    val size: Int = SizeType.NOTHING.number,
    val coffeeBean: Int = CoffeeBeanType.BLACKGROUND.number,
    val togo: Int = PickUpType.NOTHING.number,
    val personal: Boolean = false
){
    val isEnabled : Boolean =
        menuId > 0 && name.isNotEmpty() && price > 0 && temperature != TemperatureType.NOTHING.number && size != SizeType.NOTHING.number && togo != PickUpType.NOTHING.number
}
