package org.techtown.twosomeheart.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.launch
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.component.BlackBottomButton
import org.techtown.twosomeheart.core.component.Topbar
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.presentation.detail.component.MenuDetailAllergyText
import org.techtown.twosomeheart.presentation.detail.component.MenuDetailContent
import org.techtown.twosomeheart.presentation.detail.component.MenuNutritionColumn
import org.techtown.twosomeheart.presentation.detail.modal.DetailModalSideEffect
import org.techtown.twosomeheart.presentation.detail.modal.component.DetailModalBottomSheet
import org.techtown.twosomeheart.presentation.detail.model.CoffeeBeanType
import org.techtown.twosomeheart.presentation.detail.model.DetailModel
import org.techtown.twosomeheart.presentation.detail.model.PickUpType
import org.techtown.twosomeheart.presentation.detail.model.SizeType
import org.techtown.twosomeheart.presentation.detail.model.TemperatureType
import org.techtown.twosomeheart.ui.theme.Gray20
import org.techtown.twosomeheart.ui.theme.Gray90
import org.techtown.twosomeheart.ui.theme.Red30
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun DetailRoute(
    menuId: Long,
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToMyMenu: () -> Unit,
    navigateToOption: () -> Unit,
    viewModel: DetailViewModel = viewModel()
) {
    val detailState by viewModel.detailState.collectAsStateWithLifecycle()

    val modalState by viewModel.detailModalState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getMenuDetail(menuId)
    }

    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    val snackBarHost = remember { SnackbarHostState() }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is DetailModalSideEffect.SnackBar -> {
                        snackBarHost.currentSnackbarData?.dismiss()
                        snackBarHost.showSnackbar(
                            message = context.getString(sideEffect.message),
                            actionLabel = context.getString(R.string.menu_detail_modal_snackbar_list),
                            duration = SnackbarDuration.Short
                        )
                    }

                    DetailModalSideEffect.NavigateToMyMenu -> navigateToMyMenu()
                    DetailModalSideEffect.OnClickOrderButton -> viewModel.updateIsShowBottomSheet()
                }
            }
    }

    DetailScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp,
        navigateToMyMenu = viewModel::snackBarListActionButtonClick,
        detailState = detailState.uiState,
        modalUiState = modalState.uiState,
        onStarButtonClick = viewModel::onStarButtonClick,
        onTemperatureButtonClick = viewModel::onTempatureButtonClick,
        onSizeButtonClick = viewModel::onSizeButtonClick,
        onCoffeeBeanButtonClick = viewModel::onCoffeeBeanButtonClick,
        onPickUpButtonClick = viewModel::onPickUpButtonClick,
        onPersonalCupButtonClick = viewModel::onPersonalCupButtonClick,
        onOrderButtonClick = viewModel::onClickOrderButton,
        isEnabled = modalState.isEnabled,
        isShowBottomSheet = detailState.isShowBottomSheet,
        updateMenuId = viewModel::updateLikeMenuId,
        updateMenuName = viewModel::updateLikeName,
        updateMenuPrice = viewModel::updateLikePrice,
        updateIsEnabled = viewModel::updateIsEnabled,
        updateIsShowBottomSheet = viewModel::updateIsShowBottomSheet,
        snackBarHost = snackBarHost,
        onOptionButtonClick = navigateToOption
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    navigateToMyMenu: () -> Unit,
    detailState: UiState<DetailModel>,
    modalUiState: UiState<Int>,
    onStarButtonClick: () -> Unit,
    onTemperatureButtonClick: (TemperatureType) -> Unit,
    onSizeButtonClick: (SizeType) -> Unit,
    onCoffeeBeanButtonClick: (CoffeeBeanType) -> Unit,
    onPickUpButtonClick: (PickUpType) -> Unit,
    onPersonalCupButtonClick: (Boolean) -> Unit,
    onOrderButtonClick: () -> Unit,
    updateMenuId: (Long) -> Unit,
    updateMenuName: (String) -> Unit,
    updateMenuPrice: (Int) -> Unit,
    updateIsEnabled: () -> Unit,
    updateIsShowBottomSheet: () -> Unit,
    snackBarHost: SnackbarHostState,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false,
    isShowBottomSheet: Boolean = false,
    onOptionButtonClick: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(modalUiState) {
        snapshotFlow { modalUiState }
            .collect { state ->
                if (state is UiState.Success) {
                    updateIsShowBottomSheet()
                }
            }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHost) { snackbarData ->
                DetailModalSnackbar(
                    snackbarData = snackbarData,
                    navigateToMyMenu = navigateToMyMenu
                )
            }
        },
        modifier = modifier
            .background(White)
            .padding(paddingValues)
            .fillMaxSize(),
        topBar = {
            Topbar(
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                        contentDescription = stringResource(R.string.top_bar_back),
                        modifier = Modifier.noRippleClickable(onClick = navigateUp)
                    )
                },
                leadingIcon2 = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_home),
                        contentDescription = stringResource(R.string.top_bar_home),
                    )
                },
                text = stringResource(R.string.menu_detail_top_bar),
                trailingIcon3 = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_basket),
                        contentDescription = stringResource(R.string.top_bar_basket),
                        modifier = Modifier.noRippleClickable(onClick = navigateUp),
                        tint = Color.Unspecified
                    )
                }
            )
        },
        bottomBar = {
            BlackBottomButton(
                text = stringResource(R.string.menu_detail_order_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .noRippleClickable {
                        onOrderButtonClick()
                    }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            when (detailState) {
                is UiState.Loading -> {}

                is UiState.Empty -> {}

                is UiState.Failure -> {}

                is UiState.Success -> {

                    updateMenuId(detailState.data.menuId)
                    updateMenuName(detailState.data.menuName)
                    updateMenuPrice(detailState.data.menuPrice)

                    if(isShowBottomSheet){

                        DetailModalBottomSheet(
                            menuName = detailState.data.menuName,
                            price = detailState.data.menuPrice,
                            sheetState = sheetState,
                            onDismissRequest = {
                                coroutineScope.launch { sheetState.hide() }
                            },
                            onStarButtonClick = {
                                onStarButtonClick()
                            },
                            onTemperatureButtonClick = { temperatureType ->
                                onTemperatureButtonClick(temperatureType)
                                updateIsEnabled()
                            },
                            onSizeButtonClick = { sizeType ->
                                onSizeButtonClick(sizeType)
                                updateIsEnabled()
                            },
                            onCoffeeBeanButtonClick = { coffeeBeanType ->
                                onCoffeeBeanButtonClick(coffeeBeanType)
                            },
                            onPickUpButtonClick = { pickUpType ->
                                onPickUpButtonClick(pickUpType)
                                updateIsEnabled()
                            },
                            onPersonalCupButtonClick = { isPersonalCup ->
                                onPersonalCupButtonClick(isPersonalCup)
                            },
                            isEnabled = isEnabled,
                            onOptionButtonClick = { onOptionButtonClick() }
                        )
                    }

                    AsyncImage(
                        model = detailState.data.menuImageUrl,
                        contentDescription = stringResource(R.string.menu_detail_image),
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(26.dp))

                    MenuDetailContent(
                        isBestMenu = detailState.data.menuStatus == "BEST",
                        menuName = detailState.data.menuName,
                        menuDescription = detailState.data.menuDescription,
                        menuPrice = detailState.data.menuPrice,
                        menuCaution = detailState.data.menuCaution,
                        menuAllergy = detailState.data.menuAllergy
                    )

                    HorizontalDivider(
                        thickness = 4.dp,
                        color = Gray20
                    )

                    MenuNutritionColumn(
                        nutritionText = detailState.data.menuNutrition
                    )

                    if (detailState.data.menuAllergy != null) {
                        MenuDetailAllergyText(
                            allergyText = detailState.data.menuAllergy
                        )

                        Spacer(modifier = Modifier.height(58.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun DetailModalSnackbar(
    snackbarData: SnackbarData,
    navigateToMyMenu: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = 23.dp,
                start = 16.dp,
                end = 16.dp
            )
            .background(
                color = Gray90,
                shape = RoundedCornerShape(7.dp)
            )
    ) {
        Text(
            text = snackbarData.visuals.message,
            modifier = Modifier
                .weight(1f)
                .padding(
                    top = 15.5.dp,
                    bottom = 15.5.dp,
                    start = 15.dp
                ),
            style = TwosomeHeartTypography.body1R14,
            color = White
        )

        snackbarData.visuals.actionLabel?.let { actionLabel ->
            Text(
                text = actionLabel,
                style = TwosomeHeartTypography.body1B14,
                color = Red30,
                modifier = Modifier
                    .padding(
                        top = 15.53.dp,
                        bottom = 15.47.dp,
                        end = 14.68.dp
                    )
                    .noRippleClickable {
                        navigateToMyMenu()
                        snackbarData.performAction()
                    }
            )
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    TwosomeHeartTheme {
        DetailScreen(
            paddingValues = PaddingValues(),
            navigateUp = {},
            navigateToMyMenu = {},
            detailState = UiState.Success(
                DetailModel(
                    menuId = 1,
                    menuName = "바나나 샷 라떼",
                    menuStatus = "New",
                    menuDescription = "달콤한 바나나 라떼에 에스프레소 샷 추가!",
                    menuPrice = 5500,
                    menuCaution = "고카페인, 우유",
                    menuNutrition = listOf(
                        "1회 제공량: 325ml",
                        "총 제공량: 1잔",
                        "열량(Kcal): 260",
                        "당류(g/%): 30/30",
                        "단백질(g/%): 7/13",
                        "포화지방(g/%): 5/33",
                        "나트륨(mg/%): 160/8",
                        "카페인(mg/%): 92"
                    ).toPersistentList(),
                    menuAllergy = "우유",
                    menuImageUrl = "https://private-user-images.githubusercontent.com/69308068/389300533-8d353883-fb4b-4608-b0b4-24d2bc074133.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MzI1MzI2OTksIm5iZiI6MTczMjUzMjM5OSwicGF0aCI6Ii82OTMwODA2OC8zODkzMDA1MzMtOGQzNTM4ODMtZmI0Yi00NjA4LWIwYjQtMjRkMmJjMDc0MTMzLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNDExMjUlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjQxMTI1VDEwNTk1OVomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPTMwZTViNmNmMDUwODlmYjRiNGUzZDYzYmY5MmQxOTE0ZTkyMzI3ODJkNDk2MjljZjZjMTRkODE1MzNiM2JkMzkmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.BcvGmMQweWhlRzbTBNEGhu9K6WTQOUE6Fkntktloog0"
                )
            ),
            modalUiState = UiState.Success(1),
            onStarButtonClick = { },
            onTemperatureButtonClick = { },
            onSizeButtonClick = { },
            onCoffeeBeanButtonClick = { },
            onPickUpButtonClick = { },
            onPersonalCupButtonClick = { },
            onOrderButtonClick = {},
            updateMenuId = { },
            updateMenuName = { },
            updateMenuPrice = { },
            updateIsEnabled = { },
            snackBarHost = SnackbarHostState(),
            updateIsShowBottomSheet = {},
            onOptionButtonClick = {}
        )
    }
}
