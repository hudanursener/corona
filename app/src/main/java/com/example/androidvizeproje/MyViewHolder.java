package com.example.androidvizeproje;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {


    public TextView tvCountry_name;
    public TextView tvCases;
    public TextView tvDeaths;
    public TextView tvRegion;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        tvCountry_name = itemView.findViewById(R.id.tvCountry_name);
        tvCases = itemView.findViewById(R.id.tvCases);
        tvDeaths = itemView.findViewById(R.id.tvDeaths);
        tvRegion = itemView.findViewById(R.id.tvRegion);
    }
}
