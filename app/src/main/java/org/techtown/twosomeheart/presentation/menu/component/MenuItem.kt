package org.techtown.twosomeheart.presentation.menu.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.component.MenuStatusChip
import org.techtown.twosomeheart.core.util.PriceFormatter
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun MenuItem(
    menuName: String,
    menuPrice: Int,
    @DrawableRes menuImage: Int,
    modifier: Modifier = Modifier,
    isBestMenu: Boolean = false,
) {
    Row(
        modifier = modifier
            .background(White)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(menuImage),
            contentDescription = stringResource(R.string.menu_description_image),
        )

        Spacer(modifier = Modifier.width(14.dp))

        Column {
            MenuStatusChip(isBestMenu = isBestMenu)

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = menuName,
                style = TwosomeHeartTypography.title2B15,
                color = Black
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = buildAnnotatedString {
                    append(PriceFormatter.formatPrice(menuPrice))
                    withStyle(style = TwosomeHeartTypography.body2R13.toSpanStyle()) {
                        append(stringResource(R.string.won))
                    }
                },
                style = TwosomeHeartTypography.title2B15,
                color = Black
            )
        }
    }
}

@Preview
@Composable
fun MenuItemPreview() {
    TwosomeHeartTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            MenuItem(
                menuName = "바나나 샷 라떼",
                menuPrice = 1000,
                menuImage = R.drawable.img_menu_banana_latte,
                isBestMenu = true
            )
            MenuItem(
                menuName = "바나나 샷 라떼",
                menuPrice = 1000,
                menuImage = R.drawable.img_menu_banana_latte,
            )
        }
    }
}
