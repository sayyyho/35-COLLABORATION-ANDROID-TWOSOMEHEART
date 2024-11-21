package org.techtown.twosomeheart.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Red30
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun BlackButton(
    text: String,
    modifier: Modifier = Modifier,
    font: TextStyle = TwosomeHeartTypography.titleB16,
    color: Color = White,
    padding: Int = 11,
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(Black)
            .padding(vertical = padding.dp),

        text = text,
        color = color,
        textAlign = TextAlign.Center,
        style = font
    )
}

@Preview
@Composable
fun BlackButtonPreview(
    modifier: Modifier = Modifier
) {
    TwosomeHeartTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = modifier.fillMaxWidth()
        ) {
            BlackButton(
                text = "주문하기",
                modifier = Modifier,
                padding = 15
            )
            BlackButton(
                text = "주문하기",
                color = Red30,
                modifier = Modifier
            )

            BlackButton(
                text = "선택하기",
                modifier = Modifier
            )
        }

    }
}

