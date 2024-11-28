package org.techtown.twosomeheart.presentation.detail.model

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

enum class TabType(val type: PersistentList<String>){
    SIZE(
        type = persistentListOf(
            SizeType.REGULAR.type,
            SizeType.LARGE.type
        )
    ),
    TEMPERATURE(
        type = persistentListOf(
            TemperatureType.HOT.type,
            TemperatureType.ICE.type
        )
    )
}
