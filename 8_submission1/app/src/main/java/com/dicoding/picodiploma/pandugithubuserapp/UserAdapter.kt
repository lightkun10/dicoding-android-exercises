package com.dicoding.picodiploma.pandugithubuserapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class UserAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var users = arrayListOf<User>()

    override fun getItem(i: Int): Any = users[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getCount(): Int = users.size

    override fun getView(pos: Int, view: View?, viewGroup: ViewGroup?): View {
        var itemView = view

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(pos) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val txtUserName: TextView = view.findViewById(R.id.txt_user_name)
        private val txtRepository: TextView = view.findViewById(R.id.txt_repository)
        private val imgAvatar : ImageView = view.findViewById(R.id.img_avatar)

        internal fun bind(user: User) {
            txtUserName.text = user.username
            txtRepository.text = "User repository: ${user.repository.toString()}"
            imgAvatar.setImageResource(user.avatar)
        }
    }
}