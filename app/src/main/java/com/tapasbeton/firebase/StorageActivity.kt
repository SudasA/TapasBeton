package com.tapasbeton.firebase

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tapasbeton.R
import kotlinx.android.synthetic.main.activity_storage.*

class StorageActivity: AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_storage)


            val datamodel = ViewModelProvider(this).get(StorageViewModel::class.java)

            val firestore = Firebase.firestore


            datamodel.datas.observe(this, Observer {
                textView2.text = it
            })

            button.setOnClickListener {
                val comment = editText.text?.toString()
                if (comment.isNullOrBlank()) {
                    return@setOnClickListener
                }

                firestore.collection("feedback")
                    .add(
                        hashMapOf(
                            "comment" to comment
                        )
                    )
                    .addOnSuccessListener {
                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
                    }
            }

            button2.setOnClickListener {

                firestore.collection("feedback")
                    .get()
                    .addOnSuccessListener { result ->
                        val builder = StringBuilder()
                        for (document in result) {
                            Log.d("h", "${document.id} => ${document.data}")
                            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                            builder.append(document.data.get("comment"))
                            builder.append(System.getProperty("line.separator"));
                            textView2.text = builder.toString()

                            // observe
                            datamodel.maketxt(builder.toString())
                        }
                    }
                    .addOnFailureListener { exception ->
                        Log.d("erroe", "get failed with ", exception)
                        Toast.makeText(this, "Failure", Toast.LENGTH_SHORT).show()
                    }

            }



        }
    }



