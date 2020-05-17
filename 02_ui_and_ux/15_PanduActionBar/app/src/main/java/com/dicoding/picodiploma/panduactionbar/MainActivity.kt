package com.dicoding.picodiploma.panduactionbar

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView
        /* Untuk mengambil komponen searchview yang sebelumnya sudah di inflate,
           bisa menggunakan fungsi menu.findItem().getActionView()/.actionView . */

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        /* SetQueryHint() berguna untuk memberikan hint pada pengguna tentang query search apa
           yg telah dimasukkan. Hal ini akan memudahkan pengguna untuk memasukkan suatu kata. */
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            /*
               Gunakan method ini ketika search selesai/tombol submit ditekan
            */
            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@MainActivity, query, Toast.LENGTH_SHORT).show()
                return true
            }

            /*
               Gunakan method ini untuk merespon tiap masukkan/perubahan huruf pada searchView
            */
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        return true
    }

    /* Baris di atas menunjukkan bahwa untuk menampilkan custom item pada action bar,
       kita hanya menggunakan xml dan 1 baris kode. */

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MenuFragment())
                    .addToBackStack(null)
                    .commit()
                return true
            }
            R.id.menu2 -> {
                val i = Intent(this, MenuActivity::class.java)
                startActivity(i)
                return true
            }
            else -> return true
        }
    }
}