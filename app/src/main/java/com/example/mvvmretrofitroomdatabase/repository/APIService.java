package com.example.mvvmretrofitroomdatabase.repository;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("posts")
    Call<String> getAllData();
}
