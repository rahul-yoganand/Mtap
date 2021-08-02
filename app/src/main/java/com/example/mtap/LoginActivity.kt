package com.example.mtap

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore


class LoginActivity : AppCompatActivity() {
    lateinit var get: Button
    lateinit var name:EditText
    lateinit var author:TextView
    lateinit var title:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        get = findViewById(R.id.getData)
        name=findViewById(R.id.name)
        author=findViewById(R.id.author)
        title=findViewById(R.id.title)


    }

    fun searchBookApi(view: View) {
        var queryString= name.text.toString()
        FetchBook(title,author).execute(queryString)


    }

}