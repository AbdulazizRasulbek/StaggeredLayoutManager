package uz.example.staggeredlayoutmanager

import androidx.annotation.DrawableRes

data class Data(@DrawableRes val image: Int, val type: Type, val name: String)

enum class Type() {
    HORIZONTAL, VERTICAL, SQUARE
}
