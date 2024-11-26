package org.techtown.twosomeheart.presentation.mymenu

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextDecoration
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
import org.techtown.twosomeheart.presentation.mymenu.component.CustomDialog
import org.techtown.twosomeheart.presentation.mymenu.component.MyBottomSheet
import org.techtown.twosomeheart.presentation.mymenu.component.MyMenuItem
import org.techtown.twosomeheart.presentation.mymenu.model.MyMenuModel
import org.techtown.twosomeheart.ui.theme.TwosomeHeartColors
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun MyMenuRoute(
    navigateUp: () -> Unit,
    paddingValues: PaddingValues,
    viewModel: MyMenuViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewModel.getMenuDummy()
    }

    MyMenuScreen(
        paddingValues = paddingValues,
        state = state.uiState,
        navigateUp = navigateUp,
        viewModel = viewModel

    )
}

@Composable
fun MyMenuScreen(
    paddingValues: PaddingValues,
    state: UiState<PersistentList<MyMenuModel>>,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MyMenuViewModel
) {
    var isDialogVisible by remember { mutableStateOf(false) }
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
                        contentDescription = "",
                        modifier = Modifier.noRippleClickable(onClick = navigateUp)

                    )
                },
                leadingIcon2 = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_home),
                        contentDescription = "",
                        modifier = Modifier.noRippleClickable(onClick = navigateUp)
                    )
                },
                text = "투썸오더",
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_mymenu_plus),
                        contentDescription = ""
                    )
                },
            )
            Text(
                text = "총 3개",
                // TODO 서버통신 값 할당
                style = TwosomeHeartTypography.caption1R12Tight,
                color = TwosomeHeartColors.Gray90,
                modifier = Modifier.padding(start = 16.dp, top = 23.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 10.dp, end = 17.dp, bottom = 13.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.Start),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_checkbox_diselect),
                        contentDescription = "",
                        tint = Color.Unspecified,
                    )
                    Text(
                        text = "전체선택",
                        style = TwosomeHeartTypography.title1R16,
                        color = TwosomeHeartColors.Gray90
                    )
                }
                Text(
                    text = "선택삭제",
                    style = TwosomeHeartTypography.caption2R11.copy(
                        textDecoration = TextDecoration.Underline
                    ),
                    color = TwosomeHeartColors.Gray90,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(
                        start = 16.dp,
                        end = 1.dp
                    )
                    .border(width = 1.dp, color = Color.Black)
            )
            when (state) {
                is UiState.Loading -> {}
                is UiState.Empty -> {}
                is UiState.Failure -> {}
                is UiState.Success -> {
                    LazyColumn(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)
                    ) {
                        itemsIndexed(state.data) { index, item ->
                            MyMenuItem(
                                menuName = item.menuName,
                                menuPrice = item.menuPrice,
                                menuImage = item.menuImage,
                                menuOption = item.menuOption,
                                isChecked = item.isChecked,
                                onCheckedChange = { viewModel.toggleItemChecked(index) }
                            )
                            if (index != state.data.lastIndex) {
                                Spacer(modifier = Modifier.height(40.dp))
                            }
                        }
                    }
                }
            }
        }
        MyBottomSheet(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            price = 5500,
            count = 1,
            place = "삼성역점",
        )
        if (isDialogVisible) {
            CustomDialog(
                title = "선택된 상품을 My 투썸에서 삭제할까요?",
                onClickCancel = { isDialogVisible = false }, // 다이얼로그 닫기
                onClickConfirm = {
                    isDialogVisible = false
                }
            )
        }
    }
}


@Preview
@Composable
fun MyMenuScreenPreview() {
    TwosomeHeartTheme {
        MyMenuScreen(
            paddingValues = PaddingValues(),
            navigateUp = {},
            viewModel = MyMenuViewModel(),
            state = UiState.Success(
                persistentListOf(
                    MyMenuModel(
                        menuName = "바나나 샷 라떼",
                        menuPrice = 5500,
                        menuImage = R.drawable.img_menu_banana_latte,
                        menuOption = "아이스/라지/블랙그라운드/포장",
                        isChecked = true,
                    ),
                    MyMenuModel(
                        menuName = "바나나 샷 아메리카노",
                        menuPrice = 5800,
                        menuImage = R.drawable.img_menu_banana_ameicano,
                        menuOption = "아이스/라지/블랙그라운드/포장/개인컵",
                        isChecked = false,
                    ),
                    MyMenuModel(
                        menuName = "바나나 샷 아메리카노",
                        menuPrice = 5800,
                        menuImage = R.drawable.img_menu_banana_ameicano,
                        menuOption = "아이스/라지/블랙그라운드/포장/개인컵",
                        isChecked = false,
                    ),
                )
            )
        )
    }
}