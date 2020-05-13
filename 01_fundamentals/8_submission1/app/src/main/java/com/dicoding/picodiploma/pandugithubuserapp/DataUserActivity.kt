package com.dicoding.picodiploma.pandugithubuserapp

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DataUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_user)

        val user = intent.getParcelableExtra(EXTRA_USER) as User

        // avatar user
        val imgAvatarReceived: ImageView = findViewById(R.id.user_img_avatar)
        user.avatar?.let { imgAvatarReceived.setImageResource(it) }

        // nama user
        val tvNameReceived: TextView = findViewById(R.id.tv_name_received)
        tvNameReceived.text = user.name
        // username user
        val tvUsernameReceived: TextView = findViewById(R.id.tv_username_received)
        tvUsernameReceived.text = "@${user.username}"
        // lokasi user
        val tvLocationReceived: TextView = findViewById(R.id.tv_location_received)
        tvLocationReceived.text = "Lokasi: ${user.location}"
        // followers user
        val tvFollowersReceived: TextView = findViewById(R.id.tv_followers_received)
        tvFollowersReceived.text = "Followers: ${user.followers}"
        // following user
        val tvFollowingReceived: TextView = findViewById(R.id.tv_following_received)
        tvFollowingReceived.text = "Following: ${user.following}"
    }




    companion object {
        const val EXTRA_USER = "extra_user"
        const val EXTRA_NAME = "extra_name"
    }
}