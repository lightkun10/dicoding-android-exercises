package com.dicoding.picodiploma.pandu_bar_volume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

/* Kelas Kotlin ini merupakan sebuah activity karena inherit
   (turunan) dari 'superclass' bernama 'AppCompatActivity'.
   View.OnClickListener adalah listener yang diimplementasikan
   untuk memantau kejadian klik pada komponen tombol(button). */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    /* Deklarasi semua komponen view yang akan dimanipulasi.
       Dideklarasikan secara global agar bisa dikenal di keseluruhan bagian kelas. */
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())

        /* Calculation result displayed on tvResult put into 'bundle' and saved.
        Data being 'saved' using key-value concept with:
        - STATE_RESULT as KEY,
        - tvResult data as VALUE.

        'onsaveInstanceState' function will be called automatically before
        every Activity destroyed.

        onSaveInstance being added to avoid current activity being destroyed
        when phone orientation changed and onCreate function being resetted,
        thus I have to save the calculation data.
        */
    }

    /*
    Metode onCreate() merupakan metode utama pada activity.
    Di sinilah kita dapat mengatur layout xml. Semua proses
    inisialisasi komponen yg digunakan akan dijalankan di sini. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* Membuat kelas MainActivity menampilkan tampilan yang
        berasal dari layout activity_main.xml. */
        setContentView(R.layout.activity_main)

        /* Inisialisasi komponen dengan findViewById berfungsi untuk
           menghubungkan variabel yang kita buat sebelumnya dengan id yang
           sudah kita buat di dalam layout activity_main.xml. */
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        /* ^^^ Maksud dari kode diatas adalah objek edittext edtWidth disesuaikan
           (cast) dgn komponen edittext ber-id edt_width di layout xml melalui
           metode findViewById(). */

        btn_calculate.setOnClickListener(this)

        /* keyword 'this' merujuk pada objek Activity saat ini yg mengimplementasikan
           OnClickListener sebelumnya. */

        /*  Pada onCreate menggunakan nilai bundle yang telah disimpan
            sebelumnya pada onSaveInstanceState */
        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tvResult.text = result
        }

        /* In onCreate I use saved bundle value from onSaveInstanceState.
           Get the value from the same key that being saved, that "STATE_RESULT".
           Then put it again to tvResult.  */
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate) {

            /* Ambil isi edittext lalu disimpan dalam variabel.
            Fungsi '.trim()' menghiraukan spasi jika ada, agar nilai hanya berupa angka. */
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            /* Validation for empty input. */
            var isEmptyFields = false

            if (inputLength.isEmpty()) {
                isEmptyFields = true
                edtLength.error = "Field ini tidak boleh kosong"
            }

            if (inputWidth.isEmpty()) {
                isEmptyFields = true
                edtWidth.error = "Field ini tidak boleh kosong"
            }

            if (inputHeight.isEmpty()) {
                isEmptyFields = true
                edtHeight.error = "Field ini tidak boleh kosong"
            }

            /* If all input is not empty, do the calculation. */
            if (!isEmptyFields) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }

        }
    }
}
