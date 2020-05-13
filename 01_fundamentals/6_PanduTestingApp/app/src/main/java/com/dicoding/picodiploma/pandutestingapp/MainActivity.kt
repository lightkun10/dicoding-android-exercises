package com.dicoding.picodiploma.pandutestingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView
    private lateinit var imgPreview: ImageView

    private var names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tv_text)

        btnSetValue = findViewById(R.id.btn_set_value)
        btnSetValue.setOnClickListener(this)

        names.add("Narenda Wicaksono")
        names.add("Kevin")
        names.add("Yoza")

        imgPreview = findViewById(R.id.img_preview)

        /* out of memory dapat terjadi karena ukuran gambar yg dimuat melebihi memori
        yang tersedia untuk menjalankan aplikasi. */
        // imgPreview.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.fronalpstock_big))
        Glide.with(this).load(R.drawable.fronalpstock_big).into(imgPreview)
    }

    override fun onClick(view: View) {
//        if (view.id == R.id.btn_set_value) {
//            tvText.text = "19"
//        }

        if (view.id == R.id.btn_set_value) {
            val name = StringBuilder()

            for (i in 0..2) {
                name.append(names[i]).append("\n")
            }

            tvText.text = name.toString()
        }
    }
}

/* 1. Caused by: kotlin.UninitializedPropertyAccessException:
                 lateinit property btnSetValue has not been initialized

   2.
*/