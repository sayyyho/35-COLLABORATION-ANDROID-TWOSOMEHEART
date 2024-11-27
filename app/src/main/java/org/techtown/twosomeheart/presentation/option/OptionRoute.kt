package org.techtown.twosomeheart.presentation.option

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.component.Topbar
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.presentation.option.component.BottomTotalPrice
import org.techtown.twosomeheart.presentation.option.component.OptionItem
import org.techtown.twosomeheart.presentation.option.component.OptionQuantityRow
import org.techtown.twosomeheart.presentation.option.component.TwoOptionTab
import org.techtown.twosomeheart.presentation.option.model.Option
import org.techtown.twosomeheart.presentation.option.model.OptionType
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun OptionRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: OptionViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(
        state.shotQuantity,
        state.vanilaSyrupQuantity,
        state.caramelSyrupQuantity,
        state.hazelnutsSyrupQuantity,
        state.creamQuantity,
        state.caramelDrizzleQuantity,
        state.chocolateDrizzleQuantity
    ) {
        viewModel.calculateTotalPrice()
    }

    OptionScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp,
        onClickPlusButton = viewModel::plusOptionQuantity,
        onClickMinusButton = viewModel::minusOptionQuantity,
        isExpanded = { option -> state.expandedOption == option },
        onClickExpandButton = viewModel::updateExpandedOption,
        shotQuantity = state.shotQuantity,
        vanilaSyrupQuantity = state.vanilaSyrupQuantity,
        caramelSyrupQuantity = state.caramelSyrupQuantity,
        hazelnutsSyrupQuantity = state.hazelnutsSyrupQuantity,
        creamQuantity = state.creamQuantity,
        caramelDrizzleQuantity = state.caramelDrizzleQuantity,
        chocolateDrizzleQuantity = state.chocolateDrizzleQuantity,
        totalPrice = state.totalPrice,
        resetTotalPrice = viewModel::resetTotalPrice
    )
}

