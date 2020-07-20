package com.tapasbeton.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val model = ViewModelProvider(this).get(CalculatorViewModel::class.java)


        model.result.observe(viewLifecycleOwner, Observer {
            summText.text = ("$it m3")
        })


        summ.setOnClickListener(){

            val a = editText1.text.toString()
            val b = editText2.text.toString()
            val c = editText3.text.toString()

            if ((a == "0") || (b == "0") || (c == "0") ) {
                toast1.text = "Ввести другое значение"
            }

            if (a.isNotEmpty()&&b.isNotEmpty()&&c.isNotEmpty()) {

                if ((a == "0") || (b == "0") || (c == "0") ) {
                    toast1.text = "Число 0. Ввести другое"
                }
                else    {
                    model.count(a.toDouble(), b.toDouble(), c.toDouble())
                    toast1.text =""

                    }

            } else {

                toast1.text = "Пустое значение"
            }

            }

        }

    }







