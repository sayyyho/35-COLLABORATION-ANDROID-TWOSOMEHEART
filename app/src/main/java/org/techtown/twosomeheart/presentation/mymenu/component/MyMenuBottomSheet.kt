package org.techtown.twosomeheart.presentation.mymenu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.component.BlackBottomButton
import org.techtown.twosomeheart.core.util.PriceFormatter
import org.techtown.twosomeheart.ui.theme.TwosomeHeartColors
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography

@Composable
fun MyMenuBottomSheet(
    price: Int,
    count: String,
    place: String,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .shadow(
                elevation = 18.dp,
                shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp)
            )
            .clip(shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
            .fillMaxWidth()
            .background(TwosomeHeartColors.White)
            .padding(
                horizontal = 15.dp,
                vertical = 16.dp
            )
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(R.string.menu_ordered_store),
                    style = TwosomeHeartTypography.body2R13
                )
                Text(
                    text = place,
                    style = TwosomeHeartTypography.title1B16
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(R.string.my_menu_order_price),
                    style = TwosomeHeartTypography.body2R13
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = PriceFormatter.formatPriceWon(price),
                        style = TwosomeHeartTypography.title1B16
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text(
                        modifier = Modifier.padding(top = 3.dp),
                        text = "(${count}EA)",
                        style = TwosomeHeartTypography.caption1M12
                    )
                }

            }
            BlackBottomButton(
                text = stringResource(R.string.my_menu_order_message),
                color = TwosomeHeartColors.Red30,
                padding = 14
            )
        }
    }
}

@Preview
@Composable
fun MyBottomSheetPreview() {
    TwosomeHeartTheme {
        MyMenuBottomSheet(price = 5500, count = "1", place = "삼성역점")
    }
}