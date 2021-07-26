package com.example.mtap

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

lateinit var name: EditText
class LoginActivity : AppCompatActivity() {
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
        var data = name.text.toString()
        var sharedPreferences= getSharedPreferences("backup", MODE_PRIVATE)
        var editor=sharedPreferences.edit()
        editor.putString("personName",data)
        editor.apply()

    }
    private fun restoreData(){
        var sharedPreferences = getSharedPreferences("backup", MODE_PRIVATE)
        //get data from file
        var data  = sharedPreferences.getString("personName","")
        //set the data into edittext
        name.setText(data)


    }
}