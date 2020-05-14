package com.dicoding.picodiploma.panduviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMyButtonEnable()

        my_edit_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // nothing
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }

            override fun afterTextChanged(s: Editable) {
                // nothing
            }

        })

        my_button.setOnClickListener { Toast.makeText(this@MainActivity, my_edit_text.text, Toast.LENGTH_SHORT).show() }
    }

    private fun setMyButtonEnable() {
        val result = my_edit_text.text

        /* Saat pertama kali aplikasi dibuka perlu melakukan checking terhadap
           my_edit_text apakah ada teks atau tidak. Jika tidak ada teks maka
           my_button akan menjadi disable. */
        my_button.isEnabled = result != null && result.toString().isNotEmpty()
    }
}