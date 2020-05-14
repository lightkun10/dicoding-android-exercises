package com.dicoding.picodiploma.panduviewmodel

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

// extend dari appcompatbutton
class MyButton : AppCompatButton {
    private var enabledBackground: Drawable? = null
    private var disabledBackground: Drawable? = null
    private var txtColor: Int = 0

    /* Need constructors to extend the class */

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    /* Metode onDraw() dari bawaan kelas view untuk mengubah bentuk dari button
       Metode onDraw() digunakan untuk meng-custom button ketika enable dan disable
    */
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // Mengubah background dari Button
        background = when {
            isEnabled -> enabledBackground
            else -> disabledBackground
        }

        // Mengubah warna text pada button
        setTextColor(txtColor)

        // Mengubah ukuran text pada button
        textSize = 12f

        // Menjadikan object pada button menjadi center
        gravity = Gravity.CENTER

        // Mengubah text pada button pada kondisi enable dan disable
        text = when {
            isEnabled -> "Submit"
            else -> "Isi dulu"
        }
    }

    private fun init() {
        txtColor = ContextCompat.getColor(context, android.R.color.background_light)
        enabledBackground = ResourcesCompat.getDrawable(resources, R.drawable.bg_button, null)
        disabledBackground = ResourcesCompat.getDrawable(resources, R.drawable.bg_button_disable, null)
    }
}