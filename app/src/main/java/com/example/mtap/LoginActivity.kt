package com.example.mtap

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    lateinit var name: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        name=findViewById(R.id.etUserName)

        
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        restoreData()
    }
    private fun saveData(){
        //get name from editText
        val data = name.text.toString()
        val sharedPreferences= getSharedPreferences("backup", MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        editor.putString("personName",data)
        editor.apply()

    }
    private fun restoreData(){
        val sharedPreferences = getSharedPreferences("backup", MODE_PRIVATE)
        //get data from file
        val data  = sharedPreferences.getString("personName","")
        //set the data into edittext
        name.setText(data)


    }
}