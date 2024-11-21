package org.techtown.twosomeheart.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.ui.theme.White
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Red30
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme

@Composable
fun BlackButton(
    text: String,
    isActive: Boolean,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(Black)
            .padding(vertical = if (isActive) 14.dp else 11.dp),
        text = text,
        color = if (isActive) Red30 else White,
        textAlign = TextAlign.Center
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
                text = "선택하기",
                isActive = false,
                modifier = Modifier
            )
            BlackButton(
                text = "선택하기",
                isActive = true,
                modifier = Modifier
            )
        }

    }
}

