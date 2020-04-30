package com.dicoding.picodiploma.bar_volume

import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView

// public class MainActivity extends AppCompatActivity
class MainActivity : AppCompatActivity(), View.OnClickListener {
    /* Variabel yang akan digunakan untuk menampung view. */
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        /* Hasil perhitungan yang ditampilkan pada tvResult
            dimasukkan pada 'bundles' kemudian disimpan isinya.
        */
        super.onSaveInstanceState(outState)

        /* Menyimpan data menggunakan konsep 'key-value'
            key: STATE_RESULT
            value:tvResult */
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    /* Metode onCreate. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set kelas MainActivity menampilkan tampilan yang berasal
        // dari layout 'activity_main.xml'
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen dengan findViewById berfungsi
        // untuk menghubungkan variabel yang kita buat sebelumnya
        // dengan id yang sudah kita buat di dalam layout activity_main.xml.
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        /* Pada onCreate menggunakan nilai bundle yang telah disimpan
            sebelumnya pada onSaveInstanceState */
        if (savedInstanceState != null)
        {
            /* Akses nilai dari key 'STATE_RESULT' */
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tvResult.text = result
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate)
        {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyFields = false

            if (inputLength.isEmpty())
            {
                isEmptyFields = true
                edtLength.error = "Field ini tidak boleh kosong"
            }

            if (inputWidth.isEmpty())
            {
                isEmptyFields = true
                edtWidth.error = "Field ini tidak boleh kosong"
            }

            if (inputHeight.isEmpty())
            {
                isEmptyFields = true
                edtHeight.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyFields)
            {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }
}
