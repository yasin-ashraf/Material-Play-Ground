package com.yasin.materialplayground.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yasin.materialplayground.R;

/**
 * Created by im_yasinashraf started on 25/3/19.
 */
public class MenuAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}

    class ItemViewHolder extends RecyclerView.ViewHolder {

    ItemViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
