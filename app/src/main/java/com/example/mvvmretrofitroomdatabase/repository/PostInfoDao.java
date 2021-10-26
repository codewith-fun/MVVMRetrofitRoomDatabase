package com.example.mvvmretrofitroomdatabase.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvvmretrofitroomdatabase.models.ResultModel;

import java.util.List;

@Dao
public interface PostInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ResultModel resultModel);

    @Query("SELECT * from post_info ORDER BY id ASC")
    LiveData<List<ResultModel>> getAllPosts();

    @Query("DELETE from post_info")
    void deleteAll();

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    void  insertPosts(List<ResultModel> resultModels);


}
