package com.lhwdev.compose.materialapp

import androidx.compose.runtime.Composable
import com.lhwdev.compose.navigation.NavigationState


@Composable
actual fun ShortcutRoot(appState: AppState, navigationState: NavigationState, content: @Composable() () -> Unit) {
	// nothing to do
	content()
}
