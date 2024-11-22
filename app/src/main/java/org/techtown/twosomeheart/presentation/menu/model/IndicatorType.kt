package org.techtown.twosomeheart.presentation.menu.model

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

enum class CategoryIndicatorType(val type: String) {
    NEW("NEW"),
    RECOMMENDSET("추천세트"),
    BEVERAGE("커피/음료"),
    DESSERT("디저트"),
    FOOD("푸드"),
    GOODS("상품")
}

enum class BeverageIndicatorType(val type: String) {
    COFFEE("커피"),
    DECAF("디카페인커피"),
    BEVERAGE("음료"),
    TEA("티/티라떼"),
    ICECREAM("아이스크림")
}

enum class IndicatorType(val type: PersistentList<String>) {
    CATEGORY(
        type = persistentListOf(
            CategoryIndicatorType.NEW.type,
            CategoryIndicatorType.RECOMMENDSET.type,
            CategoryIndicatorType.BEVERAGE.type,
            CategoryIndicatorType.DESSERT.type,
            CategoryIndicatorType.FOOD.type,
            CategoryIndicatorType.GOODS.type,
        )
    ),
    BEVERAGE(
        type = persistentListOf(
            BeverageIndicatorType.COFFEE.type,
            BeverageIndicatorType.DECAF.type,
            BeverageIndicatorType.BEVERAGE.type,
            BeverageIndicatorType.TEA.type,
            BeverageIndicatorType.ICECREAM.type,
        )
    )
}
