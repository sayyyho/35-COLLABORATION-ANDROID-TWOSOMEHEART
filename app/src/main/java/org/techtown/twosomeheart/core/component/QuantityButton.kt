package org.techtown.twosomeheart.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray20
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun ModalQuantityButton(
    onClickMinusButton: () -> Unit,
    onClickPlusButton: () -> Unit,
    modifier: Modifier = Modifier,
    ammount: Int = 1,
) {
    Row(
        modifier = modifier
            .height(32.dp)
            .border(width = 1.dp, shape = RoundedCornerShape(4.dp), color = Gray20)
            .clip(RoundedCornerShape(4.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier.noRippleClickable(onClick = onClickMinusButton)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_modal_minus),
                contentDescription = stringResource(R.string.minus),
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp),
            )
        }

        Box(
            modifier = Modifier
                .width(40.dp)
                .height(32.dp)
                .border(width = 1.dp, color = Gray20),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = ammount.toString(),
                color = Black,
                style = TwosomeHeartTheme.typography.body1B14Tight
            )
        }

        Box(
            modifier = Modifier.noRippleClickable(onClick = onClickPlusButton)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_modal_plus),
                contentDescription = stringResource(R.string.plus),
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp),
            )
        }
    }
}

@Composable
fun OptionQuantityButton(
    onClickMinusButton: () -> Unit,
    onClickPlusButton: () -> Unit,
    modifier: Modifier = Modifier,
    ammount: Int = 0,
) {
    Row(
        modifier = modifier
            .height(32.dp)
            .border(width = 1.dp, shape = RoundedCornerShape(4.dp), color = Gray20)
            .clip(RoundedCornerShape(4.dp))
            .background(White),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier.noRippleClickable(
                onClick = {
                    if (ammount == 0) else onClickMinusButton()
                }
            )
        ) {
            Icon(
                imageVector = if (ammount == 0) ImageVector.vectorResource(id = R.drawable.ic_option_more_minus_disable) else ImageVector.vectorResource(
                    id = R.drawable.ic_option_more_minus_able
                ),
                contentDescription = stringResource(R.string.minus),
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp),
            )
        }

        Box(
            modifier = Modifier
                .width(40.dp)
                .height(32.dp)
                .border(width = 1.dp, color = Gray20),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = ammount.toString(),
                color = Black,
                style = TwosomeHeartTheme.typography.caption1M12
            )
        }

        Box(
            modifier = Modifier.noRippleClickable(onClick = onClickPlusButton)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_option_more_plus),
                contentDescription = stringResource(R.string.plus),
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(24.dp)
                    .padding(4.dp),
            )
        }
    }
}

@Preview
@Composable
fun QuantityButtonPreview() {
    TwosomeHeartTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            ModalQuantityButton(
                onClickMinusButton = {},
                onClickPlusButton = {}
            )
            OptionQuantityButton(
                onClickMinusButton = {},
                onClickPlusButton = {}
            )
            OptionQuantityButton(
                onClickMinusButton = {},
                onClickPlusButton = {},
                ammount = 1
            )
        }
    }
}
