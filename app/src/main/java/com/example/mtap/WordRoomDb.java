package com.example.mtap;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;



@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDb extends RoomDatabase {
    public abstract WordDao wordDao();
    public static WordRoomDb INSTANCE;
    static WordRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDb.class) {
                if (INSTANCE == null)    {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            WordRoomDb.class, "word_database")
                            // .addCallback(sOnOpenCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }}}
        return INSTANCE;
    }


}
