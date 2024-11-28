package org.techtown.twosomeheart.presentation.option.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.core.component.OptionQuantityButton
import org.techtown.twosomeheart.presentation.option.model.OptionType
import org.techtown.twosomeheart.ui.theme.Gray10
import org.techtown.twosomeheart.ui.theme.Gray60
import org.techtown.twosomeheart.ui.theme.Gray90
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography

@Composable
fun OptionQuantityRow(
    optionName: String,
    optionPrice: Int,
    optionType: OptionType,
    onClickMinusButton: (OptionType) -> Unit,
    onClickPlusButton: (OptionType) -> Unit,
    modifier: Modifier = Modifier,
    optionTypeQuantity: Int = 0,
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Gray10),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = optionName,
                style = TwosomeHeartTypography.body1M14,
                color = Gray90,
            )

            Text(
                text = "(+1에 ${optionPrice}원)",
                style = TwosomeHeartTypography.caption1B12,
                color = Gray60,
                modifier = Modifier.padding(7.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            OptionQuantityButton(
                onClickMinusButton = { onClickMinusButton(optionType) },
                onClickPlusButton = { onClickPlusButton(optionType) },
                amount = optionTypeQuantity
            )
        }
    }
}

@Preview
@Composable
fun OptionQuantityRowPreview() {
    TwosomeHeartTheme {
        OptionQuantityRow(
            optionName = "샷",
            optionType = OptionType.SHOT,
            onClickMinusButton = {},
            onClickPlusButton = {},
            optionPrice = 0
        )
    }
}
