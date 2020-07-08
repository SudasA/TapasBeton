package com.tapasbeton.contacts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tapasbeton.R
import kotlinx.android.synthetic.main.fragment_contacts.*


class ContactsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callButton.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+375445498533", null))
            startActivity(intent)

        }

        emailButton.setOnClickListener {

            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:sajkarp@mail.ru")
            }
            startActivity(Intent.createChooser(emailIntent, "Send feedback"))

        }

        }


    }
