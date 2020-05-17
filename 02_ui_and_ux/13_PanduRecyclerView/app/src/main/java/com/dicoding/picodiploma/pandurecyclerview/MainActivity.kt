package com.dicoding.picodiploma.pandurecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

/*============================== MAIN FUNCTIONALITY ============================*/

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Hero>()
    private var title = "Mode List"
    private var mode: Int = 0

    companion object {
        private const val STATE_TITLE = "state_string"
        private const val STATE_LIST = "state_list"
        private const val STATE_MODE = "state_mode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // atur fixed size recyclerview yang sudah dibuat di activity_main
        rv_heroes.setHasFixedSize(true)

        /* Kode diatas menjelaskan bahwa:
           bila fixed size bernilai true, maka recyclerview dapat melakukan optimasi
           ukuran lebar & tinggi secara otomatis. Nilai lebar dan tinggi
           recyclerview menjadi konstan. */

        // Reset mode if no data being saved
        if (savedInstanceState == null) {
            setActionBarTitle(title)
            list.addAll(getListHeroes())
            showRecyclerList()
            mode = R.id.action_list // change to default(mode list)
        }
        // Save data when screen orientation changed
        else {
            title = savedInstanceState.getString(STATE_TITLE).toString()
            val stateList = savedInstanceState.getParcelableArrayList<Hero>(STATE_LIST)
            val stateMode = savedInstanceState.getInt(STATE_MODE)

            setActionBarTitle(title)

            if(stateList != null) {
                list.addAll(stateList)
            }

            // Don't forget to set mode to saved mode
            setMode(stateMode)
        }
    }

/*============================== END OF MAIN FUNCTIONALITY ==============================*/

    fun getListHeroes(): ArrayList<Hero> {
        // Boilerplate, taken from item_row_hero.xml
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val listHero = ArrayList<Hero>() // Set an array

        for(position in dataName.indices) {
            val hero = Hero(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listHero.add(hero)
        }

        return listHero
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_TITLE, title)
        outState.putParcelableArrayList(STATE_LIST, list)
        outState.putInt(STATE_MODE, mode)
    }

    private fun showRecyclerList() {
        /* Perlu menentukan nilai pada metode setLayoutManager() saja
           untuk menentukan bagaimana recyclerview ditampilkan. */
        rv_heroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rv_heroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object: ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        /* Perlu menentukan nilai pada metode setLayoutManager() saja
           untuk menentukan bagaimana recyclerview ditampilkan. */
        rv_heroes.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridHeroAdapter(list)
        rv_heroes.adapter = gridHeroAdapter

        gridHeroAdapter.setOnItemClickCallback(object: GridHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerCardView() {
        rv_heroes.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter =  CardViewHeroAdapter(list)
        rv_heroes.adapter = cardViewHeroAdapter
    }

    /* REVIEW: This class(MenuInflater) is used to instantiate menu XML files into Menu objects */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // convert menu_main.xml into a menu displayed in activity
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    /* Handle events when each item being selected/pressed */
    private fun setMode(selectedMode: Int) {
        when(selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }
            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardView()
            }
        }

        mode = selectedMode
        setActionBarTitle(title)
    }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "Kamu memilih ${hero.name}", Toast.LENGTH_SHORT).show()
    }

    private fun setActionBarTitle(title: String?) {
        supportActionBar?.title = title
    }
}