package org.techtown.twosomeheart.presentation.option

import org.techtown.twosomeheart.presentation.option.model.Option

data class OptionState(
    val expandedOption : Option? = null,
    val shotQuantity : Int = 0,
    val vanilaSyrupQuantity : Int = 0,
    val hazelnutsSyrupQuantity : Int = 0,
    val caramelSyrupQuantity : Int = 0,
    val creamQuantity : Int = 0,
    val caramelDrizzleQuantity : Int = 0,
    val chocolateDrizzleQuantity : Int = 0,
    var totalPrice : Int = 0
)
