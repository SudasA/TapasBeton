package com.tapasbeton.firebase

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StorageViewModel: ViewModel() {

    var datas = MutableLiveData<String>()

    fun maketxt (txt: String  ){

        datas.postValue(txt)

    }



}