package com.tapasbeton

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tapasbeton.firebase.StorageViewModel
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test

class StorageTest {
    private lateinit var viewModel: StorageViewModel

    val storage = StorageViewModel()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun test_setup () {

        viewModel = StorageViewModel()

        val result = "DDGg"

        viewModel.maketxt("DDGg")


        viewModel.datas.observeForever{
            Assert.assertEquals(result, it)
        }



    }

}