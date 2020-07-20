package com.tapasbeton.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel(): ViewModel() {

    var result = MutableLiveData<Double>()


    fun count (a: Double, b: Double, c:Double ){


        val res = a * b * c
        result.postValue(res)

    }




}