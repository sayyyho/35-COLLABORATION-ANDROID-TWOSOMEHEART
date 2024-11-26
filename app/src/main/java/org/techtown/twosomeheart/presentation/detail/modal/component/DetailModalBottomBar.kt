package org.techtown.twosomeheart.presentation.detail.modal.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.ui.theme.White


@Composable
fun DetailModalBottomBar(
    price: String,
    onQuantityButtonClick: (Int) -> Unit,
    onStarButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(White)
    ) {
        PriceQuantitySelection(
            price = price,
            onQuantityButtonClick = onQuantityButtonClick)

        Spacer(Modifier.height(20.dp))

        DetailModalBottomButtons(
            onStarButtonClick = onStarButtonClick,
            isEnabled = isEnabled
        )

    }
}

@Preview
@Composable
fun DetailModalBottomBarPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        DetailModalBottomBar(
            price = "1,000원",
            onQuantityButtonClick = {},
            onStarButtonClick = {}
        )

        DetailModalBottomBar(
            price = "1,000원",
            onQuantityButtonClick = {},
            onStarButtonClick = {},
            isEnabled = true
        )
    }

}