package com.tapasbeton.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {

    val result = MutableLiveData<String>()



    private fun calculate( a: Double,  b: Double , c: Double) : String {


     var result = a.toDouble() * b.toDouble() * c.toDouble()

     return result.toString()
 }

}