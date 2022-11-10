package com.codelab.basics.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.codelab.basics.R

// Set of Material typography styles to start with
// 글꼴 설정
val Typography = Typography(
    body1 = TextStyle(
        // custom font
        fontFamily = FontFamily(
            Font(R.font.font_notosans_mid, FontWeight.Normal)
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,

        // 이제 Compose 1.2.0에서 지원 중단된 API PlatformTextStyle을 사용하여 includeFontPadding을 false로 설
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        ),
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

//val fontLight = FontFamily(
//    Font(R.font.font_notosans, FontWeight.Normal)
//)
//val fontNormal = FontFamily(
//    Font(R.font.font_notosans_reg, FontWeight.Normal)
//)
//val fontMedium = FontFamily(
//    Font(R.font.font_notosans_mid, FontWeight.Normal)
//)
//val fontBold = FontFamily(
//    Font(R.font.font_notosans_bold, FontWeight.Normal)
//)