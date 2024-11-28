package org.techtown.twosomeheart.presentation.detail.modal.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.presentation.detail.model.SizeType
import org.techtown.twosomeheart.presentation.detail.model.TemperatureType
import org.techtown.twosomeheart.ui.theme.Blue10
import org.techtown.twosomeheart.ui.theme.Gray30
import org.techtown.twosomeheart.ui.theme.Gray60
import org.techtown.twosomeheart.ui.theme.Red40
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun TemperatureSelection(
    onClick: (TemperatureType) -> Unit,
    modifier: Modifier = Modifier,
) {
    val selectedType = remember { mutableStateOf(TemperatureType.NOTHING) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 16.dp)
    ) {

        Text(
            text = stringResource(R.string.menu_detail_modal_temperature_text),
            style = TwosomeHeartTypography.body1B14,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            TemperatureButton(
                temperatureType = TemperatureType.HOT,
                isSelected = selectedType.value == TemperatureType.HOT,
                onClick = {
                    if (selectedType.value != TemperatureType.HOT) {
                        selectedType.value = TemperatureType.HOT
                        onClick(TemperatureType.HOT)
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .zIndex(
                        if (selectedType.value == TemperatureType.HOT) 1f else 0f
                    )
            )

            TemperatureButton(
                temperatureType = TemperatureType.ICE,
                isSelected = selectedType.value == TemperatureType.ICE,
                onClick = {
                    if (selectedType.value != TemperatureType.ICE) {
                        selectedType.value = TemperatureType.ICE
                        onClick(TemperatureType.ICE)
                    }
                },
                modifier = Modifier
                    .offset {
                        IntOffset(
                            x = (-2).dp.roundToPx(),
                            y = 0
                        )
                    }
                    .weight(1f)
                    .zIndex(
                        if (selectedType.value == TemperatureType.ICE) 1f else 0f
                    )
            )
        }
    }
}


@Composable
fun TemperatureButton(
    temperatureType: TemperatureType,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .noRippleClickable { onClick() }
            .border(
                width = 1.dp,
                color = if (isSelected) Color.Transparent else Gray30,
                shape = when (temperatureType) {
                    TemperatureType.HOT -> RoundedCornerShape(
                        topStart = 5.dp,
                        topEnd = 0.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 5.dp
                    )
                    TemperatureType.ICE -> RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 5.dp,
                        bottomEnd = 5.dp,
                        bottomStart = 0.dp
                    )

                    else -> return
                }
            )
            .background(
                color = if (isSelected) {
                    when (temperatureType) {
                        TemperatureType.HOT -> Red40
                        TemperatureType.ICE -> Blue10
                        else -> return
                    }
                } else {
                    White
                },
                shape = when (temperatureType) {
                    TemperatureType.HOT -> RoundedCornerShape(
                        topStart = 5.dp,
                        topEnd = 0.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 5.dp
                    )
                    TemperatureType.ICE -> RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 5.dp,
                        bottomEnd = 5.dp,
                        bottomStart = 0.dp
                    )
                    else -> return
                }
            )
            .padding(
                when (temperatureType) {
                    TemperatureType.HOT -> {
                        PaddingValues(
                            top = 10.dp,
                            bottom = 9.dp,
                            start = 76.dp,
                            end = 76.dp
                        )
                    }
                    TemperatureType.ICE -> {
                        PaddingValues(
                            top = 10.dp,
                            bottom = 9.dp,
                            start = 64.dp,
                            end = 64.dp
                        )
                    }
                    else -> return
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = temperatureType.type,
            color = if (isSelected) White else Gray60,
            style = if (isSelected) TwosomeHeartTypography.body2B13 else TwosomeHeartTypography.body2R13,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun TemperatureSelectionPreview() {
    TemperatureSelection(
        onClick = { }
    )
}
