package com.lhwdev.compose.platform

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.DensityAmbient
import com.lhwdev.compose.materialapp.AppRouteInfo

fun Context.getStatusBarHeight(): Int {
    var result = 0
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = resources.getDimensionPixelSize(resourceId)
    }
    return result
}


actual object ComposeUiPlatform {
    actual val platformType = PlatformType.mobile
    actual fun topEffect(info: AppRouteInfo) = @Composable {
        val height = ContextAmbient.current.getStatusBarHeight()
        Box(
            Modifier
                .fillMaxWidth()
                .height(with(DensityAmbient.current) { height.toDp() })
        )
    }
}
