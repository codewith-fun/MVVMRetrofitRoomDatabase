package com.example.mvvmretrofitroomdatabase.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmretrofitroomdatabase.models.ResultModel;
import com.example.mvvmretrofitroomdatabase.repository.PostRoomDBRepository;
import com.example.mvvmretrofitroomdatabase.repository.WebServiceRepository;

import java.util.List;

public class PostListViewModel extends AndroidViewModel {

    private PostRoomDBRepository  postRoomDBRepository;
    private LiveData<List<ResultModel>> mAllPosts;
    WebServiceRepository  webServiceRepository;

    private final  LiveData<List<ResultModel>> retrObserval;

    public PostListViewModel(@NonNull Application application) {
        super(application);

        postRoomDBRepository = new PostRoomDBRepository(application);
        webServiceRepository = new WebServiceRepository(application);
        retrObserval = webServiceRepository.provideWebService();
        mAllPosts = postRoomDBRepository.getAllPosts();
    }

    public LiveData<List<ResultModel>> getAllPosts(){
        return mAllPosts;
    }
}
