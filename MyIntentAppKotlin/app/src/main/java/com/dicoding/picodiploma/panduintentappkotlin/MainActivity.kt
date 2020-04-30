package com.dicoding.picodiploma.panduintentappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)

        btnMoveActivity.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_move_activity -> {

                /* Membuat suatu obyek intent dengan memberikan:
                    - context (this@MainActivity)
                    - kelas activity tujuan (MoveActivity::class.java)
                   pada konstruktor kelas intent. */
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                /* Untuk context dapat menggunakan 'this' yg menandakan obyek kelas saat ini.
                   Sedangkan kelas tujuan selalu diakhiri dgn menggunakan class. */

                /* Menjalankan activity baru tanpa membawa data. */
                startActivity(moveIntent)
            }
        }
    }
}
