package com.tapasbeton.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.tapasbeton.R


class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)


        if (savedInstanceState == null) {

            val fragment = MainFragment()

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.backup -> startActivity(Intent(this, FragmentActivity::class.java))
                //Toast.makeText(this, "Backup clicked", Toast.LENGTH_SHORT).show()
            else -> {

            }

        }
        return super.onOptionsItemSelected(item)
    }
}