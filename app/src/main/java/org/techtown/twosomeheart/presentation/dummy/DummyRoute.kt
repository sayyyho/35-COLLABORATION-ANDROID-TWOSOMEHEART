package org.techtown.twosomeheart.presentation.dummy

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.collections.immutable.PersistentList
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.core.extension.noRippleClickable
import org.techtown.twosomeheart.core.util.UiState
import org.techtown.twosomeheart.data.dto.response.ResponseDummyDto
import org.techtown.twosomeheart.presentation.dummy.component.DummyItem
import org.techtown.twosomeheart.ui.theme.Red40
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme

@Composable
fun DummyRoute(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    viewModel: DummyViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    LaunchedEffect(true) {
        viewModel.getMyJogboList()
    }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is DummySideEffect.ShowToast -> Toast.makeText(
                        context,
                        R.string.dummy_example_string,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }

    DummyScreen(
        paddingValues = paddingValues,
        navigateUp = navigateUp,
        state = state.uiState
    )
}

@Composable
fun DummyScreen(
    paddingValues: PaddingValues,
    navigateUp: () -> Unit,
    state: UiState<PersistentList<ResponseDummyDto>>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Red40)
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (state) {
            is UiState.Loading -> {
                item {
                    Text(
                        modifier = modifier
                            .noRippleClickable { navigateUp() },
                        textAlign = TextAlign.Center,
                        text = "로딩 중...",
                        style = TwosomeHeartTheme.typography.caption3R10
                    )
                }
            }

            is UiState.Empty -> {
                item {
                    Text(
                        modifier = modifier
                            .noRippleClickable { navigateUp() },
                        textAlign = TextAlign.Center,
                        text = "데이터가 없습니다.",
                        fontSize = 30.sp
                    )
                }
            }

            is UiState.Failure -> {
                item {
                    Text(
                        modifier = modifier
                            .noRippleClickable { navigateUp() },
                        textAlign = TextAlign.Center,
                        text = "데이터를 불러오지 못했습니다.",
                        fontSize = 30.sp
                    )
                }
            }

            is UiState.Success -> {
                itemsIndexed(state.data) { index, item ->
                    DummyItem(
                        id = item.id,
                        email = item.email,
                        firstName = item.firstName,
                        lastName = item.lastName,
                        avatarUrl = item.avatar
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun DummyScreenPreview() {
    TwosomeHeartTheme {
        DummyScreen(
            paddingValues = PaddingValues(),
            navigateUp = {},
            state = UiState.Loading
        )
    }
}
