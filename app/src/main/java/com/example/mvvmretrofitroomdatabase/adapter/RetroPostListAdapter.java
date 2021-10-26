package com.example.mvvmretrofitroomdatabase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmretrofitroomdatabase.R;
import com.example.mvvmretrofitroomdatabase.databinding.ItemViewBinding;
import com.example.mvvmretrofitroomdatabase.models.ResultModel;

import java.util.List;

public class RetroPostListAdapter extends RecyclerView.Adapter<RetroPostListAdapter.PostViewHolder> {

    private Context context;
    private List<ResultModel> posts;

    public RetroPostListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        ItemViewBinding binding  = ItemViewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
//        return new PostViewHolder(binding);
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_view,parent,false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        if (posts != null){
            ResultModel resultModel = posts.get(position);
            holder.id.setText(""+resultModel.getId());
            holder.title.setText(resultModel.getTitle());
            holder.body.setText(resultModel.getBody());
        }
    }

    public void setWords(List<ResultModel> users){
        posts = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (posts != null){
            return posts.size();
        }else
        return 0;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        TextView id,title,body;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.txtId);
            title = itemView.findViewById(R.id.txtTitile);
            body = itemView.findViewById(R.id.txtBody);
        }

//        private ItemViewBinding binding;
//        public PostViewHolder(@NonNull ItemViewBinding  binding) {
//            super(binding.getRoot());
//
//            this.binding = binding;


    }
}
