package com.example.mtap;

import android.os.AsyncTask;

public class DeleteTask  extends AsyncTask<Void, Void, Void> {
    WordDao mwordDao;

    public DeleteTask(WordDao mwordDao) {
        this.mwordDao=mwordDao;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        mwordDao.deleteAll();
        return null;
    }
}
