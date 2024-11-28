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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.presentation.detail.model.TabType
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray10
import org.techtown.twosomeheart.ui.theme.Gray60
import org.techtown.twosomeheart.ui.theme.Red40
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun SizeTabRow(
    tabType: TabType,
    modifier: Modifier = Modifier,
) {
    val selectedTabIndex = remember { mutableIntStateOf(0) }

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
            tabType.type.forEachIndexed { index, type ->
                val isSelected = selectedTabIndex.intValue == index
                Text(
                    text = type,
                    textAlign = TextAlign.Center,
                    color = if (isSelected) Black else Gray60,
                    style = if (isSelected) TwosomeHeartTypography.body1B14 else TwosomeHeartTypography.body1R14,
                    modifier = Modifier
                        .drawBehind {
                            if (isSelected) {
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
                        .noRippleClickable { selectedTabIndex.intValue = index }
                )
            }
        }
    }
}





@Preview
@Composable
private fun SizeTabRowPreview() {
    TwosomeHeartTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
        ) {
            SizeTabRow(
                tabType = TabType.SIZE
            )
            Spacer(Modifier.height(8.dp))
        }
        
    }
}