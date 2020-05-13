package com.example.panduintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_move_for_result.*

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnChoose: Button
    private lateinit var rgNumber: RadioGroup

    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)
        
        btnChoose = findViewById(R.id.btn_choose) // introduce the button component
        rgNumber = findViewById(R.id.rg_number) // introduce the radiogroup component

        btn_choose.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_choose) {
            if (rg_number.checkedRadioButtonId != 0) {
                var value = 0

                // fire when one of the radio button is selected...
                when(rg_number.checkedRadioButtonId) {
                    R.id.rb_50 -> value = 50

                    R.id.rb_100 -> value = 100

                    R.id.rb_150 -> value = 150

                    R.id.rb_200 -> value = 200
                }

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
                setResult(RESULT_CODE, resultIntent)
                finish() // close the MoveForResultActivity


                /* After MoveForResultActivity is perfectly closed,
                then onActivityResult() method on MainActivity will run. */
            }
        }
    }
}