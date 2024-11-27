package org.techtown.twosomeheart.presentation.mymenu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import org.techtown.twosomeheart.ui.theme.TwosomeHeartColors
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography


@Composable
fun CustomDialog(
    title: String,
    onClickCancel: () -> Unit,
    onClickConfirm: () -> Unit
) {
    Dialog(
        onDismissRequest = { onClickCancel() },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
        )
    ) {

        Box {

            Column(
                modifier = Modifier
                    .width(LocalConfiguration.current.screenWidthDp.dp * 0.8f)
                    .background(
                        color = Color.White,
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(
                    modifier = Modifier.padding(
                        horizontal = 26.dp,
                        vertical = 34.dp
                    ),
                    text = title,
                    textAlign = TextAlign.Center,
                    style = TwosomeHeartTypography.body1R14
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                ) {

                    Button(
                        onClick = { onClickCancel() },
                        shape = RectangleShape,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .border(width = 1.dp, color = TwosomeHeartColors.Gray20),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = TwosomeHeartColors.White,
                            contentColor = TwosomeHeartColors.Black,
                        ),
                    ) {

                        Text(
                            text = "취소",
                            textAlign = TextAlign.Center,
                            style = TwosomeHeartTypography.body1R14
                        )
                    }

                    Button(
                        onClick = { onClickConfirm() },
                        shape = RectangleShape,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .border(width = 1.dp, color = TwosomeHeartColors.Gray20),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = TwosomeHeartColors.White,
                            contentColor = TwosomeHeartColors.Red40,
                        ),
                    ) {
                        
                        Text(
                            text = "확인",
                            textAlign = TextAlign.Center,
                            style = TwosomeHeartTypography.body1R14
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CustomDialogPreview() {
    TwosomeHeartTheme {
        CustomDialog(
            title = "선택된 상품을 My 투썸에서 삭제할까요?",
            onClickCancel = {},
            onClickConfirm = {}
        )
    }
}