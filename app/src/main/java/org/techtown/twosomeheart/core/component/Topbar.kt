package org.techtown.twosomeheart.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.techtown.twosomeheart.R
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTheme
import org.techtown.twosomeheart.ui.theme.TwosomeHeartTypography
import org.techtown.twosomeheart.ui.theme.White

@Composable
fun Topbar(
    text: String,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable () -> Unit = {},
    leadingIcon2: @Composable () -> Unit = {},
    trailingIcon: @Composable () -> Unit = {},
    trailingIcon2: @Composable () -> Unit = {},
    trailingIcon3: @Composable () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f).padding(start = 8.dp)
        ) {
            leadingIcon()

            leadingIcon2()
        }

        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = TwosomeHeartTypography.head4B18,
            modifier = Modifier.weight(1f)
        )

        Row(
            modifier = Modifier.weight(1f).padding(end = 4.dp),
            horizontalArrangement = Arrangement.End
        ) {
            trailingIcon()

            trailingIcon2()

            trailingIcon3()
        }
    }
}

@Preview
@Composable
fun TopbarPreview() {
    TwosomeHeartTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Topbar(
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                        contentDescription = ""
                    )
                },
                leadingIcon2 = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_home),
                        contentDescription = ""
                    )
                },
                text = "투썸오더",
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_home),
                        contentDescription = ""
                    )
                },
                trailingIcon2 = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_home),
                        contentDescription = ""
                    )
                },
                trailingIcon3 = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_home),
                        contentDescription = ""
                    )
                },
            )

            Topbar(
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                        contentDescription = ""
                    )
                },
                leadingIcon2 = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_home),
                        contentDescription = ""
                    )
                },
                text = "투썸오더",
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_home),
                        contentDescription = ""
                    )
                },
            )

            Topbar(
                text = "투썸오더",
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_home),
                        contentDescription = ""
                    )
                }
            )
        }
    }
}
