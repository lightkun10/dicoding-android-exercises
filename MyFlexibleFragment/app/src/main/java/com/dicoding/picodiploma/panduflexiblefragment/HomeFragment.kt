package com.dicoding.picodiploma.panduflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), View.OnClickListener {
    /* Layout interface didefinisikan dan ditransformasikan dari layout
    berupa file xml ke dalam objek view dengan menggunakan metode inflate(). */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

        /* Inflater.inflate() merupakan objek dari LayoutInflater yg
           berfungsi untuk mengubah layout xml ke dalam bentuk objek viewgroup
           atau widget melalui pemanggilan metode inflate().
           Sama seperti setContentView() pada Activity, fungsi inflate di sini
           untuk menampilkan layout dari Fragment, di mana layout yang ditampilkan
           di sini yaitu fragment_home.*/
    }

    /* Metode onViewCreated() bekerja setelah onCreateView().
       Disini bisa digunakan untuk inisialisasi view, dan jg
       mengatur 'action'-nya (set listener). */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory: Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)

        /* Perlu diperhatikan untuk pemanggilan findViewById() di sini tidak dapat
           langsung dilakukan seperti di Activity. Anda perlu menambahkan variabel view
           terlebih dulu di depannya sehingga menjadi view.findViewById().
           Kode tersebut menandakan btn_category berada pada objek view di mana objek view
           berasal dari konversi fragment_home.xml. Bila hanya findViewById(R.id.btn_category),
           maka btn_category berada pada root layout, activity_main.xml.*/
    }

    override fun onClick(v: View) {
        // Untuk latihan berikutnya
    } 

}
