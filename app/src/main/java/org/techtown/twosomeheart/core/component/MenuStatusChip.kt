package org.techtown.twosomeheart.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Red40
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun MenuStatusChip(
    modifier: Modifier = Modifier,
    isBestMenu: Boolean = false
) {
    Text(
        text = if (isBestMenu) stringResource(R.string.menu_status_best) else stringResource(R.string.menu_status_new),
        style = TwosomeHeartTypography.caption3R10,
        color = White,
        modifier = modifier
            .background(
                shape = RoundedCornerShape(size = 2.dp),
                color = if (isBestMenu) Black else Red40
            )
            .padding(
                start = if (isBestMenu) 3.5.dp else 3.dp,
                end = if (isBestMenu) 2.5.dp else 3.dp,
            )

    )
}

@Preview(showBackground = true)
@Composable
fun MenuStatusChipPreview() {
    TwosomeHeartTheme {
        Column{
            MenuStatusChip(isBestMenu = true)
            Spacer(Modifier.height(8.dp))
            MenuStatusChip(isBestMenu = false)
        }
    }
}