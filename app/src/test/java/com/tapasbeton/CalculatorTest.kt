package com.tapasbeton

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tapasbeton.calculator.CalculatorViewModel
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class CalculatorTest {

    private lateinit var viewModel: CalculatorViewModel

    var calculator = CalculatorViewModel()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun test_setup () {

        viewModel = CalculatorViewModel()

        val result = 8.0

        viewModel.count(2.0,2.0,2.0)


        viewModel.result.observeForever{
            assertEquals(result,  it)
        }



    }




}