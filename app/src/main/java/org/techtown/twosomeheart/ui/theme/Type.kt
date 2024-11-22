package org.techtown.twosomeheart.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import org.techtown.twosomeheart.R

val lineHeightStyle = LineHeightStyle(
    alignment = LineHeightStyle.Alignment.Center,
    trim = LineHeightStyle.Trim.None
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

data class TwosomeTypography(
    val head1B24: TextStyle,
    val head2R22: TextStyle,
    val head3B20: TextStyle,
    val head4B18: TextStyle,
    val head4B18Tight: TextStyle,
    val head4M18: TextStyle,
    val head4R18: TextStyle,
    val titleB16: TextStyle,
    val title1R16: TextStyle,
    val title2B15: TextStyle,
    val body1B14: TextStyle,
    val body1B14Tight: TextStyle,
    val body1M14: TextStyle,
    val body1R14: TextStyle,
    val body2B13: TextStyle,
    val body2R13: TextStyle,
    val caption1B12: TextStyle,
    val caption1M12: TextStyle,
    val caption1R12Tight: TextStyle,
    val caption2M11: TextStyle,
    val caption2R11: TextStyle,
    val caption3M10: TextStyle,
    val caption3R10: TextStyle
)

val TwosomeHeartTypography = TwosomeTypography(
    head1B24 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontSize = 24.sp,
        fontWeight = FontWeight(700),
        lineHeight = 36.sp,
        lineHeightStyle = lineHeightStyle
    ),

    head2R22 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontSize = 22.sp,
        fontWeight = FontWeight(400),
        lineHeight = 36.sp,
        lineHeightStyle = lineHeightStyle
    ),

    head3B20 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontSize = 20.sp,
        fontWeight = FontWeight(700),
        lineHeight = 30.sp,
        lineHeightStyle = lineHeightStyle
    ),

    head4B18 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontSize = 18.sp,
        fontWeight = FontWeight(700),
        lineHeight = 48.sp,
        lineHeightStyle = lineHeightStyle
    ),

    head4B18Tight = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontSize = 18.sp,
        fontWeight = FontWeight(700),
        lineHeight = 48.sp,
        letterSpacing = (-1).sp,
        lineHeightStyle = lineHeightStyle
    ),

    head4M18 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_medium)),
        fontSize = 18.sp,
        fontWeight = FontWeight(500),
        lineHeight = 48.sp,
        lineHeightStyle = lineHeightStyle
    ),

    head4R18 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontSize = 18.sp,
        fontWeight = FontWeight(400),
        lineHeight = 48.sp,
        lineHeightStyle = lineHeightStyle
    ),

    titleB16 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontSize = 16.sp,
        fontWeight = FontWeight(700),
        lineHeight = 24.sp,
        lineHeightStyle = lineHeightStyle
    ),

    title1R16 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontSize = 16.sp,
        fontWeight = FontWeight(400),
        lineHeight = 24.sp,
        lineHeightStyle = lineHeightStyle
    ),

    title2B15 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontSize = 15.sp,
        fontWeight = FontWeight(700),
        lineHeight = 21.sp,
        lineHeightStyle = lineHeightStyle
    ),

    body1B14 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontSize = 14.sp,
        fontWeight = FontWeight(700),
        lineHeight = 21.sp,
        lineHeightStyle = lineHeightStyle
    ),

    body1B14Tight = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontSize = 14.sp,
        fontWeight = FontWeight(700),
        lineHeight = 21.sp,
        letterSpacing = (-1).sp,
        lineHeightStyle = lineHeightStyle
    ),

    body1M14 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_medium)),
        fontSize = 14.sp,
        fontWeight = FontWeight(500),
        lineHeight = 21.sp,
        lineHeightStyle = lineHeightStyle
    ),

    body1R14 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontSize = 14.sp,
        fontWeight = FontWeight(400),
        lineHeight = 21.sp,
        lineHeightStyle = lineHeightStyle
    ),

    body2B13 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontSize = 13.sp,
        fontWeight = FontWeight(700),
        lineHeight = 21.sp,
        lineHeightStyle = lineHeightStyle
    ),

    body2R13 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontSize = 13.sp,
        fontWeight = FontWeight(400),
        lineHeight = 21.sp,
        lineHeightStyle = lineHeightStyle
    ),

    caption1B12 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_bold)),
        fontSize = 12.sp,
        fontWeight = FontWeight(700),
        lineHeight = 18.sp,
        lineHeightStyle = lineHeightStyle
    ),

    caption1M12 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_medium)),
        fontSize = 12.sp,
        fontWeight = FontWeight(500),
        lineHeight = 18.sp,
        lineHeightStyle = lineHeightStyle
    ),

    caption1R12Tight = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontSize = 12.sp,
        fontWeight = FontWeight(400),
        lineHeight = 18.sp,
        letterSpacing = (-0.3).sp,
        lineHeightStyle = lineHeightStyle
    ),

    caption2M11 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_medium)),
        fontSize = 11.sp,
        fontWeight = FontWeight(500),
        lineHeight = 18.sp,
        lineHeightStyle = lineHeightStyle
    ),

    caption2R11 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontSize = 11.sp,
        fontWeight = FontWeight(400),
        lineHeight = 18.sp,
        lineHeightStyle = lineHeightStyle
    ),

    caption3M10 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_medium)),
        fontSize = 10.sp,
        fontWeight = FontWeight(500),
        lineHeight = 18.sp,
        lineHeightStyle = lineHeightStyle
    ),

    caption3R10 = TextStyle(
        fontFamily = FontFamily(Font(R.font.notosanskr_regular)),
        fontSize = 10.sp,
        fontWeight = FontWeight(400),
        lineHeight = 15.sp,
        letterSpacing = 0.3.sp,
        lineHeightStyle = lineHeightStyle
    )
)

val LocalTwosomeHeartTypography = staticCompositionLocalOf { TwosomeHeartTypography }
