package org.techtown.twosomeheart.presentation.detail.model

enum class SizeType(val type: String, val number: Int) {
    REGULAR("레귤러", 0),
    LARGE("라지", 1),
    NOTHING("선택 안함", -1)
}