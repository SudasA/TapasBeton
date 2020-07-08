package com.tapasbeton.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tapasbeton.R


class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragment = MainFragment()

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()



    }
}