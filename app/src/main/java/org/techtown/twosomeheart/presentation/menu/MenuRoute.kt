package org.techtown.twosomeheart.presentation.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.component.Topbar
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.presentation.menu.component.BottomInformaion
import org.techtown.twosomeheart.presentation.menu.component.CategoryIndicator
import org.techtown.twosomeheart.presentation.menu.component.MenuIndicator
import org.techtown.twosomeheart.presentation.menu.component.MenuItem
import org.techtown.twosomeheart.presentation.menu.model.IndicatorType
import org.techtown.twosomeheart.presentation.menu.model.MenuModel
import org.techtown.twosomeheart.ui.theme.Red30
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun MenuRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: MenuViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.getMenuDummy()
    }

    MenuScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp,
        state = state.uiState
    )
}

@Composable
fun MenuScreen(
    paddingValues:PaddingValues,
    navigateUp: () -> Unit,
    state: UiState<PersistentList<MenuModel>>,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(paddingValues)
            .background(White)
            .fillMaxSize()
    ) {
        Column {
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
                text = stringResource(R.string.menu_top_bar),
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_menu_search),
                        contentDescription = stringResource(R.string.top_bar_search),
                        modifier = Modifier.noRippleClickable(onClick = navigateUp)
                    )
                },
                trailingIcon2 = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_menu_receipt),
                        contentDescription = stringResource(R.string.top_bar_receipt),
                        modifier = Modifier.noRippleClickable(onClick = navigateUp)
                    )
                },
                trailingIcon3 = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_basket),
                        contentDescription = stringResource(R.string.top_bar_basket),
                        modifier = Modifier.noRippleClickable(onClick = navigateUp),
                        tint = Color.Unspecified
                    )
                }
            )

            CategoryIndicator(IndicatorType.CATEGORY)

            Spacer(modifier = Modifier.height(8.dp))

            MenuIndicator(IndicatorType.BEVERAGE, modifier = Modifier.padding(start = 16.dp))

            when (state) {
                is UiState.Loading -> {}

                is UiState.Empty -> {}

                is UiState.Failure -> {}

                is UiState.Success -> {
                    LazyColumn(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 30.dp)
                    ) {
                        itemsIndexed(state.data) { index, item ->
                            MenuItem(
                                menuName = item.menuName,
                                menuPrice = item.menuPrice,
                                menuImage = item.menuImage,
                            )
                            if (index != state.data.lastIndex) {
                                Spacer(modifier = Modifier.height(24.dp))
                            }
                        }
                    }
                }
            }
        }

        BottomInformaion(
            modifier = Modifier.align(Alignment.BottomCenter)
        )

        FloatingActionButton(
            onClick = { },
            shape = CircleShape,
            containerColor = Red30,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp)
                .offset(y = (-0.12f * LocalConfiguration.current.screenHeightDp).dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_menu_fab_my),
                stringResource(R.string.menu_floating_action_button),
                tint = Color.Unspecified
            )
        }
    }
}

@Preview
@Composable
fun MenuScreenPreview() {
    TwosomeHeartTheme {
        MenuScreen(
            paddingValues = PaddingValues(),
            navigateUp = {},
            state = UiState.Success(
                persistentListOf(
                    MenuModel(
                        menuName = "바나나 샷 라떼",
                        menuPrice = 5500,
                        menuImage = R.drawable.img_menu_banana_latte,
                    ),
                    MenuModel(
                        menuName = "바나나 샷 아메리카노",
                        menuPrice = 5800,
                        menuImage = R.drawable.img_menu_banana_ameicano,
                    ),
                    MenuModel(
                        menuName = "디카페인 오틀리 콜르브루",
                        menuPrice = 6300,
                        menuImage = R.drawable.img_menu_ortley_coldbrew,
                        isBestMenu = true,
                    ),
                    MenuModel(
                        menuName = "레몬 아샷추",
                        menuPrice = 5500,
                        menuImage = R.drawable.img_menu_lemon_americano,
                        isBestMenu = true,
                    )
                )
            )
        )
    }
}
