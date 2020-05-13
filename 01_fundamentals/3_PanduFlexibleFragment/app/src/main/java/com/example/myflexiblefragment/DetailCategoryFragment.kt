package com.example.myflexiblefragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_detail_category.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailCategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailCategoryFragment : Fragment(), View.OnClickListener {
    var description: String? = null

    companion object {
        var EXTRA_NAME = "extra_name"
        var EXTRA_DESCRIPTION = "extra_description"
    }

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var tvCategoryName: TextView
    lateinit var tvCategoryDescription: TextView
    lateinit var btnProfile: Button
    lateinit var btnShowDialog: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvCategoryName = view.findViewById(R.id.tv_category_name)
        tvCategoryDescription = view.findViewById(R.id.tv_category_description)
        
        btnProfile = view.findViewById(R.id.btn_profile)
        btnProfile.setOnClickListener(this)

        btnShowDialog = view.findViewById(R.id.btn_show_dialog)
        btnShowDialog.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            val descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION)
            description = descFromBundle
        }

        if (arguments != null) {
            /* Mengambil data yang dikirimkan melalui obyek bundle pada fragment tujuan. */
            val categoryName = arguments?.getString(EXTRA_NAME)
            tv_category_name.text = categoryName
            tv_category_description.text = description
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_profile -> {
                val mIntent = Intent(activity, ProfileActivity::class.java)
                startActivity(mIntent)
            }

            R.id.btn_show_dialog -> {
                val mOptionDialogFragment = OptionDialogFragment()

                val mFragmentManager = childFragmentManager
                /* getFragmentManager() digunakan dan bukan getChildFragmentManager().
                   Hal ini merupakan pilihan yang tepat untuk kondisi saat ini,
                   yakni sebuah nested fragment / fragment bersarang.
                   Karena OptionDialogFragment dipanggil di dalam sebuah obyek fragment yang
                   telah ada sebelumnya yaitu DetailDialogFragment,
                   maka demi performa lebih baik gunakanlah getChildFragmentManager() sebagai
                   pilihan yang lebih tepat. */

                mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment::class.java.simpleName)
                /*
                Baris di atas digunakan untuk menampilkan obyek OptionDialogFragment ke layar.
                Untuk proses handling event ketika tombol Pilih pada OptionDialogFragment diklik,
                kita menggunakan implementasi interface.
                Mengenai interface:
                https://docs.oracle.com/javase/tutorial/java/concepts/interface.html
                */
            }
        }
    }

    // Implementasi interface
    internal var optionDialogListener: OptionDialogFragment.OnOptionDialogListener = object : OptionDialogFragment.OnOptionDialogListener {
        override fun onOptionChosen(text: String?) {
            /* Metode onOptionChosen() pada baris ini akan dipanggil
               untuk menampilkan nilai dari pilihan yang dipilih pada toast. */
            Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
        }
    }
}