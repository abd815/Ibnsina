package com.koyb.spermanalyzer.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Composition local for language selection
val LocalLanguage = staticCompositionLocalOf { "en" }

private val DarkColorScheme = darkColorScheme(
    primary = CyanBlue,
    onPrimary = DeepNavyBlue,
    primaryContainer = SecondaryNavy,
    onPrimaryContainer = TextPrimary,
    
    secondary = CyanBlue,
    onSecondary = DeepNavyBlue,
    secondaryContainer = SurfaceVariant,
    onSecondaryContainer = TextSecondary,
    
    tertiary = SuccessGreen,
    onTertiary = TextPrimary,
    tertiaryContainer = SurfaceVariant,
    onTertiaryContainer = TextSecondary,
    
    error = ErrorRed,
    onError = TextPrimary,
    errorContainer = SurfaceVariant,
    onErrorContainer = WarningOrange,
    
    background = DeepNavyBlue,
    onBackground = TextPrimary,
    surface = SecondaryNavy,
    onSurface = TextPrimary,
    surfaceVariant = SurfaceVariant,
    onSurfaceVariant = OnSurfaceVariant,
    
    outline = TextSecondary,
    outlineVariant = OnSurfaceVariant,
    
    inverseSurface = TextPrimary,
    inverseOnSurface = DeepNavyBlue,
    inversePrimary = SecondaryNavy,
    
    surfaceTint = CyanBlue,
    scrim = DeepNavyBlue
)

private val LightColorScheme = lightColorScheme(
    primary = CyanBlue,
    onPrimary = TextPrimary,
    primaryContainer = LightSurface,
    onPrimaryContainer = LightOnSurface,
    
    secondary = SecondaryNavy,
    onSecondary = TextPrimary,
    secondaryContainer = LightSurface,
    onSecondaryContainer = LightOnSurface,
    
    tertiary = SuccessGreen,
    onTertiary = TextPrimary,
    tertiaryContainer = LightSurface,
    onTertiaryContainer = LightOnSurface,
    
    error = ErrorRed,
    onError = TextPrimary,
    errorContainer = LightSurface,
    onErrorContainer = ErrorRed,
    
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurface,
    onSurfaceVariant = LightOnSurface,
    
    outline = TextSecondary,
    outlineVariant = OnSurfaceVariant,
    
    inverseSurface = DeepNavyBlue,
    inverseOnSurface = TextPrimary,
    inversePrimary = CyanBlue,
    
    surfaceTint = CyanBlue,
    scrim = DeepNavyBlue
)

@Composable
fun SpermAnalyzerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    language: String = "en",
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    val typography = when (language) {
        "ar" -> ArabicTypography
        else -> Typography
    }
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            window.navigationBarColor = colorScheme.surface.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = !darkTheme
        }
    }

    CompositionLocalProvider(LocalLanguage provides language) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}