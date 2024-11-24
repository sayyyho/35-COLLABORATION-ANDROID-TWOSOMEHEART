package org.techtown.twosomeheart.presentation.detail.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.presentation.detail.model.TabType
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray10
import org.techtown.twosomeheart.ui.theme.Gray20
import org.techtown.twosomeheart.ui.theme.Gray30
import org.techtown.twosomeheart.ui.theme.Gray60
import org.techtown.twosomeheart.ui.theme.Gray80
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun MenuNutritionColumn(
    nutritionText: List<String>?,
    modifier: Modifier = Modifier
) {
    val isExpanded = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .background(White)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
    ){
        MenuNutritionColumnHeader(isExpanded = isExpanded)

        if(isExpanded.value) {
            MenuNutritionColumnBody(nutritionTexts = nutritionText)
        } else {
            HorizontalDivider(
                thickness = 1.dp,
                color = Gray10
            )

            Spacer(modifier = Modifier.height(22.dp))
        }
    }
}

@Composable
fun MenuNutritionColumnHeader(
    isExpanded: MutableState<Boolean>,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 22.dp, horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.menu_detail_nutrition_title_text),
            color = Black,
            style = TwosomeHeartTypography.title1B16
        )

        Icon(
            imageVector = if (isExpanded.value) ImageVector.vectorResource(R.drawable.ic_detail_arrow_up) else ImageVector.vectorResource(R.drawable.ic_detail_arrow_down),
            contentDescription = stringResource(R.string.menu_detail_nutrition_button),
            modifier = Modifier
                .noRippleClickable {
                    isExpanded.value = !isExpanded.value
                }
        )
    }
}

@Composable
fun MenuNutritionColumnBody(
    nutritionTexts: List<String>?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TemperatureTabRow(tabType = TabType.TEMPERATURE)

        Spacer(modifier = Modifier.height(14.dp))

        SizeTabRow(tabType = TabType.SIZE)

        Spacer(modifier = Modifier.height(20.dp))

        NutritionText(nutritionTexts = nutritionTexts)

        Spacer(modifier = Modifier.height(27.dp))

        HorizontalDivider(
            thickness = 1.dp,
            color = Gray30,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(13.dp))

        NutritionWarningText(
            nutritionWarningTexts = listOf(
                stringResource(R.string.menu_detail_nutrition_warning_text1),
                stringResource(R.string.menu_detail_nutrition_warning_text2),
                stringResource(R.string.menu_detail_nutrition_warning_text3)
            ).toPersistentList()
        )

        Spacer(modifier = Modifier.height(64.dp))

        HorizontalDivider(
            thickness = 4.dp,
            color = Gray20
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun NutritionText(
    nutritionTexts: List<String>?,
    modifier: Modifier = Modifier
) {
    if(nutritionTexts != null){
        Column(
            modifier = modifier
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            nutritionTexts.forEach { nutritionText ->
                Text(
                    text = nutritionText,
                    style = TwosomeHeartTypography.body1R14,
                    color = Gray80
                )
            }
        }
    }

}

@Composable
fun NutritionWarningText(
    nutritionWarningTexts: PersistentList<String>,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        nutritionWarningTexts.forEach { text ->
            Row {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_dot_nutrition_warning),
                    contentDescription = stringResource(R.string.menu_detail_dot_nutrition_warning)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = text,
                    style = TwosomeHeartTypography.body1R14,
                    color = Gray60
                )
            }
        }
    }
}

@Preview
@Composable
fun MenuNutritionColumnPreview() {
    TwosomeHeartTheme {
        MenuNutritionColumn(
            nutritionText = listOf(
                "1회 제공량: 325ml",
                "총 제공량: 1잔",
                "열량(Kcal): 260",
                "당류(g/%): 30/30",
                "단백질(g/%): 7/13",
                "포화지방(g/%): 5/33",
                "나트륨(mg/%): 160/8",
                "카페인(mg/%): 92"
            )
        )
    }
}