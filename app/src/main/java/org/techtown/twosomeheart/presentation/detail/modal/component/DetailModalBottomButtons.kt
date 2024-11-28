package org.techtown.twosomeheart.presentation.detail.modal.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray20
import org.techtown.twosomeheart.ui.theme.Gray50
import org.techtown.twosomeheart.ui.theme.Red40
import org.techtown.twosomeheart.ui.theme.Red40_40
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun DetailModalBottomButtons(
    onStarButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ModalCartButton(
            modifier = modifier,
            isEnabled = isEnabled
        )
        ModalStarButton(
            onClick = {
                onStarButtonClick()
            },
            modifier = modifier,
            isEnabled = isEnabled
        )
        ModalOrderButton(
            modifier = modifier,
            isEnabled = isEnabled
        )
    }
}

@Composable
fun ModalCartButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false
) {
    Box(
        modifier = modifier
            .background(
                if (isEnabled) Red40 else Red40_40
            )
    ) {
        Icon(
            imageVector = if (isEnabled) ImageVector.vectorResource(R.drawable.ic_modal_shop_able) else ImageVector.vectorResource(R.drawable.ic_modal_shop_disable),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.padding(
                vertical = 16.dp,
                horizontal = 18.dp
            )
        )
    }
}

@Composable
fun ModalStarButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false
) {
    Box(
        modifier = modifier
            .background(White)
            .border(
                width = 1.dp,
                color = if (isEnabled) Red40 else Red40_40,
            )
    ) {
        Icon(
            imageVector = if (isEnabled) ImageVector.vectorResource(R.drawable.ic_modal_star_able) else ImageVector.vectorResource(R.drawable.ic_modal_star_disable),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(
                    vertical = 16.dp,
                    horizontal = 18.dp
                )
                .noRippleClickable {
                    if(isEnabled) {
                        onClick()
                    }
                }
        )
    }
}

@Composable
fun ModalOrderButton(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .background(
                if (isEnabled) Black else Gray20
            )
            .padding(
                top = 4.dp,
                bottom = 4.dp,
                start = 62.dp,
                end = 63.dp
            ),
        text = stringResource(R.string.menu_detail_order_text),
        color = if (isEnabled) White else Gray50,
        textAlign = TextAlign.Center,
        style = if (isEnabled) TwosomeHeartTypography.head4B18 else TwosomeHeartTypography.head4M18
    )
}

@Preview
@Composable
fun DetailModalBottomButtonsPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DetailModalBottomButtons(
            onStarButtonClick = {}
        )

        DetailModalBottomButtons(
            onStarButtonClick = {},
            isEnabled = true
        )
    }
}
