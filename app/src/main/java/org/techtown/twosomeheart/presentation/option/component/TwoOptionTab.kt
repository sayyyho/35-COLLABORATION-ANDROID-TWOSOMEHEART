package org.techtown.twosomeheart.presentation.option.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.presentation.option.model.TabOption
import org.techtown.twosomeheart.ui.theme.Gray10
import org.techtown.twosomeheart.ui.theme.Gray20
import org.techtown.twosomeheart.ui.theme.Gray70
import org.techtown.twosomeheart.ui.theme.Gray80
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun TwoOptionTab(
    @StringRes optionTitle: Int,
    @StringRes optionLeftText: Int,
    @StringRes optionRightText: Int,
    modifier: Modifier = Modifier
) {
    val selectedTab = remember { mutableStateOf(TabOption.LEFT) }

    Column(
        modifier = modifier
            .background(Gray10)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(optionTitle),
            style = TwosomeHeartTypography.body1M14,
            color = Gray70,
        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
        ) {
            TabItem(
                title = stringResource(optionLeftText),
                isSelected = selectedTab.value == TabOption.LEFT,
                onClick = { selectedTab.value = TabOption.LEFT },
                shape = RoundedCornerShape(topStart = 4.dp, bottomStart = 4.dp),
                modifier = Modifier
                    .background(White)
                    .weight(1f)
            )

            TabItem(
                title = stringResource(optionRightText),
                isSelected = selectedTab.value == TabOption.RIGHT,
                onClick = { selectedTab.value = TabOption.RIGHT },
                shape = RoundedCornerShape(topEnd = 4.dp, bottomEnd = 4.dp),
                modifier = Modifier
                    .background(White)
                    .weight(1f)
            )
        }
    }
}

@Composable
fun TabItem(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    shape: RoundedCornerShape,
    modifier: Modifier = Modifier,
) {
    Text(
        text = title,
        style = if (isSelected) TwosomeHeartTypography.caption2M11 else TwosomeHeartTypography.caption2R11,
        color = if (isSelected) White else Gray70,
        modifier = modifier
            .clip(shape)
            .then(
                if (isSelected) {
                    Modifier.background(Gray80)
                } else {
                    Modifier.border(1.dp, Gray20, shape)
                }
            )
            .padding(vertical = 10.dp)
            .noRippleClickable(onClick = onClick),
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun OptionSelectRowPreview() {
    TwosomeHeartTheme {
        TwoOptionTab(
            optionTitle = R.string.option_density,
            optionLeftText = R.string.option_normal,
            optionRightText = R.string.option_lightly
        )
    }
}
