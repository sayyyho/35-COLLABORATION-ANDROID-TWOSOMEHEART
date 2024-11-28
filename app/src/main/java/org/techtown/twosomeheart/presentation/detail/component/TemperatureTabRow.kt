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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.presentation.detail.model.TabType
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray20
import org.techtown.twosomeheart.ui.theme.Gray90
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun TemperatureTabRow(
    tabType: TabType,
    modifier: Modifier = Modifier,
) {
    val selectedTabIndex = remember { mutableIntStateOf(0) }

    TabRow(
        selectedTabIndex = selectedTabIndex.intValue,
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
                    .tabIndicatorOffset(tabPositions[selectedTabIndex.intValue])
                    .height(2.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Black)
            )
        },
        containerColor = White
    ) {
        tabType.type.forEachIndexed { index, type ->
            val isSelected = selectedTabIndex.intValue == index

            Text(
                text = type,
                color = Gray90,
                style = if (isSelected) TwosomeHeartTypography.title1B16 else TwosomeHeartTypography.title1R16,
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(vertical = 9.dp)
                    .noRippleClickable { selectedTabIndex.intValue = index }
            )
        }
    }
}




@Preview
@Composable
private fun TemperatureTabRowPreview() {
    TwosomeHeartTheme {
        TemperatureTabRow(
            tabType = TabType.TEMPERATURE
        )
    }
}
