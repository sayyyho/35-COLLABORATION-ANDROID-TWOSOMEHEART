package org.techtown.twosomeheart.presentation.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.ui.theme.Gray10
import org.techtown.twosomeheart.ui.theme.Gray70
import org.techtown.twosomeheart.ui.theme.Red30
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography

@Composable
fun MenuCautionChip(
    text: String,
    modifier: Modifier = Modifier,
    isAllergen: Boolean = false
) {
    Text(
        text = text,
        style = TwosomeHeartTypography.caption3M10,
        color = Gray10,
        modifier = modifier
            .background(
                shape = RoundedCornerShape(size = 2.dp),
                color = if (isAllergen) Gray70 else Red30
            )
            .padding(
                horizontal = 6.dp,
                vertical = 1.dp
            )

    )
}

@Preview(showBackground = true)
@Composable
fun MenuStatusChipPreview() {
    TwosomeHeartTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            MenuCautionChip(
                text = "우유",
                isAllergen = true
            )
            MenuCautionChip(text = "고카페인")
        }
    }
}