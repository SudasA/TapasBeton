package com.tapasbeton.spisok

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BetonViewModel: ViewModel() {

    var betonList : MutableLiveData<List<Beton>> = MutableLiveData()

    //инициализируем список и заполняем его данными
    init {
       betonList.value = BetonData.getBetons()
    }

}