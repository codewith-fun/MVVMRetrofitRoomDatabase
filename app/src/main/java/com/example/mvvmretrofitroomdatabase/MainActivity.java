package com.example.mvvmretrofitroomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.mvvmretrofitroomdatabase.adapter.RetroPostListAdapter;
import com.example.mvvmretrofitroomdatabase.viewmodel.PostListViewModel;

public class MainActivity extends AppCompatActivity {

    private PostListViewModel postListViewModel;
    ProgressDialog progressDialog;
    RetroPostListAdapter adapter = null;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postListViewModel = ViewModelProviders.of(MainActivity.this).get(PostListViewModel.class);

        initView();
        setAdapter();
        progressDialog = ProgressDialog.show(MainActivity.this,"Loading....","Please wait",true);
        postListViewModel.getAllPosts().observe(this,resultModels -> {
            adapter.setWords(resultModels);
            if (progressDialog !=null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
    }

    private void setAdapter(){
        adapter  = new RetroPostListAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}