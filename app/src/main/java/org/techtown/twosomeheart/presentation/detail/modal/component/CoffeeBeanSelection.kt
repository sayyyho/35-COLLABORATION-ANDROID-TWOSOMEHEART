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
import org.techtown.twosomeheart.presentation.detail.model.CoffeeBeanType
import org.techtown.twosomeheart.ui.theme.Blue20
import org.techtown.twosomeheart.ui.theme.Gray30
import org.techtown.twosomeheart.ui.theme.Gray60
import org.techtown.twosomeheart.ui.theme.Gray70
import org.techtown.twosomeheart.ui.theme.Orange
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun CoffeeBeanSelection(
    onClick: (CoffeeBeanType) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedType = remember { mutableStateOf(CoffeeBeanType.BLACKGROUND) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 16.dp)
    ) {

        Row {
            Text(
                text = stringResource(R.string.menu_detail_modal_coffeebean_text),
                style = TwosomeHeartTypography.body1B14,
                modifier = Modifier.padding(top = 1.5.dp)
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_modal_caution),
                contentDescription = stringResource(R.string.menu_detail_modal_coffeebean_caution),
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

            CoffeeBeanButton(
                coffeeBeanType = CoffeeBeanType.BLACKGROUND,
                isSelected = selectedType.value == CoffeeBeanType.BLACKGROUND,
                onClick = {
                    if (selectedType.value != CoffeeBeanType.BLACKGROUND) {
                        selectedType.value = CoffeeBeanType.BLACKGROUND
                        onClick(CoffeeBeanType.BLACKGROUND)
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .offset{
                        IntOffset(
                            x = 2.dp.roundToPx(),
                            y = 0
                        )
                    }
                    .zIndex(
                        if (selectedType.value == CoffeeBeanType.BLACKGROUND) 1f else 0f
                    )
            )

            CoffeeBeanButton(
                coffeeBeanType = CoffeeBeanType.AROMANOTE,
                isSelected = selectedType.value == CoffeeBeanType.AROMANOTE,
                onClick = {
                    if (selectedType.value != CoffeeBeanType.AROMANOTE) {
                        selectedType.value = CoffeeBeanType.AROMANOTE
                        onClick(CoffeeBeanType.AROMANOTE)
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .zIndex(
                        if (selectedType.value == CoffeeBeanType.AROMANOTE) 1f else 0f
                    )
            )

            CoffeeBeanButton(
                coffeeBeanType = CoffeeBeanType.DECAFFEINE,
                isSelected = selectedType.value == CoffeeBeanType.DECAFFEINE,
                onClick = {
                    if (selectedType.value != CoffeeBeanType.DECAFFEINE) {
                        selectedType.value = CoffeeBeanType.DECAFFEINE
                        onClick(CoffeeBeanType.DECAFFEINE)
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
                        if (selectedType.value == CoffeeBeanType.DECAFFEINE) 1f else 0f
                    )
            )
        }
    }
}

@Composable
fun CoffeeBeanButton(
    coffeeBeanType: CoffeeBeanType,
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
                shape = when (coffeeBeanType) {
                    CoffeeBeanType.BLACKGROUND -> RoundedCornerShape(
                        topStart = 5.dp,
                        topEnd = 0.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 5.dp
                    )

                    CoffeeBeanType.AROMANOTE -> RoundedCornerShape(0.dp)

                    CoffeeBeanType.DECAFFEINE -> RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 5.dp,
                        bottomEnd = 5.dp,
                        bottomStart = 0.dp
                    )
                }
            )
            .background(
                color = if (isSelected) {
                    when (coffeeBeanType) {
                        CoffeeBeanType.BLACKGROUND -> Gray70
                        CoffeeBeanType.AROMANOTE -> Orange
                        CoffeeBeanType.DECAFFEINE -> Blue20
                    }
                } else {
                    White
                },
                shape = when (coffeeBeanType) {
                    CoffeeBeanType.BLACKGROUND -> RoundedCornerShape(
                        topStart = 5.dp,
                        topEnd = 0.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 5.dp
                    )

                    CoffeeBeanType.AROMANOTE -> RoundedCornerShape(0.dp)

                    CoffeeBeanType.DECAFFEINE -> RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 5.dp,
                        bottomEnd = 5.dp,
                        bottomStart = 0.dp
                    )
                }
            )
            .padding(
                when (coffeeBeanType) {
                    CoffeeBeanType.BLACKGROUND -> {
                        PaddingValues(
                            top = 10.dp,
                            bottom = 9.dp,
                            start = 19.dp,
                            end = 18.dp
                        )
                    }
                    CoffeeBeanType.AROMANOTE -> {
                        PaddingValues(
                            top = 10.dp,
                            bottom = 9.dp,
                            start = 24.dp,
                            end = 25.dp
                        )
                    }
                    CoffeeBeanType.DECAFFEINE-> {
                        PaddingValues(
                            top = 10.dp,
                            bottom = 9.dp,
                            start = 16.dp,
                            end = 16.dp
                        )
                    }
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = coffeeBeanType.type,
            color = if (isSelected) White else Gray60,
            style = if (isSelected) TwosomeHeartTypography.body2B13 else TwosomeHeartTypography.body2R13,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun CoffeeBeanSelectionPreview() {
    CoffeeBeanSelection(
        onClick = { }
    )
}