package com.tapasbeton.spisok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tapasbeton.R
import kotlinx.android.synthetic.main.activity_beton.*

class BetonActivity:AppCompatActivity() {

    //инициализируем ViewModel ленивым способом
    private val BetonViewModel by lazy { ViewModelProviders.of(this).get(BetonViewModel::class.java)}

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
}