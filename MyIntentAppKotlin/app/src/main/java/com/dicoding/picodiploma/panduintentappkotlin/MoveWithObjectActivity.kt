package com.dicoding.picodiploma.panduintentappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {
    /* EXTRA_PERSON adalah variable static bertipe data string bernilai "extra_person".
       Berfungsi sebagai key untuk mendapatkan value data yang dikirim. */
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        /* Kenalkan textview pada MoveWithObjectActivity */
        val tvObject: TextView = findViewById(R.id.tv_object_received)

        /* Kode untuk menerima obyek dari activity Asal. */
        /* Melalui getIntent().getParcelableExtra(Key), saya dapat
           mengambil nilai obyek person yang sebelumnya telah dikirim
           hanya dengan satu variabel */
        val person = intent.getParcelableExtra(EXTRA_PERSON) as Person

        /* Menampilkan data obyek yang sudah diterima. */
        val text = "Name : ${person.name.toString()}, \nEmail : ${person.email}, \nAge : ${person.age}, \nLocation : ${person.city}"
        tvObject.text = text
    }
}
