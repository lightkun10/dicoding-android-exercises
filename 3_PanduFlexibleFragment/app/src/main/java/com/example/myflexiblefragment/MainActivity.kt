package com.example.myflexiblefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* 'Plant' HomeFragment inside of its activity
        so that it appear in user's display. 
        
        On MainActivity, I do the process of installing or pasting
        the HomeFragment object so that it can be displayed on screen */

        val mFragmentManager = supportFragmentManager
        /* FragmentTransaction is a function to perform
        an operations on fragments such as add(), replace(),
        commit() etc.
        https://developer.android.com/reference/android/app/FragmentManager.html
        */

        val mHomeFragment = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        /* This is where the process of adding fragments to activity occurs. */
        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name: " + HomeFragment::class.java.simpleName)

            mFragmentManager
                .beginTransaction() // begin the change process
                .add(R.id.frame_container, mHomeFragment, HomeFragment::class.java.simpleName)
                // add will add fragment object to container layout.
                .commit() // executed to do the object installation asynchronously
                          // that will be displayed to user interface. 
        }

        /* I use an instance from FragmentManager which is an interface
        to organize the fragment objects contained in an activity. */
    }
}