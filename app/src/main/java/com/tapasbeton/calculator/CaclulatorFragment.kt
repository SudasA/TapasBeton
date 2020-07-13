package com.tapasbeton.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tapasbeton.R
import kotlinx.android.synthetic.main.fragment_calculator.*


class CaclulatorFragment:Fragment() {



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

            val a = editText1.text.toString()
            val b = editText2.text.toString()
            val c = editText3.text.toString()

            var result = 0.0;

            if (!(a.isEmpty())&&!(b.isEmpty())&&!(c.isEmpty())) {
                        result = a.toDouble() * b.toDouble() * c.toDouble()
            }

            summText.text = ("$result м3")



        }

    }


}

