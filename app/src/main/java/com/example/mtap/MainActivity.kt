package com.example.mtap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

lateinit var  roomDb: WordRoomDb
lateinit var wordDao: WordDao
lateinit var etOne :EditText
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        roomDb = WordRoomDb.getDatabase(this)
        wordDao = roomDb.wordDao()
        etOne=findViewById(R.id.etOne)
    }
    fun dbHandler(view: View) {

        insertWordAsynchronously()
        // wordDao.insert()
    }

    private fun insertWordAsynchronously() {

        var data = etOne.text.toString()
        var word = Word(data)
        var insertTask = InsertTask(wordDao,word)
        insertTask.execute()


    }
}