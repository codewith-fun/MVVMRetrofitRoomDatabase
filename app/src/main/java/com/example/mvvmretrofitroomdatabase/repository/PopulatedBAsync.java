package com.example.mvvmretrofitroomdatabase.repository;

import android.os.AsyncTask;

public class PopulatedBAsync extends AsyncTask<Void,Void,Void> {

    private final PostInfoDao  dao;
    PopulatedBAsync(PostIntoRoomDatabase db){
        dao = db.postInfoDao();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        dao.deleteAll();
        return null;
    }
}
