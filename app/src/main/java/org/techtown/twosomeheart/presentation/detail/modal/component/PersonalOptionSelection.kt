package org.techtown.twosomeheart.presentation.detail.modal.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import org.techtown.twosomeheart.ui.theme.Red10
import org.techtown.twosomeheart.ui.theme.Red20
import org.techtown.twosomeheart.ui.theme.Red40
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography

@Composable
fun PersonalOptionSelection(
    onClick: () -> Unit,
    personOption: String = "",
    modifier: Modifier = Modifier
) {

    Row(
      modifier = modifier
          .fillMaxWidth()
          .background(Red10)
          .border(
              width = 1.dp,
              color = Red20,
              shape = RoundedCornerShape(4.dp)
          )
          .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.menu_detail_modal_personal_option),
            style = TwosomeHeartTypography.body1R14,
            color = Black,
            modifier = Modifier
                .padding(
                    top = 14.5.dp,
                    bottom = 13.5.dp,
                    start = 16.dp
                )
        )

        Spacer(modifier = Modifier.weight(1f))

        if(personOption.isNotEmpty()) {
            Text(
                text = personOption,
                style = TwosomeHeartTypography.caption3R10,
                color = Red40,
                modifier = Modifier
                    .padding(
                        top = 16.5.dp,
                        bottom = 17.5.dp
                    )
            )
        }

        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_modal_arrow_right),
            contentDescription = stringResource(R.string.menu_detail_modal_personal_option),
            tint = Color.Unspecified,
            modifier = Modifier
                .padding(
                    top = 13.dp,
                    bottom = 12.dp,
                    end = 10.dp
                )
                .noRippleClickable {
                    onClick()
                }
        )
    }
}

@Preview
@Composable
fun PersonalOptionSelectionPreview() {
    PersonalOptionSelection(
        onClick = {},
        personOption = "샷추가x1 외 1건"
    )
}
