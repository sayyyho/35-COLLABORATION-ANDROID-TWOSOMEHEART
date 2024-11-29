package org.techtown.twosomeheart.presentation.detail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.core.component.MenuStatusChip
import org.techtown.twosomeheart.core.util.PriceFormatter.formatPrice
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun MenuDetailContent(
    isBestMenu: Boolean,
    menuName: String,
    menuDescription: String,
    menuPrice: Int,
    menuCaution : String?,
    menuAllergy : String?,
    modifier: Modifier = Modifier
){
    val cautionList = menuCaution?.split(",")?.map { it.trim() } ?: emptyList()
    val cautionAndAllergyList = (cautionList + listOfNotNull(menuAllergy)).distinct()

    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .background(White)
    ) {
        MenuStatusChip(isBestMenu = isBestMenu)

        Spacer(modifier = Modifier.height(7.dp))

        Text(
            text = menuName,
            style = TwosomeHeartTypography.head3B20,
            color = Black
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = menuDescription,
            style = TwosomeHeartTypography.body1R14,
            color = Black,
            modifier = Modifier.padding(start = 6.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        MenuDetailPriceText(
            price = formatPrice(menuPrice)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.5.dp)
        ) {
            cautionAndAllergyList.forEach { item ->
                MenuCautionChip(
                    text = item,
                    isAllergen = (menuAllergy == item)
                )
            }
        }

        Spacer(modifier = Modifier.height(22.dp))
    }
}
