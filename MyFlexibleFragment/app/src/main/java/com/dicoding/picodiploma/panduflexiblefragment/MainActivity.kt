package com.dicoding.picodiploma.panduflexiblefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Pemasangan HomeFragment ke dlm activity ini sehingga bisa tampil ke layar pengguna */
        /* Menggunakan instance dari FragmentManager, antarmuka untuk mengorganisir
           objek fragment yang terdapat didalam sebuah activity.  */
        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)
        
        /* FragmentTransaction merupakan fungsi untuk melakukan operasi pada fragment 
           seperti add(), replace(), commit() dsb. */

        /* Disini proses manipulasi penambahan fragment ke dalam activity terjadi. */
        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name : " + HomeFragment::class.java.simpleName)

            mFragmentManager
                // Memulai proses perubahan.
                .beginTransaction()
                // Menambahkan objek fragment ke dalam layout container.
                /* Layout container ini merupakan objek framelayout dengan:
                   - ID frame_container
                   - tag dengan nama kelas dari HomeFragment itu sendiri. */
                .add(R.id.frame_container, mHomeFragment, HomeFragment::class.java.simpleName)
                /* Mengeksekusi untuk melakukan pemasangan objek secara asynchronous untuk
                   ditampilkan ke antar muka pengguna (user interface). */
                .commit()
        }
    }
}
