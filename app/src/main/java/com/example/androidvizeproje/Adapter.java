package com.example.androidvizeproje;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<MyViewHolder> {

    public EtkilenenUlkeDetayModel[] arr;

    public Adapter(EtkilenenUlkeDetayModel[] arr) {

        this.arr = arr;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view  = inflater.inflate(R.layout.recycler_item, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tvCountry_name.setText(arr[position].detayBilgi.cases + " " + arr[position].detayBilgi.country_name + " " +
                arr[position].detayBilgi.deaths);


    }

    @Override
    public int getItemCount() {
        return arr.length;
    }
}
