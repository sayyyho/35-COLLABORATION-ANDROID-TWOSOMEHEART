package org.techtown.twosomeheart.presentation.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.presentation.detail.model.SizeType
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray10
import org.techtown.twosomeheart.ui.theme.Gray60
import org.techtown.twosomeheart.ui.theme.Red40
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun SizeTabRow(
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    tabText: List<String> = emptyList()
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .drawBehind {
                    val strokeWidth = 1.dp.toPx()
                    drawLine(
                        color = Gray10,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = strokeWidth
                    )
                }
                .padding(start = 16.dp)
            ,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            tabText.forEachIndexed { index, title ->
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    color = if (index == selectedTabIndex) Black else Gray60,
                    modifier = Modifier
                        .drawBehind {
                            // 빨간 줄: 선택된 탭의 텍스트 아래
                            if (index == selectedTabIndex) {
                                val strokeWidth = 1.dp.toPx()
                                val yPosition = size.height
                                drawLine(
                                    color = Red40,
                                    start = Offset(0f, yPosition),
                                    end = Offset(size.width, yPosition),
                                    strokeWidth = strokeWidth
                                )
                            }
                        }
                        .padding(vertical = 9.dp)
                        .noRippleClickable { onTabClick(index) }
                )
            }
        }
    }
}





@Preview
@Composable
private fun TemperatureTabRowPreview() {
    TwosomeHeartTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
        ) {
            SizeTabRow(
                selectedTabIndex = 0,
                tabText = SizeType.entries.map { it.type },
                onTabClick = {}
            )
            Spacer(Modifier.height(8.dp))
        }
        
    }
}