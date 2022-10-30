package com.artix.pichart_lib.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.artix.pichart_lib.PiData;
import com.artix.pichart_lib.R;

import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    List<PiData> piData = new ArrayList<>();

    public ItemAdapter(List<PiData> piData) {
        this.piData = piData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PiData item  = piData.get(position);
        holder.view.setBackgroundColor(item.getColor());
        holder.textView.setText(item.getTitle());

    }

    @Override
    public int getItemCount() {
        return piData==null  ? 0: piData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
            View view;
            TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            view  = itemView.findViewById(R.id.view);
            textView  = itemView.findViewById(R.id.textView);
        }
    }
}
