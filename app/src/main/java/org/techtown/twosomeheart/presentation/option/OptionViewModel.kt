package org.techtown.twosomeheart.presentation.option

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.techtown.twosomeheart.presentation.option.model.Option
import org.techtown.twosomeheart.presentation.option.model.OptionType

class OptionViewModel : ViewModel() {
    private val _state = MutableStateFlow(OptionState())
    val state: StateFlow<OptionState>
        get() = _state.asStateFlow()

    fun updateExpandedOption(option: Option) {
        _state.value = _state.value.copy(
            expandedOption = if (_state.value.expandedOption != option) option else null
        )
    }

    fun plusOptionQuantity(optionType: OptionType, optionName: String) {
        when (optionType) {
            OptionType.SHOT -> _state.value = _state.value.copy(
                shotQuantity = _state.value.shotQuantity + 1
            )

            OptionType.SYRUP -> {
                when (optionName) {
                    "바닐라시럽" -> {
                        _state.value = _state.value.copy(
                            vanilaSyrupQuantity = _state.value.vanilaSyrupQuantity + 1
                        )
                    }

                    "헤이즐넛시럽" -> {
                        _state.value = _state.value.copy(
                            hazelnutsSyrupQuantity = _state.value.hazelnutsSyrupQuantity + 1
                        )
                    }

                    "캬라멜시럽" -> {
                        _state.value = _state.value.copy(
                            caramelSyrupQuantity = _state.value.caramelSyrupQuantity + 1
                        )
                    }
                }
            }

            OptionType.CREAM -> _state.value = _state.value.copy(
                creamQuantity = _state.value.creamQuantity + 1
            )

            OptionType.DRIZZLE -> {
                when (optionName) {
                    "캬라멜드리즐" -> {
                        _state.value = _state.value.copy(
                            caramelDrizzleQuantity = _state.value.caramelDrizzleQuantity + 1
                        )
                    }

                    "초콜릿드리즐" -> {
                        _state.value = _state.value.copy(
                            chocolateDrizzleQuantity = _state.value.chocolateDrizzleQuantity + 1
                        )
                    }
                }
            }
        }
    }

    fun minusOptionQuantity(optionType: OptionType, optionName: String) {
        when (optionType) {
            OptionType.SHOT -> _state.value = _state.value.copy(
                shotQuantity = _state.value.shotQuantity - 1
            )

            OptionType.SYRUP -> {
                when (optionName) {
                    "바닐라시럽" -> {
                        _state.value = _state.value.copy(
                            vanilaSyrupQuantity = _state.value.vanilaSyrupQuantity - 1
                        )
                    }

                    "헤이즐넛시럽" -> {
                        _state.value = _state.value.copy(
                            hazelnutsSyrupQuantity = _state.value.hazelnutsSyrupQuantity - 1
                        )
                    }

                    "캬라멜시럽" -> {
                        _state.value = _state.value.copy(
                            caramelSyrupQuantity = _state.value.caramelSyrupQuantity - 1
                        )
                    }
                }
            }

            OptionType.CREAM -> _state.value = _state.value.copy(
                creamQuantity = _state.value.creamQuantity - 1
            )

            OptionType.DRIZZLE -> {
                when (optionName) {
                    "캬라멜드리즐" -> {
                        _state.value = _state.value.copy(
                            caramelDrizzleQuantity = _state.value.caramelDrizzleQuantity - 1
                        )
                    }

                    "초콜릿드리즐" -> {
                        _state.value = _state.value.copy(
                            chocolateDrizzleQuantity = _state.value.chocolateDrizzleQuantity - 1
                        )
                    }
                }
            }
        }
    }

    fun calculateTotalPrice() {
        _state.value = _state.value.copy(
            totalPrice =
            _state.value.shotQuantity * OptionType.SHOT.type.first().second
                    + _state.value.vanilaSyrupQuantity * OptionType.SYRUP.type.first { it.first == "바닐라시럽" }.second
                    + _state.value.hazelnutsSyrupQuantity * OptionType.SYRUP.type.first { it.first == "헤이즐넛시럽" }.second
                    + _state.value.caramelSyrupQuantity * OptionType.SYRUP.type.first { it.first == "캬라멜시럽" }.second
                    + _state.value.creamQuantity * OptionType.CREAM.type.first().second
                    + _state.value.caramelDrizzleQuantity * OptionType.DRIZZLE.type.first { it.first == "캬라멜드리즐" }.second
                    + _state.value.chocolateDrizzleQuantity * OptionType.DRIZZLE.type.first { it.first == "초콜릿드리즐" }.second
        )
    }

    fun resetTotalPrice() {
        _state.value = _state.value.copy(
            expandedOption = null,
            totalPrice = 0,
            shotQuantity = 0,
            vanilaSyrupQuantity = 0,
            hazelnutsSyrupQuantity = 0,
            caramelSyrupQuantity = 0,
            creamQuantity = 0,
            caramelDrizzleQuantity = 0,
            chocolateDrizzleQuantity = 0,
        )
    }
}
