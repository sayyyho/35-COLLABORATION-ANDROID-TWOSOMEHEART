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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.presentation.detail.model.PickUpType
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray30
import org.techtown.twosomeheart.ui.theme.Gray60
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun PickUpSelection(
    onClick: (PickUpType) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedType = remember { mutableStateOf(PickUpType.NOTHING) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 16.dp)
    ) {

        Row {
            Text(
                text = stringResource(R.string.menu_detail_modal_pickup_text),
                style = TwosomeHeartTypography.body1B14,
                modifier = Modifier.padding(top = 1.5.dp)
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_modal_caution),
                contentDescription = stringResource(R.string.menu_detail_modal_pickup_caution),
                tint = Color.Unspecified
            )
        }


        Spacer(modifier = Modifier.height(9.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            PickUpButton(
                pickUpType = PickUpType.TOGO,
                isSelected = selectedType.value == PickUpType.TOGO,
                onClick = {
                    if (selectedType.value != PickUpType.TOGO) {
                        selectedType.value = PickUpType.TOGO
                        onClick(PickUpType.TOGO)
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .zIndex(
                        if (selectedType.value == PickUpType.TOGO) 1f else 0f
                    )
            )

            PickUpButton(
                pickUpType = PickUpType.FORHERE,
                isSelected = selectedType.value == PickUpType.FORHERE,
                onClick = {
                    if (selectedType.value != PickUpType.FORHERE) {
                        selectedType.value = PickUpType.FORHERE
                        onClick(PickUpType.FORHERE)
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .offset {
                        IntOffset(
                            x = (-2).dp.roundToPx(),
                            y = 0
                        )
                    }
                    .zIndex(
                        if (selectedType.value == PickUpType.FORHERE) 1f else 0f
                    )
            )
        }

    }
}

@Composable
fun PickUpButton(
    pickUpType: PickUpType,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .noRippleClickable { onClick() }
            .border(
                width = 1.dp,
                color = if (isSelected) Black else Gray30,
                shape = when (pickUpType) {
                    PickUpType.TOGO ->
                        RoundedCornerShape(
                            topStart = 5.dp,
                            topEnd = 0.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 5.dp
                        )
                    PickUpType.FORHERE -> RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 5.dp,
                        bottomEnd = 5.dp,
                        bottomStart = 0.dp
                    )
                    PickUpType.NOTHING -> return
                }
            )
            .background(
                color = White,
                shape = when (pickUpType) {
                    PickUpType.TOGO -> RoundedCornerShape(
                        topStart = 5.dp,
                        topEnd = 0.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 5.dp
                    )

                    PickUpType.FORHERE -> RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 5.dp,
                        bottomEnd = 5.dp,
                        bottomStart = 0.dp
                    )

                    else -> return
                }
            )
            .padding(
                when (pickUpType) {
                    PickUpType.TOGO -> {
                        PaddingValues(
                            top = 11.dp,
                            bottom = 10.dp,
                            start = 62.dp,
                            end = 61.dp
                        )
                    }

                    PickUpType.FORHERE -> {
                        PaddingValues(
                            top = 11.dp,
                            bottom = 10.dp,
                            start = 66.dp,
                            end = 67.dp
                        )
                    }

                    else -> return
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when(pickUpType){
                PickUpType.TOGO -> {
                    Text(
                        text = pickUpType.type,
                        color = if (isSelected) Black else Gray60,
                        style = if (isSelected) TwosomeHeartTypography.body2B13 else TwosomeHeartTypography.body2R13,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = stringResource(R.string.menu_detail_modal_pickup_togo_text),
                        color = if (isSelected) Black else Gray60,
                        style = TwosomeHeartTypography.caption2R11,
                        textAlign = TextAlign.Center
                    )
                }

                PickUpType.FORHERE -> {
                    Text(
                        text = pickUpType.type,
                        color = if (isSelected) Black else Gray60,
                        style = if (isSelected) TwosomeHeartTypography.body2B13 else TwosomeHeartTypography.body2R13,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = stringResource(R.string.menu_detail_modal_pickup_forhere_text),
                        color = if (isSelected) Black else Gray60,
                        style = TwosomeHeartTypography.caption2R11,
                        textAlign = TextAlign.Center
                    )
                }

                else -> return
            }
        }
    }
}

@Preview
@Composable
fun PickUpSelectionPreview() {
    PickUpSelection(
        onClick = { }
    )
}