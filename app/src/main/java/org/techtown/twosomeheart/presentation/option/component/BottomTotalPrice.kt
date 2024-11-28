package org.techtown.twosomeheart.presentation.option.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.component.BlackBottomButton
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.core.util.PriceFormatter
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Red40
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun BottomTotalPrice(
    onClickResetButton: () -> Unit,
    modifier: Modifier = Modifier,
    totalPrice: Int = 0
) {
    Column(
        modifier = modifier
            .background(White)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 15.dp)
    ) {
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .background(Black)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Text(
                    text = PriceFormatter.formatPrice(totalPrice),
                    style = TwosomeHeartTypography.head1B24,
                    color = Black
                )

                Text(
                    text = stringResource(R.string.won),
                    style = TwosomeHeartTypography.head2R22,
                    color = Black,
                    modifier = Modifier.padding(start = 3.dp)
                )
            }
            Row {
                Text(
                    text = stringResource(R.string.option_reset),
                    style = TwosomeHeartTypography.caption1R12Tight,
                    color = Red40
                )

                Icon(
                    imageVector = ImageVector.vectorResource(
                        R.drawable.ic_option_reset
                    ),
                    contentDescription = stringResource(R.string.option_reset),
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .noRippleClickable(onClick = onClickResetButton)
                )
            }
        }
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        BlackBottomButton(
            text = stringResource(R.string.option_select)
        )
    }
}

@Preview
@Composable
fun TotalPricePreview() {
    TwosomeHeartTheme {
        BottomTotalPrice(
            onClickResetButton = {}
        )
    }
}
