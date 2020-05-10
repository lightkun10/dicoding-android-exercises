package com.example.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    /* method onCreateView is where layout interface 
       defined and transformed from layout in the form of xml file
       to view object with inflate() method. */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

        /* Inflater.inflate() is an object from LayoutInflater
        that can be use to change xml layout into viewgroup object
        or widget through inflate() method calls. 
        Same as setContentView in Activity, inflate functions here is to
        display layout from Fragment, where layout that being displayed
        here is fragment_home. */
    }

    /* onViewCreated() work after onCreateView(). Here I use it for
    view initialization, and to control its action (set listener). */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCategory: Button = view.findViewById(R.id.btn_category)

        /* A bit different from the process of casting view from 
        an ID inside layout xml, here casting the button object done with
        view.findViewById(R.id.btn_category). Code above indicate that
        btn_category is on view object where the view object comes from the 
        fragment_home.xml conversion. If (the code) is only 
        findViewById(R.id.btn_category), then btn_category is 
        inside the root layout, activity_main.xml. */

        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_category) {
            val mCategoryFragment = CategoryFragment()
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, mCategoryFragment, CategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}