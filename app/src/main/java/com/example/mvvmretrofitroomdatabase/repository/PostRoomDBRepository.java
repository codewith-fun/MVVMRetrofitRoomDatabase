package com.example.mvvmretrofitroomdatabase.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mvvmretrofitroomdatabase.models.ResultModel;

import java.util.List;

public class PostRoomDBRepository {
    private PostInfoDao postInfoDao;
    private LiveData<List<ResultModel>> mAllPosts;

    public PostRoomDBRepository(Application application){
        PostIntoRoomDatabase database = PostIntoRoomDatabase.getDatabase(application);
        postInfoDao = database.postInfoDao();
        mAllPosts = postInfoDao.getAllPosts();
    }

    public LiveData<List<ResultModel>> getAllPosts(){
        return mAllPosts;
    }

    public void insert(List<ResultModel> resultModels){
        new InsertAsyncTask(postInfoDao).execute(resultModels);
    }

    private static class InsertAsyncTask extends AsyncTask<List<ResultModel>,Void,Void> {

        private PostInfoDao mAsynTaskDao;

        public InsertAsyncTask(PostInfoDao postInfoDao) {
            mAsynTaskDao = postInfoDao;
        }

        @Override
        protected Void doInBackground(final List<ResultModel>... lists) {
            mAsynTaskDao.insertPosts(lists[0]);
            return null;
        }
    }
}
