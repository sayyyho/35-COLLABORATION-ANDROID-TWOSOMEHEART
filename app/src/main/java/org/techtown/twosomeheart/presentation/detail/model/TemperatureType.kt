package org.techtown.twosomeheart.presentation.detail.model

enum class TemperatureType(val type: String, val number: Int) {
    HOT("핫", 0),
    ICE("아이스", 1),
    NOTHING("선택 안함", -1)
}