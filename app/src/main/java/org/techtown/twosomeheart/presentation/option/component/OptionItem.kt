package org.techtown.twosomeheart.presentation.option.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.core.util.PriceFormatter
import org.techtown.twosomeheart.presentation.option.model.Option
import org.techtown.twosomeheart.presentation.option.model.OptionType
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray10
import org.techtown.twosomeheart.ui.theme.Gray20
import org.techtown.twosomeheart.ui.theme.Gray40
import org.techtown.twosomeheart.ui.theme.Gray70
import org.techtown.twosomeheart.ui.theme.Gray80
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun OptionItem(
    option: Option,
    optionType: OptionType,
    optionText: String,
    updateExpandedState: () -> Unit,
    modifier: Modifier = Modifier,
    optionTypeQuantity: Int = 0,
    isExpanded: Boolean = false,
    option1: @Composable () -> Unit = {},
    option2: @Composable () -> Unit = {},
    option3: @Composable () -> Unit = {},
) {
    val isOptionIncreased: Boolean = optionTypeQuantity > 0

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Gray20)
        )

        Column(
            modifier = Modifier
                .background(if (!isExpanded && isOptionIncreased) Gray10 else White)
                .padding(vertical = 9.dp, horizontal = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.noRippleClickable(onClick = { updateExpandedState() }),
            ) {
                Text(
                    text = option.type,
                    style = if (isExpanded) TwosomeHeartTypography.head4B18 else TwosomeHeartTypography.head4R18,
                    color = Black
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    buildAnnotatedString {
                        append(
                            if (isOptionIncreased) stringResource(R.string.option_plus) else stringResource(
                                R.string.option_blank
                            )
                        )
                        append(PriceFormatter.formatPrice(optionType.type.first().second * optionTypeQuantity))
                        withStyle(style = TwosomeHeartTypography.body2R13.toSpanStyle()) {
                            append(stringResource(R.string.won))
                        }
                    },
                    style = TwosomeHeartTypography.body1B14,
                    color = Gray80
                )

                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    imageVector = if (isExpanded) ImageVector.vectorResource(R.drawable.ic_option_arrow_up) else ImageVector.vectorResource(
                        R.drawable.ic_option_arrow_down
                    ),
                    contentDescription = stringResource(R.string.option_expand_button),
                    tint = Color.Unspecified
                )
            }

            Text(
                text = if (isOptionIncreased) {
                    optionText//TODO: 리팩토링 -> 일부러 문자열 추출 x
                } else "",
                style = TwosomeHeartTypography.caption3R10,
                color = Gray70,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        if (isExpanded) {
            Column(
                modifier = Modifier
                    .background(Gray10)
                    .padding(top = 16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    option1()

                    option2()

                    option3()
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Gray40)
                        .padding(bottom = 20.dp)
                )
            }
        }
    }
}


@Preview
@Composable
fun OptionItemPreview() {
    TwosomeHeartTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            OptionItem(
                option = Option.SHOT,
                optionType = OptionType.SHOT,
                isExpanded = false,
                updateExpandedState = { },
                optionText = ""
            )

            OptionItem(
                option = Option.SYRUP,
                optionType = OptionType.SYRUP,
                optionTypeQuantity = 1,
                isExpanded = true,
                updateExpandedState = { },
                optionText = ""
            )
        }
    }
}
