package org.techtown.twosomeheart.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Red10 = Color(0xFFFFF3F7)
val Red20 = Color(0xFFFFDEE7)
val Red30 = Color(0xFFFF0150)
val Red40 = Color(0xFFD50037)

val Orange = Color(0xFFF0532A)

val Blue10 = Color(0xFF428BF8)
val Blue20 = Color(0xFF4188BB)

val White = Color(0xFFFFFFFF)
val Gray10 = Color(0xFFF5F5F5)
val Gray20 = Color(0xFFE5E5E5)
val Gray30 = Color(0xFFD5D5D5)
val Gray40 = Color(0xFFA5A5A5)
val Gray50 = Color(0xFF999999)
val Gray60 = Color(0xFF707070)
val Gray70 = Color(0xFF53575A)
val Gray80 = Color(0xFF555555)
val Gray90 = Color(0xFF333333)
val Black = Color(0xFF000000)

val Red40_40 = Color(0x66D50037)
val Red40_12 = Color(0x1FD50037)

data class TwosomeColors(
    val Red10: Color,
    val Red20: Color,
    val Red30: Color,
    val Red40: Color,
    val Orange: Color,
    val Blue10: Color,
    val Blue20: Color,
    val White: Color,
    val Gray10: Color,
    val Gray20: Color,
    val Gray30: Color,
    val Gray40: Color,
    val Gray50: Color,
    val Gray60: Color,
    val Gray70: Color,
    val Gray80: Color,
    val Gray90: Color,
    val Black: Color,
    val Red40_40: Color,
    val Red40_12: Color,
)

val TwosomeHeartColors = TwosomeColors(
    Red10 = Red10,
    Red20 = Red20,
    Red30 = Red30,
    Red40 = Red40,
    Orange = Orange,
    Blue10 = Blue10,
    Blue20 = Blue20,
    White = White,
    Gray10 = Gray10,
    Gray20 = Gray20,
    Gray30 = Gray30,
    Gray40 = Gray40,
    Gray50 = Gray50,
    Gray60 = Gray60,
    Gray70 = Gray70,
    Gray80 = Gray80,
    Gray90 = Gray90,
    Black = Black,
    Red40_40 = Red40_40,
    Red40_12 = Red40_12
)

val LocalTwosomeColors = staticCompositionLocalOf { TwosomeHeartColors }
