package org.techtown.twosomeheart.presentation.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.presentation.detail.model.TemperatureType
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray20
import org.techtown.twosomeheart.ui.theme.Gray90
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography

@Composable
fun TemperatureTabRow(
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    tabText: List<String> = emptyList()
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = Gray20,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = strokeWidth
                )
            },
        indicator = { tabPositions ->
            Box(
                Modifier
                    .tabIndicatorOffset(tabPositions[selectedTabIndex])
                    .height(2.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Black)
            )
        }
    ) {
        tabText.forEachIndexed { index, title ->
            Text(
                text = title,
                color = Gray90,
                style = if (index == selectedTabIndex) TwosomeHeartTypography.title1B16 else TwosomeHeartTypography.title1R16,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(vertical = 9.dp)
                    .noRippleClickable { onTabClick(index) }
            )
        }
    }
}




@Preview
@Composable
private fun TemperatureTabRowPreview() {
    TwosomeHeartTheme {
        TemperatureTabRow(
            selectedTabIndex = 0,
            tabText = TemperatureType.entries.map { it.type },
            onTabClick = {}
        )
    }
}
