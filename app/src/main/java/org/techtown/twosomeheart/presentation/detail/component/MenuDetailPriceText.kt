package org.techtown.twosomeheart.presentation.detail.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography

@Composable
fun MenuDetailPriceText(
    price: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxHeight()
    ) {
        Text(
            text = price,
            style = TwosomeHeartTypography.head1B24,
            color = Black,
            modifier = Modifier.padding(vertical = 8.5.dp)
        )
        Text(
            text = stringResource(R.string.won),
            style = TwosomeHeartTypography.head4B18,
            color = Black,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}