package com.tapasbeton.spisok

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tapasbeton.R
import kotlinx.android.synthetic.main.layout_item.view.*
import java.util.*

class BetonAdapter: RecyclerView.Adapter<BetonAdapter.BetonHolder>() {

    private var betons: List<Beton> = ArrayList()

    //создает ViewHolder и инициализирует views для списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BetonHolder {
        return BetonHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_item, parent, false)
        )
    }

    //связывает views с содержимым
    override fun onBindViewHolder(viewHolder: BetonHolder, position: Int) {
        viewHolder.bind(betons[position])
    }

    override fun getItemCount() = betons.size

    //передаем данные и оповещаем адаптер о необходимости обновления списка
    fun refreshUsers(betons: List<Beton>) {
        this.betons = betons
        notifyDataSetChanged()
    }


    //описывает элементы представления списка и привязку их к RecyclerView
    class BetonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(beton: Beton) = with(itemView) {
            marka.text = beton.marka
            classi.text = beton.classi
            zapoln.text = beton.zapoln
            podvign.text = beton.podvign
            frozen.text = beton.frozen
            water.text = beton.water
        }
    }
}