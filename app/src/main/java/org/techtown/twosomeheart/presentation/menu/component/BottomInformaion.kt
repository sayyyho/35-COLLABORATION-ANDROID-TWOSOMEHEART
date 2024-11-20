package org.techtown.twosomeheart.presentation.menu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun BottomInformaion(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(Black)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(top = 20.dp, bottom = 14.dp)
        ) {
            Text(
                stringResource(R.string.menu_ordered_store),
                style = TwosomeHeartTypography.caption1M12,
                color = White
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    stringResource(R.string.menu_ordered_store_name),
                    style = TwosomeHeartTypography.body1B14,
                    color = White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    stringResource(R.string.menu_ordered_store_distance),
                    style = TwosomeHeartTypography.caption1B12,
                    color = White
                )
            }
        }
        Text(
            text = stringResource(R.string.menu_change),
            style = TwosomeHeartTypography.body2R13,
            modifier = Modifier
                .padding(top = 23.dp, bottom = 20.dp)
                .border(width = 1.dp, color = White)
                .padding(vertical = 4.dp, horizontal = 11.dp),
            color = White
        )
    }
}

@Preview
@Composable
fun BottomInformationPreview() {
    TwosomeHeartTheme {
        BottomInformaion()
    }
}
