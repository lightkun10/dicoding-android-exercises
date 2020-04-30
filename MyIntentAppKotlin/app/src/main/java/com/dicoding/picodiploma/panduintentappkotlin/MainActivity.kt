package com.dicoding.picodiploma.panduintentappkotlin

import android.content.Intent
import android.net.Uri
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

        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)

        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)
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

            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)

                /* Menempatkan data ke obyek Intent pada baris ini. */
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "PandupanduPanda")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 25)
                startActivity(moveWithDataIntent)

                /* Pergi ke MoveWithDataActivity.kt untuk langkah selanjutnya. */
            }

            R.id.btn_move_activity_object -> {
                /* Membuat Obyek Person bernama 'person'
                yang mana kelas tersebut adalah Parcelable. */
                val person = Person(
                    "Pandu Panda",
                    25,
                    "academy@dicoding.com",
                    "Pekanbaru"
                )

                /* Mengirimkan obyek 'person' ke MoveWithObjectActivity melalui intent di bawah: */
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)

                /* EXTRA_PERSON adalah variable static bertipe data string bernilai "extra_person".
                   Berfungsi sebagai key untuk mendapatkan value data yang dikirim. */
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "081210841382"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))

                startActivity(dialPhoneIntent)
            }

        }
    }
}
