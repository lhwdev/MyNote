package com.lhwdev.compose.materialapp.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.lhwdev.compose.materialapp.AppRouteId
import com.lhwdev.compose.materialapp.AppRouteInfo


val OtherRoute = AppRouteId<Unit>(info = AppRouteInfo(title = "Such wow!"), name = "Other") {
	Other()
}


@Composable
fun Other() {
	Box {
		Text("Hello, world!", style = MaterialTheme.typography.h1, modifier = Modifier.align(Alignment.Center))
	}
}
