package org.techtown.twosomeheart.presentation.menu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.presentation.menu.model.IndicatorType
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray20
import org.techtown.twosomeheart.ui.theme.Gray90
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun CategoryIndicator(
    indicatorType: IndicatorType,
    modifier: Modifier = Modifier
) {
    val selectedIndex = remember { mutableIntStateOf(0) }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(start = 8.dp, end = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            indicatorType.type.forEachIndexed { index, type ->
                val isSelected = selectedIndex.value == index

                Column(
                    modifier = Modifier
                        .noRippleClickable(onClick = { selectedIndex.value = index })
                ) {
                    Text(
                        text = type,
                        style = if (isSelected) TwosomeHeartTypography.title1B16 else TwosomeHeartTypography.title1R16,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        color = if (isSelected) Black else Gray90,
                        modifier = Modifier
                            .drawBehind {
                                drawLine(
                                    color = if (isSelected) Black else Color.Transparent,
                                    start = Offset(0f, size.height),
                                    end = Offset(size.width, size.height),
                                    strokeWidth = if (isSelected) 2.dp.toPx() else 0.dp.toPx()
                                )
                            }
                            .padding(vertical = 10.dp)
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .background(Gray20)
                .height(1.dp)
        )
    }
}

@Preview
@Composable
fun CategoryIndicatorPreview() {
    TwosomeHeartTheme {
        CategoryIndicator(
            indicatorType = IndicatorType.CATEGORY
        )
    }
}
