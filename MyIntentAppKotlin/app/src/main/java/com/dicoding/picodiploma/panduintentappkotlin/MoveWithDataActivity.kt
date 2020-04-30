package com.dicoding.picodiploma.panduintentappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        /* Mengambil nilai data berdasarkan key yang dikirimkan dengan menggunakan
            metode getIntent().getStringExtra(key). */
        val name = intent.getStringExtra(EXTRA_NAME)

        /* Nilai berasal dari getIntent().getIntExtra(Key, nilai default).
            Key yg digunakan untuk mengirimkan dan mengambil data adalah EXTRA_AGE
            (yang bernilai “extra_age”). */
        val age = intent.getIntExtra(EXTRA_AGE, 0)

        val text = "Name : $name, Your Age : $age"
        tvDataReceived.text = text
    }
}
