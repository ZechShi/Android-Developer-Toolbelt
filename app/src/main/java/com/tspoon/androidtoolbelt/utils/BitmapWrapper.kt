package com.tspoon.androidtoolbelt.utils

import android.graphics.Bitmap
import android.graphics.Color
import androidx.core.graphics.applyCanvas

class BitmapWrapper(w: Int, h: Int) {

    private fun randomColor(): Int {
        return Color.argb(
            (0..255).random(),
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        )
    }

    private val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888).applyCanvas {
        drawColor(randomColor())
    }
}