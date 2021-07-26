package com.example.mtap;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {

    @PrimaryKey(autoGenerate = true)
    int uid;
    @ColumnInfo
    String word;

    public Word(String word) {
        this.word = word;
    }
    public String toString(){
        return word;
    }
}
