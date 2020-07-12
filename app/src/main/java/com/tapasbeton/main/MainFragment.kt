package com.tapasbeton.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tapasbeton.R
import com.tapasbeton.calculator.CaclulatorFragment
import com.tapasbeton.contacts.ContactsFragment
import com.tapasbeton.firebase.StorageActivity
import com.tapasbeton.maps.MapsFragment
import com.tapasbeton.spisok.BetonActivity
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contacts.setOnClickListener()
        {
            val b = activity
            if (b != null) {
                b.supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.fragment_container,
                        ContactsFragment()
                    )
                    .addToBackStack(MainFragment::class.java.name)
                    .commit()
            }
        }

        logo.setOnClickListener() {
            val intent = Intent (Intent.ACTION_VIEW, Uri.parse("https://www.tapas.by/"))
            startActivity(intent)
        }

        spisok.setOnClickListener(){
            val intent = Intent (getActivity(), BetonActivity::class.java)
            getActivity()?.startActivity(intent)
        }


        beton.setOnClickListener(){
            val intent = Intent (getActivity(), StorageActivity::class.java)
            getActivity()?.startActivity(intent)
        }

        calculator.setOnClickListener(){

            val b = activity
            if (b != null) {
                b.supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.fragment_container,
                        CaclulatorFragment()
                    )
                    .addToBackStack(MainFragment::class.java.name)
                    .commit()
            }
        }



        maps.setOnClickListener()
        {
            val b = activity
            if (b != null) {
                b.supportFragmentManager
                    .beginTransaction()
                    .replace(
                        R.id.fragment_container,
                        MapsFragment()
                    )
                    .addToBackStack(MainFragment::class.java.name)
                    .commit()
            }
        }
    }
}