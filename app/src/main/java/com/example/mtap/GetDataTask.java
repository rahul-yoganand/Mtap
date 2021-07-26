package com.example.mtap;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class GetDataTask extends AsyncTask<Void, Void, List<Word>>{

    ListView mListView;
    WordDao mWordDao;
    Context mContext;

    public GetDataTask(Context context, ListView mListView, WordDao mWordDao) {
        mContext = context;
        this.mListView = mListView;
        this.mWordDao = mWordDao;
    }

    @Override
    protected List<Word> doInBackground(Void... voids) {
        return mWordDao.getAllWords();
    }
    @Override
    protected void onPostExecute(List<Word> words) {
        super.onPostExecute(words);
        ArrayAdapter<String> adapter =
                new ArrayAdapter(mContext, android.R.layout.simple_list_item_1,words);
        mListView.setAdapter(adapter);
    }
}
