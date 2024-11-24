package org.techtown.twosomeheart.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.component.BlackBottomButton
import org.techtown.twosomeheart.core.component.Topbar
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.presentation.detail.component.MenuDetailAllergyText
import org.techtown.twosomeheart.presentation.detail.component.MenuDetailContent
import org.techtown.twosomeheart.presentation.detail.component.MenuNutritionColumn
import org.techtown.twosomeheart.presentation.detail.model.DetailModel
import org.techtown.twosomeheart.ui.theme.Gray20
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun DetailRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: DetailViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getDetailDummy()
    }

    DetailScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp,
        state = state.uiState
    )

}

@Composable
fun DetailScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    state: UiState<DetailModel>,
    modifier: Modifier = Modifier
) {
    Scaffold(
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
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            when (state) {
                is UiState.Loading -> {}

                is UiState.Empty -> {}

                is UiState.Failure -> {}

                is UiState.Success -> {
                    Image(
                        painter = painterResource(R.drawable.img_detail_banana_latte),
                        contentDescription = stringResource(R.string.menu_detail_image),
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(26.dp))

                    MenuDetailContent(
                        isBestMenu = true,
                        menuName = state.data.menuName,
                        menuDescription = state.data.menuDescription,
                        menuPrice = state.data.menuPrice,
                    )

                    HorizontalDivider(
                        thickness = 4.dp,
                        color = Gray20
                    )

                    MenuNutritionColumn(
                        nutritionText = state.data.menuNutrition
                    )

                    if (state.data.menuAllergy != null) {
                        MenuDetailAllergyText(
                            allergyText = state.data.menuAllergy
                        )

                        Spacer(modifier = Modifier.height(58.dp))
                    }
                }
            }
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
            state = UiState.Success(
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
                    ),
                    menuAllergy = "우유",
                    menuImageUrl = "dummy"
                )
            )
        )
    }
}