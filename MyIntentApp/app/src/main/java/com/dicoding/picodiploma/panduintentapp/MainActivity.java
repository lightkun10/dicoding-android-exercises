package com.dicoding.picodiploma.panduintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Memperkenalkan button yg ditambahkan di layout 'activity_main.xml'  */
        Button btnMoveActivity = findViewById(R.id.btn_move_activity);

        btnMoveActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_move_activity:
                /* Membuat suatu obyek intent dengan memberikan
                    - context(this@MainActivity) dan
                    - kelas activity tujuan (MoveActivity::class.java)
                    pada konstruktor kelas intent.*/
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);

                /* Untuk context dapat menggunakan 'this' yang menandakan obyek kelas saat ini.
                   Kelas tujuan selalu diakhiri dengan menggunakan 'class'. */

                startActivity(moveIntent);
                break;
        }
    }
}
