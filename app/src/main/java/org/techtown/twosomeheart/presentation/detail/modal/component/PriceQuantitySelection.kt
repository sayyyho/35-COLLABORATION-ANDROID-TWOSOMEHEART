package org.techtown.twosomeheart.presentation.detail.modal.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.core.component.ModalQuantityButton
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun PriceQuantitySelection(
    price: String,
    onQuantityButtonClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {

    val quantity = remember{ mutableIntStateOf(1) }

    Column (
        modifier = modifier
            .fillMaxWidth()
            .background(White)
    ) {

        HorizontalDivider(
            thickness = 1.dp,
            color = Black
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = price,
                style = TwosomeHeartTypography.title1B16,
                color = Black,
                modifier = Modifier.padding(
                    top = 28.dp
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            ModalQuantityButton(
                onClickMinusButton = {
                    quantity.intValue -= 1
                    onQuantityButtonClick(quantity.intValue)
                },
                onClickPlusButton = {
                    quantity.intValue += 1
                    onQuantityButtonClick(quantity.intValue)
                },
                amount = quantity.intValue,
                modifier = Modifier
                    .padding(
                        top = 24.dp
                    )
            )
        }
    }
}

@Preview
@Composable
fun PriceQuantitySelectionPreview() {
    PriceQuantitySelection(
        price = "1,000원",
        onQuantityButtonClick = {}
    )
}