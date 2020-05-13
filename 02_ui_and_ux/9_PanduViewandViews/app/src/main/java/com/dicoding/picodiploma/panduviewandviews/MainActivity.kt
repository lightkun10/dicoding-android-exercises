package com.dicoding.picodiploma.panduviewandviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (supportActionBar != null) {
//            (supportActionBar as ActionBar).title = "Google Pixel"
//        }
/*        Change / convert to Kotlin: */
        supportActionBar?.title = "Google Pixel" // if not null

        /* Baris di atas akan mengganti nilai dari judul halaman pada actionbar
           di dalam MainActivity. Kita menggunakan supportActionBar() karena
           kelas MainActivity inherit kepada appcompatactivity, yang merupakan kelas turunan activity.
           Kelas tersebut sudah menyediakan fasilitas komponen actionbar dan mendukung semua versi OS Android. */
    }
}