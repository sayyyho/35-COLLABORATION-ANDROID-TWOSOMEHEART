package org.techtown.twosomeheart.presentation.menu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.presentation.menu.model.IndicatorType
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray60
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun MenuIndicator(
    indicatorType: IndicatorType,
    modifier: Modifier = Modifier
) {
    val selectedIndex = remember { mutableIntStateOf(0) }
    val scrollState = rememberScrollState()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
            .horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(22.dp)

    ) {
        indicatorType.type.forEachIndexed { index, type ->
            val isSelected = (selectedIndex.value == index)

            Text(
                text = type,
                style = if (isSelected) TwosomeHeartTypography.body1B14Tight else TwosomeHeartTypography.body1R14,
                color = if (isSelected) White else Gray60,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.5.dp))
                    .background(color = if (isSelected) Black else Color.Transparent)
                    .padding(
                        vertical = if (isSelected) 6.dp else 10.dp,
                        horizontal = if (isSelected) 11.dp else 0.dp
                    )
                    .noRippleClickable(onClick = { selectedIndex.value = index })
            )
        }
    }
}

@Preview
@Composable
fun MenuIndicatorPreview() {
    TwosomeHeartTheme {
        MenuIndicator(
            indicatorType = IndicatorType.BEVERAGE
        )
    }
}
