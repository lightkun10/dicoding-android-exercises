package com.example.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

/* Constructor digunakan untuk mengirimkan data atau
   melakukan suatu proses ketika suatu obyek diinisialisasi.

   Disini menggunakan adapter yang lebih kompleks, BaseAdapter.
   Kita bisa gunakan BaseAdapter untuk membuat custom adapter.*/
class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {

    /* Variable heroes berfungsi untuk menampung data yang dikirim dari activity
       dan digunakan sebagai sumber data untuk dimasukkan ke dalam ViewHolder. */
    internal var heroes = arrayListOf<Hero>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        // Melakukan proses pemanggilan textview dan setText
        var itemView = view

        if(itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    /* Implementasi metode yang dibutuhkan oleh BaseAdapter:
       - Metode getCount() digunakan untuk mengetahui berapa banyak item yang akan ditampilkan.
       - Metode getView()  digunakan untuk memanggil layout item xml yang sudah dibuat dan
         melakukan proses manipulasi setiap komponennya seperti textview dan imageview melalui kelas ViewHolder. */

    override fun getItem(i: Int): Any {
        return heroes[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return heroes.size
    }


    private inner class ViewHolder internal constructor(view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(hero: Hero) {
            txtName.text = hero.name
            txtDescription.text = hero.description
            imgPhoto.setImageResource(hero.photo)
        }
    }
}