package org.techtown.twosomeheart.presentation.mymenu

import android.annotation.SuppressLint
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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
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
import org.techtown.twosomeheart.presentation.mymenu.component.MyMenuBottomSheet
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
        toggleItemChecked = viewModel::toggleItemChecked
    )
}

@SuppressLint("ResourceType")
@Composable
fun MyMenuScreen(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    state: UiState<PersistentList<MyMenuModel>>,
    navigateUp: () -> Unit,
    toggleItemChecked: (Int, Boolean, Boolean) -> Unit
) {

    val isMyBottomSheetVisible by remember(state) {
        derivedStateOf {
            state is UiState.Success && state.data.any { it.isChecked }
        }
    }
    var isDialogVisible by remember { mutableStateOf(false) }
    var isAllSelect by remember { mutableStateOf(false) }

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
                        modifier = Modifier.noRippleClickable(onClick = navigateUp)
                    )
                },
                text = stringResource(R.string.menu_top_bar),
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_mymenu_plus),
                        contentDescription = stringResource(R.string.menu_top_bar)
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
                        modifier = Modifier.noRippleClickable {
                            isAllSelect = !isAllSelect
                            toggleItemChecked(0, true, isAllSelect)
                        },
                        imageVector = ImageVector.vectorResource(
                            if (isAllSelect) {
                                R.drawable.ic_mymenu_checkbox_select
                            } else {
                                R.drawable.ic_modal_checkbox_diselect
                            }
                        ),
                        contentDescription = "",
                        tint = Color.Unspecified,

                        )

                    Text(
                        text = stringResource(R.string.my_menu_all_select_title),
                        style = TwosomeHeartTypography.title1R16,
                        color = TwosomeHeartColors.Gray90
                    )
                }

                Text(
                    modifier = Modifier.noRippleClickable {
                        isDialogVisible = true
                    },
                    text = stringResource(R.string.my_menu_select_delete_title),
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
                                isChecked = if (isAllSelect) {
                                    true
                                } else {
                                    item.isChecked
                                },
                                onCheckedChange = { toggleItemChecked(index, false, false) }
                            )
                            if (index != state.data.lastIndex) {
                                Spacer(modifier = Modifier.height(40.dp))
                            } else if (index == state.data.lastIndex && isMyBottomSheetVisible) {
                                Spacer(modifier = Modifier.height(150.dp))
                            }
                        }
                    }
                }
            }
        }

        if(isMyBottomSheetVisible) {
            MyMenuBottomSheet(
                modifier = Modifier
                    .align(Alignment.BottomCenter),
                price = 5500,
                count = stringResource(R.string.my_menu_select_count),
                place = stringResource(R.string.menu_ordered_store_name),
            )
        }

        if (isDialogVisible) {
            CustomDialog(
                title = stringResource(R.string.my_menu_dialog_title),
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
            toggleItemChecked = { _, _, _ -> },
            state = UiState.Success(
                persistentListOf(
                    MyMenuModel(
                        menuName = "바나나 샷 라떼",
                        menuPrice = 5500,
                        menuImage = "https://github.com/user-attachments/assets/4b7b216c-0ea9-4034-a88c-953a6f761f98",
                        menuOption = "아이스/라지/블랙그라운드/포장",
                        isChecked = true,
                    ),
                    MyMenuModel(
                        menuName = "바나나 샷 아메리카노",
                        menuPrice = 5800,
                        menuImage = "https://github.com/user-attachments/assets/4b7b216c-0ea9-4034-a88c-953a6f761f98",
                        menuOption = "아이스/라지/블랙그라운드/포장/개인컵",
                        isChecked = false,
                    ),
                    MyMenuModel(
                        menuName = "바나나 샷 아메리카노",
                        menuPrice = 5800,
                        menuImage = "https://github.com/user-attachments/assets/4b7b216c-0ea9-4034-a88c-953a6f761f98",
                        menuOption = "아이스/라지/블랙그라운드/포장/개인컵",
                        isChecked = false,
                    ),
                    MyMenuModel(
                        menuName = "바나나 샷 아메리카노",
                        menuPrice = 5800,
                        menuImage = "https://github.com/user-attachments/assets/4b7b216c-0ea9-4034-a88c-953a6f761f98",
                        menuOption = "아이스/라지/블랙그라운드/포장/개인컵",
                        isChecked = false,
                    ),
                )
            )
        )
    }
}