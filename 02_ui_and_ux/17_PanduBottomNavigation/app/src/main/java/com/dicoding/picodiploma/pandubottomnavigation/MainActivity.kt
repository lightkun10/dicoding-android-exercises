package com.dicoding.picodiploma.pandubottomnavigation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,
                R.id.navigation_profile
        ).build()
        /* AppBarConfiguration berisi kumpulan id yg ada di dlm
           menu BottomNavigation(bottom_nav_menu.xml), khususnya yg
           ingin dikonfigurasi AppBar-nya supaya berbentuk Menu. Jika
           id tidak Anda tambahkan di sini, maka AppBar akan menampilkan
           tanda panah kembali.
        */
        setupActionBarWithNavController(navController, appBarConfiguration)
        /* Kemudian setupActionBarWithNavController digunakan untuk
           mengatur judul AppBar agar sesuai dgn Fragment yg ditampilkan. */
        navView.setupWithNavController(navController)
        /* Terakhir, setupWithNavController digunakan supaya ButtomNavigation
           menampilkan Fragment yg sesuai ketika menu dipilih. */
    }
}