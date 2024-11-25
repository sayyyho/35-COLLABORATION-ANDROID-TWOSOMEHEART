package org.techtown.twosomeheart.presentation.detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.Gray80
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography

@Composable
fun MenuDetailAllergyText(
    allergyText: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(start = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.menu_detail_allergy_title_text),
            style = TwosomeHeartTypography.title1B16,
            color = Black
        )

        Spacer(Modifier.height(13.dp))

        Text(
            text = allergyText,
            style = TwosomeHeartTypography.body1R14,
            color = Gray80
        )
    }
}