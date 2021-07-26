package com.example.mtap;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface WordDao  {
    @Insert
    void insert(Word word);
    @Update
    public void updateWords(Word... words);
    @Query("DELETE FROM Word")
    void deleteAll();
    @Query("SELECT * from Word ORDER BY word ASC")
    List<Word> getAllWords();
    @Query("SELECT * FROM Word WHERE word LIKE :word ")
    public List<Word> findWord(String word);

}
