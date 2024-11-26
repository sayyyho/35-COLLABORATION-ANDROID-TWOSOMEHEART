package org.techtown.twosomeheart.presentation.mymenu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.core.component.BlackBottomButton
import org.techtown.twosomeheart.ui.theme.TwosomeHeartColors
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography

@Composable
fun MyBottomSheet(
    price: Int,
    count: Int,
    place: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 18.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .clip(shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp))
            .background(Color.White)
            .padding(15.dp, 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "주문매장",
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
                text = "주문금액",
                style = TwosomeHeartTypography.body2R13
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "${price}원",
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
            text = "주문하기",
            color = TwosomeHeartColors.Red30,
            padding = 14
        )
    }
}

@Preview
@Composable
fun MyBottomSheetPreview() {
    TwosomeHeartTheme {
        MyBottomSheet(price = 5500, count = 1, place = "삼성역점")
    }
}