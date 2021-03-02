package br.com.odiltonjunior.androiddevchallenge.util

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import br.com.odiltonjunior.androiddevchallenge.ui.theme.AdoptMeTheme

@Composable
internal fun ThemedPreview(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    AdoptMeTheme(darkTheme = darkTheme) {
        Surface {
            content()
        }
    }
}