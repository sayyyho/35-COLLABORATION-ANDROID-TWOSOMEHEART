package org.techtown.twosomeheart.presentation.detail.modal.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.util.PriceFormatter.formatPriceWon
import org.techtown.twosomeheart.presentation.detail.model.CoffeeBeanType
import org.techtown.twosomeheart.presentation.detail.model.PickUpType
import org.techtown.twosomeheart.presentation.detail.model.SizeType
import org.techtown.twosomeheart.presentation.detail.model.TemperatureType
import org.techtown.twosomeheart.ui.theme.Black
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun DetailModalBottomSheet(
    menuName: String,
    price: Int,
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    onStarButtonClick: () -> Unit,
    onTemperatureButtonClick: (TemperatureType) -> Unit,
    onSizeButtonClick: (SizeType) -> Unit,
    onCoffeeBeanButtonClick: (CoffeeBeanType) -> Unit,
    onPickUpButtonClick: (PickUpType) -> Unit,
    onPersonalCupButtonClick: (Boolean) -> Unit,
    onOptionButtonClick : () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false,
) {

    ModalBottomSheet(
        onDismissRequest = {
            onDismissRequest()
        },
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp),
        containerColor = White,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(
                min = (0.78f * LocalConfiguration.current.screenHeightDp).dp,
                max = (0.87f * LocalConfiguration.current.screenHeightDp).dp
            ),
        dragHandle = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_modal_bar),
                contentDescription = stringResource(R.string.menu_detail_modal_bar),
                tint = Color.Unspecified,
                modifier = Modifier.padding(vertical = 6.dp)
            )

        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                stickyHeader {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(White)
                    ) {
                        Text(
                            text = menuName,
                            color = Black,
                            style = TwosomeHeartTypography.body1B14,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(20.dp))

                    TemperatureSelection(
                        onClick = { temperatureType ->
                            onTemperatureButtonClick(temperatureType)
                        }
                    )

                    Spacer(Modifier.height(16.dp))

                    SizeSelection(
                        onClick = { sizeType ->
                            onSizeButtonClick(sizeType)
                        }
                    )

                    Spacer(Modifier.height(24.dp))

                    CoffeeBeanSelection(
                        onClick = { coffeeBeanType ->
                            onCoffeeBeanButtonClick(coffeeBeanType)
                        }
                    )

                    Spacer(Modifier.height(24.dp))

                    PickUpSelection(
                        onClick = { pickUpType ->
                            onPickUpButtonClick(pickUpType)
                        }
                    )

                    Spacer(Modifier.height(16.dp))

                    PersonalCupSelection(
                        onClick = { isPersonalCup ->
                            onPersonalCupButtonClick(isPersonalCup)
                        }
                    )

                    Spacer(Modifier.height(40.dp))

                    PersonalOptionSelection(
                        onClick = onOptionButtonClick,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )

                }
            }


            Spacer(modifier = Modifier.height(24.dp))

            DetailModalBottomBar(
                price = formatPriceWon(price),
                onQuantityButtonClick = {},
                onStarButtonClick = { onStarButtonClick() },
                isEnabled = isEnabled,
                modifier = modifier
                    .fillMaxWidth()
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DetailModalBottomSheetPreview() {
    DetailModalBottomSheet(
        menuName = "바나나 샷 라떼",
        price = 5500,
        onStarButtonClick = {},
        onDismissRequest = {},
        onTemperatureButtonClick = {},
        onSizeButtonClick = {},
        onCoffeeBeanButtonClick = {},
        onPickUpButtonClick = {},
        onPersonalCupButtonClick = {},
        onOptionButtonClick = {},
        modifier = Modifier,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    )
}
