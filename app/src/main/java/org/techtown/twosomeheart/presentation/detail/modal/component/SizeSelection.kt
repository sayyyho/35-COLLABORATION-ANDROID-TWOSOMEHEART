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
import org.techtown.twosomeheart.presentation.detail.model.SizeType
import org.techtown.twosomeheart.presentation.detail.model.TemperatureType
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray30
import org.techtown.twosomeheart.ui.theme.Gray60
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White


@Composable
fun SizeSelection(
    onClick: (SizeType) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedType = remember { mutableStateOf<SizeType?>(null) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 16.dp)
    ) {

        Text(
            text = stringResource(R.string.menu_detail_modal_size_text),
            style = TwosomeHeartTypography.body1B14,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SizeButton(
                sizeType = SizeType.REGULAR,
                isSelected = selectedType.value == SizeType.REGULAR,
                onClick = {
                    if (selectedType.value != SizeType.REGULAR) {
                        selectedType.value = SizeType.REGULAR
                        onClick(SizeType.REGULAR)
                    }
                },
                modifier = Modifier
                    .zIndex(
                        if (selectedType.value == SizeType.REGULAR) 1f else 0f
                    )
            )

            SizeButton(
                sizeType = SizeType.LARGE,
                isSelected = selectedType.value == SizeType.LARGE,
                onClick = {
                    if (selectedType.value != SizeType.LARGE) {
                        selectedType.value = SizeType.LARGE
                        onClick(SizeType.LARGE)
                    }
                },
                modifier = Modifier
                    .offset {
                        IntOffset(
                            x = (-2).dp.roundToPx(),
                            y = 0
                        )
                    }
                    .zIndex(
                        if (selectedType.value == SizeType.LARGE) 1f else 0f
                    )
            )
        }

    }
}

@Composable
fun SizeButton(
    sizeType: SizeType,
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
                shape = when (sizeType) {
                    SizeType.REGULAR -> {
                        RoundedCornerShape(
                            topStart = 5.dp,
                            topEnd = 0.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 5.dp
                        )
                    }
                    SizeType.LARGE -> RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 5.dp,
                        bottomEnd = 5.dp,
                        bottomStart = 0.dp
                    )
                }
            )
            .background(
                color = White,
                shape = when (sizeType) {
                    SizeType.REGULAR -> RoundedCornerShape(
                        topStart = 5.dp,
                        topEnd = 0.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 5.dp
                    )
                    SizeType.LARGE -> RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 5.dp,
                        bottomEnd = 5.dp,
                        bottomStart = 0.dp
                    )
                }
            )
            .padding(
                when (sizeType) {
                    SizeType.REGULAR -> {
                        if(isSelected){
                            PaddingValues(
                                top = 16.dp,
                                bottom = 10.dp,
                                start = 38.dp,
                                end = 37.dp
                            )
                        } else {
                            PaddingValues(
                                top = 16.dp,
                                bottom = 10.dp,
                                start = 40.dp,
                                end = 39.dp
                            )
                        }
                    }
                    SizeType.LARGE -> {
                        if(isSelected){
                            PaddingValues(
                                top = 12.dp,
                                bottom = 10.dp,
                                start = 45.dp,
                                end = 46.dp
                            )
                        } else {
                            PaddingValues(
                                top = 12.dp,
                                bottom = 10.dp,
                                start = 43.dp,
                                end = 44.dp
                            )
                        }
                    }
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when(sizeType){
                SizeType.REGULAR -> {
                    Icon(
                        imageVector = if (isSelected) ImageVector.vectorResource(R.drawable.ic_modal_regular_select) else ImageVector.vectorResource(R.drawable.ic_modal_regular_diselect),
                        contentDescription = stringResource(R.string.menu_detail_modal_size_regular_text)
                    )
                    Spacer(Modifier.height(5.dp))

                    Text(
                        text = stringResource(R.string.menu_detail_modal_size_regular_text),
                        color = if (isSelected) Black else Gray60,
                        style = if (isSelected) TwosomeHeartTypography.body2B13 else TwosomeHeartTypography.body2R13,
                        textAlign = TextAlign.Center
                    )
                }

                SizeType.LARGE -> {
                    Icon(
                        imageVector = if (isSelected) ImageVector.vectorResource(R.drawable.ic_modal_large_select) else ImageVector.vectorResource(R.drawable.ic_modal_large_diselect),
                        contentDescription = stringResource(R.string.menu_detail_modal_size_large_text)
                    )
                    Spacer(Modifier.height(1.dp))

                    Text(
                        text = stringResource(R.string.menu_detail_modal_size_large_text),
                        color = if (isSelected) Black else Gray60,
                        style = if (isSelected) TwosomeHeartTypography.body2B13 else TwosomeHeartTypography.body2R13,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SizeSelectionPreview() {
    SizeSelection(
        onClick = { }
    )
}