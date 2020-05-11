package com.dicoding.picodiploma.pandugithubuserapp

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    /* Preparing data */
    private lateinit var username: Array<String>
    private lateinit var name: Array<String>
    private lateinit var location: Array<String>
    private lateinit var repos: Array<String>
    private lateinit var company: Array<String>
    private lateinit var followers: Array<String>
    private lateinit var following: Array<String>
    private lateinit var avatars: TypedArray

    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = UserAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener {_, _, pos, _ ->
            Toast.makeText(this@MainActivity, users[pos].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare() {
        username = resources.getStringArray(R.array.username)
        repos = resources.getStringArray(R.array.repository)
        avatars = resources.obtainTypedArray(R.array.avatar)
        name = resources.getStringArray(R.array.name)
        location = resources.getStringArray(R.array.location)
        company = resources.getStringArray(R.array.company)
        followers = resources.getStringArray(R.array.followers)
        following = resources.getStringArray(R.array.following)
    }

    private fun addItem() {
        for(pos in username.indices) {
            val user = User(
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
    }
}