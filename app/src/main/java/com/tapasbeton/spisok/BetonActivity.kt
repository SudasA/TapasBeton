package com.tapasbeton.spisok

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tapasbeton.R
import com.tapasbeton.main.FragmentActivity
import kotlinx.android.synthetic.main.activity_beton.*

class BetonActivity:AppCompatActivity() {

    //инициализируем ViewModel ленивым способом
    private val BetonViewModel by lazy { ViewModelProvider(this).get(BetonViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beton)

        //инициализируем адаптер и присваиваем его списку
        val adapter = BetonAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        //подписываем адаптер на изменения списка
        BetonViewModel.betonList.observe(this, Observer {
            it?.let {
                adapter.betons = it
            }
        })

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