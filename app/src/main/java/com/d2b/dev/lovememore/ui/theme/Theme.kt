package com.d2b.dev.lovememory.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Primary,
    background = Color(0xFF101010),
    onBackground = Color.White,
    surface = SurfaceDarkMode,
    onSurface = OnSurfaceDarkMode
)

private val LightColorPalette = lightColors(
    primary = Primary,
    background = LightBlue,
    onBackground = Color.Black,
    surface = SurfaceLightMode,
    onSurface = OnSurfaceLightMode

/* Other default colors to override
background = Color.White,
surface = Color.White,
onPrimary = Color.White,
onSecondary = Color.Black,
onBackground = Color.Black,
onSurface = Color.Black,
*/

)

@Composable
fun LoveMemoreTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}