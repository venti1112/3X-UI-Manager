package net.yukh.xui.i18n

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf

/**
 * Current UI language for the composition. Provided at the app root from
 * [LanguageState]. Defaults to English.
 */
val LocalAppLanguage = compositionLocalOf { LANG_EN }

/**
 * Translate an English source string to the current UI language. The English
 * text IS the key — anything missing from [ruStrings] or [zhStrings] falls back
 * to English, so partial coverage degrades gracefully rather than breaking.
 */
@Composable
@ReadOnlyComposable
fun tr(en: String): String = tr(LocalAppLanguage.current, en)

/** Non-composable variant for the rare call site outside composition. */
fun tr(lang: String, en: String): String = when (lang) {
    LANG_RU -> ruStrings[en] ?: en
    LANG_ZH -> zhStrings[en] ?: en
    else -> en
}
