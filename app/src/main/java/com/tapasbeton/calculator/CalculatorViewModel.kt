package com.tapasbeton.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel(): ViewModel() {

    var result = MutableLiveData<Double>()

    val text1 = MutableLiveData<String>()

    fun maketxt1 (txt1: String  ){

       text1.postValue(txt1)

    }


    fun count (a: Double, b: Double, c:Double ) {

        val res = a * b * c
      result.postValue(res)




    }




}