package com.dicoding.picodiploma.pandugithubuserapp

import android.app.Person
import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Preparing Adapter
    private lateinit var adapter: UserAdapter
    // Preparing array of User
    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = lv_list

        adapter = UserAdapter(this)
        listView.adapter = adapter

        prepare()

        listView.onItemClickListener = AdapterView.OnItemClickListener {_, _, pos, _ ->
            val moveWithObjectIntent = Intent(this@MainActivity, DataUserActivity::class.java)
            moveWithObjectIntent.putExtra(DataUserActivity.EXTRA_USER, users[pos])
            startActivity(moveWithObjectIntent)
        }
    }

    /* Preparing data */
    private fun prepare() {
        val username: Array<String> = resources.getStringArray(R.array.username)
        val repos: Array<String> = resources.getStringArray(R.array.repository)
        val avatars: TypedArray = resources.obtainTypedArray(R.array.avatar)
        val name: Array<String> = resources.getStringArray(R.array.name)
        val location: Array<String> = resources.getStringArray(R.array.location)
        val company: Array<String> = resources.getStringArray(R.array.company)
        val followers: Array<String> = resources.getStringArray(R.array.followers)
        val following: Array<String> = resources.getStringArray(R.array.following)

        addItem(username, repos, avatars, name, location, company, followers, following)
    }

    private fun addItem(username: Array<String>, repos: Array<String>, avatars: TypedArray, name: Array<String>, location: Array<String>, company: Array<String>, followers: Array<String>, following: Array<String>) {
        for(pos in username.indices) {
            val user = User(
                // Add according to the place on User.kt
                avatars.getResourceId(pos, -1),
                username[pos],
                name[pos],
                location[pos],
                repos[pos].toInt(),
                company[pos],
                followers[pos].toInt(),
                following[pos].toInt()
            )
            users.add(user)
        }
        adapter.users = users
        avatars.recycle() // empty the cache after being used
    }
}