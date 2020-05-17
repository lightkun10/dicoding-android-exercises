package com.dicoding.picodiploma.pandurecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_cardview_hero.view.*

/* REVIEW:
   LayoutInflater is a fundamental component in Android. You must use it all the time
   to turn xml files into view hierarchies. */

class CardViewHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<CardViewHeroAdapter.CardViewViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cardview_hero, viewGroup, false);
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(listHero[position])
    }



    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hero: Hero) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(img_item_photo)

                /* Glide digunakan untuk memuat sebuah gambar, baik yang sudah disiapkan
                   di drawable maupun berada di server. */

                tv_item_name.text = hero.name
                tv_item_description.text = hero.description

                // Set effect when FAVORITE button is clicked
                btn_set_favorite.setOnClickListener {
                    Toast.makeText(itemView.context, "Favorite: ${hero.name}", Toast.LENGTH_SHORT).show() }

                // Set effect when SHARE button is clicked
                btn_set_share.setOnClickListener {
                    Toast.makeText(itemView.context, "Share: ${hero.name}", Toast.LENGTH_SHORT).show() }

                // Set effect when item is clicked
                itemView.setOnClickListener {
                    Toast.makeText(itemView.context, "Kamu memilih: ${hero.name}", Toast.LENGTH_SHORT).show() }

                // EXPERIMENTAL. Change intent when button is clicked
//                btn_detail.setOnClickListener {
//                    val intent = Intent(itemView.context, DetailActivity::class.java)
//                    itemView.context.startActivity(intent)
//                }
            }
        }
    }


}