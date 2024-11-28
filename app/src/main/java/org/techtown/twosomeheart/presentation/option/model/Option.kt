package org.techtown.twosomeheart.presentation.option.model

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

enum class TabOption {
    LEFT, RIGHT
}

enum class Option(val type: String) {
    SHOT("샷"),
    SYRUP("시럽"),
    CREAM("휘핑크림"),
    DRIZZLE("드리즐")
}

enum class OptionType(val type: PersistentList<Pair<String, Int>>) {
    SHOT(persistentListOf(("샷" to 500))),
    SYRUP(
        persistentListOf(
            "바닐라시럽" to 500,
            "헤이즐넛시럽" to 500,
            "캬라멜시럽" to 500
        )
    ),
    CREAM(persistentListOf("휘핑크림" to 500)),
    DRIZZLE(
        persistentListOf(
            "캬라멜드리즐" to 500,
            "초콜릿드리즐" to 500
        )
    ),
}
