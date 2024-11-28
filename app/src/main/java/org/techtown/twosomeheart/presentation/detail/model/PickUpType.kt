package org.techtown.twosomeheart.presentation.detail.model

enum class PickUpType(val type: String, val number: Int) {
    TOGO("포장", 0),
    FORHERE("매장", 1),
    NOTHING("선택 안함", -1)
}