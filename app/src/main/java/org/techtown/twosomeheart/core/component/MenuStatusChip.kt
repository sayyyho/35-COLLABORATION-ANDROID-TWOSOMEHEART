package org.techtown.twosomeheart.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.ui.theme.TwosomeHeartColors
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography

@Composable
fun MenuStatusChip(
    modifier: Modifier = Modifier,
    isBestMenu: Boolean = false
) {
    Box(
        modifier = modifier
            .width(28.dp)
            .height(15.dp)
            .background(
                color =
                    if (isBestMenu) {
                        TwosomeHeartColors.Black
                    } else {
                        TwosomeHeartColors.Red40
                    }
                , shape = RoundedCornerShape(size = 2.dp))
            .padding(
                start = if (isBestMenu) 3.5.dp else 3.dp,
                end = if (isBestMenu) 3.5.dp else 3.dp
            )

    ) {
        Text(
            text = if (isBestMenu) stringResource(R.string.menu_status_best) else stringResource(R.string.menu_status_new),
            style = TwosomeHeartTypography.caption3R10,
            color = TwosomeHeartColors.White,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuStatusChipPreview() {
    MenuStatusChip()
}