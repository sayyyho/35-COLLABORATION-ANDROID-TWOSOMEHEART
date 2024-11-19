package org.techtown.twosomeheart.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object TwosomeHeartTheme {
    val colors: TwosomeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalTwosomeColors.current

    val typography: TwosomeTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTwosomeHeartTypography.current
}

@Composable
fun ProvideTwosomeTheme(
    colors: TwosomeColors,
    typography: TwosomeTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalTwosomeColors provides colors,
        LocalTwosomeHeartTypography provides typography,
        content = content
    )
}

@Composable
fun TwosomeHeartTheme(
    backgroundColor: Color = TwosomeHeartColors.White,
    content: @Composable () -> Unit
) {
    ProvideTwosomeTheme(
        colors = TwosomeHeartColors,
        typography = TwosomeHeartTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    statusBarColor = backgroundColor.toArgb()
                    WindowCompat.getInsetsController(this, view).isAppearanceLightNavigationBars =
                        true
                }
            }
        }
        MaterialTheme(
            typography = Typography,
            content = content
        )
    }
}
