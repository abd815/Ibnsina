package com.koyb.spermanalyzer.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection

class LanguageManager {
    var currentLanguage by mutableStateOf("en")
        private set
    
    fun setLanguage(language: String) {
        currentLanguage = language
    }
    
    fun isRtl(): Boolean = currentLanguage == "ar"
    
    fun getLayoutDirection(): LayoutDirection = 
        if (isRtl()) LayoutDirection.Rtl else LayoutDirection.Ltr
}

@Composable
fun rememberLanguageManager(): LanguageManager {
    return remember { LanguageManager() }
}

object LanguageConstants {
    const val ENGLISH = "en"
    const val ARABIC = "ar"
    
    val supportedLanguages = listOf(
        Language(ENGLISH, "English"),
        Language(ARABIC, "العربية")
    )
}

data class Language(
    val code: String,
    val displayName: String
)