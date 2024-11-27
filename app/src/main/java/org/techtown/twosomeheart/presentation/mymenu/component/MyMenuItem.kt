package org.techtown.twosomeheart.presentation.mymenu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.ui.theme.TwosomeHeartColors
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import coil.compose.AsyncImage
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.core.util.PriceFormatter

@Composable
fun MyMenuItem(
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    onCheckedChange: () -> Unit,
    menuName: String,
    menuPrice: Int,
    menuImage: String,
    menuOption: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(TwosomeHeartColors.White)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(
                if (isChecked) R.drawable.ic_mymenu_checkbox_select else R.drawable.ic_modal_checkbox_diselect
            ),
            contentDescription = "",
            tint = Color.Unspecified,
            modifier = Modifier.noRippleClickable { onCheckedChange() }
        )
        Row(
            modifier = modifier
                .padding(top = 10.dp, bottom = 17.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = menuImage,
                contentDescription = stringResource(R.string.menu_description_image),
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(87.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(bottom = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Column {
                        Text(
                            text = menuName,
                            style = TwosomeHeartTypography.body1R14
                        )
                        Text(
                            text = PriceFormatter.formatPriceWon(menuPrice),
                            style = TwosomeHeartTypography.title1B16
                        )
                    }
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_mymenu_move),
                        contentDescription = stringResource(R.string.my_menu_item_move_ic),
                        tint = Color.Unspecified,
                    )
                }
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = menuOption,
                    style = TwosomeHeartTypography.caption1R12Tight
                )
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 23.dp),
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .border(width = 1.dp, color = TwosomeHeartColors.Black)
                    .padding(vertical = 8.5.dp),
                text = "장바구니 담기",
                style = TwosomeHeartTypography.body2B13,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(3.dp))
            Text(
                modifier = Modifier
                    .weight(1f)
                    .border(width = 1.dp, color = TwosomeHeartColors.Black)
                    .padding(vertical = 8.5.dp),
                text = "지금 바로 주문",
                style = TwosomeHeartTypography.body2B13,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview
@Composable
fun MyMenuItemPreview() {
    TwosomeHeartTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            MyMenuItem(
                menuName = "바나나샷 아메리카노",
                menuPrice = 5800,
                menuImage = "https://github.com/user-attachments/assets/4b7b216c-0ea9-4034-a88c-953a6f761f98",
                menuOption = "아이스/라지/블랙그라운드/포장",
                isChecked = false,
                onCheckedChange = {}
            )
        }
    }
}