package org.techtown.twosomeheart.presentation.detail.modal.component

import androidx.compose.foundation.background
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Blue20
import org.techtown.twosomeheart.ui.theme.Gray50
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun PersonalCupSelection(
    modifier: Modifier = Modifier,
    onClick: (Boolean) -> Unit
) {
    val isPersonalCup = remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 16.dp)
    ) {
        Icon(
            imageVector = if (isPersonalCup.value) ImageVector.vectorResource(R.drawable.ic_modal_checkbox_select) else ImageVector.vectorResource(R.drawable.ic_checkbox_diselect),
            contentDescription = stringResource(R.string.menu_detail_modal_personal_cup_checkbox),
            tint = Color.Unspecified,
            modifier = Modifier.noRippleClickable {
                isPersonalCup.value = !isPersonalCup.value
                onClick(isPersonalCup.value)
            }
        )

        Spacer(Modifier.width(8.dp))

        Text(
            text = stringResource(R.string.menu_detail_modal_personal_cup_text),
            style = TwosomeHeartTypography.body2R13,
            color = Black
        )

        if (isPersonalCup.value) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = stringResource(R.string.menu_detail_modal_personal_cup_price_text),
                    style = TwosomeHeartTypography.body2R13,
                    color = Blue20
                )

                Spacer(Modifier.height(16.dp))

                Row {
                    Text(
                        text = stringResource(R.string.menu_detail_modal_personal_cup_caution),
                        style = TwosomeHeartTypography.body1M14,
                        color = Gray50
                    )

                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_modal_arrow_right),
                        contentDescription = stringResource(R.string.menu_detail_modal_personal_cup_caution),
                        tint = Color.Unspecified
                    )
                }

            }
        }
    }

}

@Preview
@Composable
fun PresonalCupSelection() {
    PersonalCupSelection(
        onClick = {}
    )
}