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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.component.OptionQuantityButton
import org.techtown.twosomeheart.presentation.option.model.OptionType
import org.techtown.twosomeheart.ui.theme.Gray10
import org.techtown.twosomeheart.ui.theme.Gray60
import org.techtown.twosomeheart.ui.theme.Gray90
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography

@Composable
fun OptionQuantityRow(
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
                text =
                stringResource(
                    R.string.option_name_add,
                    optionType.type.first().first
                ),//TODO : 각각의 이름이 나와야함. 바닐라시럽/헤이즐넛시럽/캬라멜시럽
                style = TwosomeHeartTypography.body1M14,
                color = Gray90,
            )

            Text(
                text = "(+1에 ${optionType.type.first().second}원)", //TODO : 각각의 가격이 나와야함. 지금 다 500원이라서 눈치 못채고 있었음
                style = TwosomeHeartTypography.caption1B12,
                color = Gray60,
                modifier = Modifier.padding(7.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            OptionQuantityButton(
                onClickMinusButton = { onClickMinusButton(optionType) },
                onClickPlusButton = { onClickPlusButton(optionType) },
                ammount = optionTypeQuantity
            )
        }
    }
}

@Preview
@Composable
fun OptionQuantityRowPreview() {
    TwosomeHeartTheme {
        OptionQuantityRow(
            optionType = OptionType.SHOT,
            onClickMinusButton = {},
            onClickPlusButton = {}
        )
    }
}
