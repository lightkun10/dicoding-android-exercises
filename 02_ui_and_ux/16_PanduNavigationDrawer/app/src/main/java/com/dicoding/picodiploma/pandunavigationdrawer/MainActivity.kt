package com.dicoding.picodiploma.pandunavigationdrawer

import android.os.Bundle
import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    internal lateinit var profileCircleImageView: CircleImageView
    internal var profileImageUrl = "https://pbs.twimg.com/profile_images/1245680735068942336/fL0sJAM9_400x400.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

            /* Obyek fab diberikan listener onClickListener() untuk
               menampilkan sebuah Snackbar. Snackbar adalah suksesor dari toast.
               Perbedaan mendasar (bila dibanding dengan Toast) adalah
               pada Snackbar Anda bisa menambahkan sebuah action untuk melakukan
               sebuah aksi tertentu. Hal ini tidak bisa dilakukan pada toast. */
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        /*  NavigationView menampung semua menu dan sebuah header. Karena itulah
        jika Anda ingin mengubah komponen view yang terdapat di dalam header sebuah
        navigation view, maka proses casting/inisialisasi komponen harus dilakukan dgn cara seperti ini: */
        profileCircleImageView = navView.getHeaderView(0).findViewById(R.id.imageView)
        // imageView is from nav_header_main
        /* Kenapa harus 0? Ini karena indeks header berada pada susunan teratas dr
           kumpulan list menu yang terdapat pada NavigationView. */

        Glide.with(this)
            .load(profileImageUrl)
            .into(profileCircleImageView)

        /* Melakukan proses perpindahan otomatis yg diawali
           di mobile_navigation */
        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
            R.id.nav_share, R.id.nav_send, R.id.nav_cart)
            .setDrawerLayout(drawerLayout)
            .build()

        val navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        /* Berikut adalah fungsi masing-masing dari kode di atas:
        *  appBarConfiguration
           berisi kumpulan id yg ada di dalam menu NavigationDrawer (baris 3). Jika id yang ada
           di dalam menu NavigationDrawer ditambahkan di AppBarConfiguration, maka AppBar akan
           berbentuk Menu NavigationDrawer. Jika tidak ditambahkan, maka akan
           menampilkan tanda panah kembali.
        *  setupActionBarWithNavController
           digunakan untuk mengatur judul AppBar agar sesuai dgn Fragment yg ditampilkan.
        *  setupWithNavController
           digunakan supaya NavigationDrawer menampilkan Fragment yg sesuai ketika menu dipilih.*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

        /* kode di atas digunakan untuk mengatur ketika tombol back ditekan.
        Misalnya ketika Anda di halaman CartFragment, jika Anda tekan tombol back,
        maka aplikasi tidak langsung keluar, melainkan akan menuju ke startDestination
        yg ada di Navigation Graph, yaitu HomeFragment. */
    }
}