@Composable
fun OptionScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    onClickMinusButton: (OptionType, String) -> Unit,
    onClickPlusButton: (OptionType, String) -> Unit,
    isExpanded: (Option) -> Boolean,
    onClickExpandButton: (Option) -> Unit,
    resetTotalPrice: () -> Unit,
    modifier: Modifier = Modifier,
    shotQuantity: Int = 0,
    vanilaSyrupQuantity: Int = 0,
    caramelSyrupQuantity: Int = 0,
    hazelnutsSyrupQuantity: Int = 0,
    creamQuantity: Int = 0,
    caramelDrizzleQuantity: Int = 0,
    chocolateDrizzleQuantity: Int = 0,
    totalPrice: Int = 0,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(White)
    ) {
        Topbar(
            text = stringResource(R.string.option_personal_option),
            trailingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_option_x),
                    contentDescription = stringResource(R.string.option_close),
                    modifier = Modifier.noRippleClickable(onClick = navigateUp)
                )
            }
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                OptionItem(
                    option = Option.SHOT,
                    optionType = OptionType.SHOT,
                    optionTypeQuantity = shotQuantity,
                    isExpanded = isExpanded(Option.SHOT),
                    updateExpandedState = { onClickExpandButton(Option.SHOT) },
                    optionText = buildOptionText(shotQuantity, "샷 시럽 추가"),
                    option1 = {
                        TwoOptionTab(
                            R.string.option_density,
                            R.string.option_normal,
                            R.string.option_lightly
                        )
                    },
                    option2 = {
                        OptionQuantityRow(
                            optionName = "샷",
                            optionPrice = 500,
                            optionType = OptionType.SHOT,
                            onClickMinusButton = { onClickMinusButton(OptionType.SHOT, "샷") },
                            onClickPlusButton = { onClickPlusButton(OptionType.SHOT, "샷") },
                            optionTypeQuantity = shotQuantity
                        )
                    }
                )

                OptionItem(
                    option = Option.SYRUP,
                    optionType = OptionType.SYRUP,
                    optionTypeQuantity = vanilaSyrupQuantity + caramelSyrupQuantity + hazelnutsSyrupQuantity,
                    isExpanded = isExpanded(Option.SYRUP),
                    updateExpandedState = { onClickExpandButton(Option.SYRUP) },
                    optionText = buildOptionText(
                        vanilaSyrupQuantity, "바닐라 시럽 추가",
                        hazelnutsSyrupQuantity, "헤이즐넛 시럽 추가",
                        caramelSyrupQuantity, "캬라멜 시럽 추가"
                    ),
                    option1 = {
                        OptionQuantityRow(
                            optionName = "바닐라시럽",
                            optionPrice = 500,
                            optionType = OptionType.SYRUP,
                            onClickMinusButton = { onClickMinusButton(OptionType.SYRUP, "바닐라시럽") },
                            onClickPlusButton = { onClickPlusButton(OptionType.SYRUP, "바닐라시럽") },
                            optionTypeQuantity = vanilaSyrupQuantity
                        )
                    },
                    option2 = {
                        OptionQuantityRow(
                            optionName = "헤이즐넛시럽",
                            optionPrice = 500,
                            optionType = OptionType.SYRUP,
                            onClickMinusButton = { onClickMinusButton(OptionType.SYRUP, "헤이즐넛시럽") },
                            onClickPlusButton = { onClickPlusButton(OptionType.SYRUP, "헤이즐넛시럽") },
                            optionTypeQuantity = hazelnutsSyrupQuantity
                        )
                    },
                    option3 = {
                        OptionQuantityRow(
                            optionName = "캬라멜시럽",
                            optionPrice = 500,
                            optionType = OptionType.SYRUP,
                            onClickMinusButton = { onClickMinusButton(OptionType.SYRUP, "캬라멜시럽") },
                            onClickPlusButton = { onClickPlusButton(OptionType.SYRUP, "캬라멜시럽") },
                            optionTypeQuantity = caramelSyrupQuantity
                        )
                    }
                )

                OptionItem(
                    option = Option.CREAM,
                    optionType = OptionType.CREAM,
                    optionTypeQuantity = creamQuantity,
                    isExpanded = isExpanded(Option.CREAM),
                    updateExpandedState = { onClickExpandButton(Option.CREAM) },
                    optionText = buildOptionText(creamQuantity, "휘핑크림 추가"),
                    option1 = {
                        OptionQuantityRow(
                            optionName = "휘핑크림",
                            optionPrice = 500,
                            optionType = OptionType.CREAM,
                            onClickMinusButton = { onClickMinusButton(OptionType.CREAM, "휘핑크림") },
                            onClickPlusButton = { onClickPlusButton(OptionType.CREAM, "휘핑크림") },
                            optionTypeQuantity = creamQuantity
                        )
                    }
                )

                OptionItem(
                    option = Option.DRIZZLE,
                    optionType = OptionType.DRIZZLE,
                    optionTypeQuantity = caramelDrizzleQuantity + chocolateDrizzleQuantity,
                    isExpanded = isExpanded(Option.DRIZZLE),
                    updateExpandedState = { onClickExpandButton(Option.DRIZZLE) },
                    optionText = buildOptionText(
                        caramelDrizzleQuantity, "캬라멜드리즐 추가",
                        chocolateDrizzleQuantity, "초콜릿드리즐 추가"
                    ),
                    option1 = {
                        OptionQuantityRow(
                            optionName = "캬라멜드리즐",
                            optionPrice = 500,
                            optionType = OptionType.DRIZZLE,
                            onClickMinusButton = {
                                onClickMinusButton(
                                    OptionType.DRIZZLE,
                                    "캬라멜드리즐"
                                )
                            },
                            onClickPlusButton = { onClickPlusButton(OptionType.DRIZZLE, "캬라멜드리즐") },
                            optionTypeQuantity = caramelDrizzleQuantity
                        )
                    },
                    option2 = {
                        OptionQuantityRow(
                            optionName = "초콜릿드리즐",
                            optionPrice = 500,
                            optionType = OptionType.DRIZZLE,
                            onClickMinusButton = {
                                onClickMinusButton(
                                    OptionType.DRIZZLE,
                                    "초콜릿드리즐"
                                )
                            },
                            onClickPlusButton = { onClickPlusButton(OptionType.DRIZZLE, "초콜릿드리즐") },
                            optionTypeQuantity = chocolateDrizzleQuantity
                        )
                    }
                )
            }
        }

        BottomTotalPrice(totalPrice = totalPrice, onClickResetButton = resetTotalPrice)
    }
}

@Composable
fun buildOptionText(vararg quantitiesAndLabels: Any): String {
    val builder = StringBuilder()
    for (i in quantitiesAndLabels.indices step 2) {
        val quantity = quantitiesAndLabels[i] as Int
        val label = quantitiesAndLabels[i + 1] as String
        if (quantity > 0) builder.append("$label $quantity 개, ")
    }
    return builder.dropLast(2).toString()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TwosomeHeartTheme {
        OptionRoute(paddingValues = PaddingValues(0.dp), navigateUp = {})
    }
}
