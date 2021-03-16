package uz.example.staggeredlayoutmanager

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager

fun Context.getScreenResolution(): Pair<Int, Int> {
    val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display: Display? =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            display
        } else {
            wm.defaultDisplay
        }
    val metrics = DisplayMetrics()
    display?.getRealMetrics(metrics)
    val width = metrics.widthPixels
    val height = metrics.heightPixels
    return Pair(width, height)
}