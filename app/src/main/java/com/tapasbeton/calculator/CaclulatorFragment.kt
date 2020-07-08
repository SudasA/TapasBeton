package com.tapasbeton.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tapasbeton.R
import kotlinx.android.synthetic.main.fragment_calculator.*
import org.koin.androidx.viewmodel.ext.android.viewModel



class CaclulatorFragment:Fragment() {

  val mViewModel : CalculatorViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calculator, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        summ.setOnClickListener(){

            var a = editText1.text.toString()
            var b = editText2.text.toString()
            var c = editText3.text.toString()

            var result = a?.toDouble()*b?.toDouble()*c?.toDouble()

            summText.text = result.toString() + " м3"



        }


    }


    }

