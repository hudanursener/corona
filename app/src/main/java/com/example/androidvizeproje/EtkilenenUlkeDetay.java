package com.example.androidvizeproje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;

public class EtkilenenUlkeDetay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etkilenen_ulke_detay);

        Bundle bundle = getIntent().getExtras();
        String result = bundle.getString("data");

        Gson gson = new Gson();

        EtkilenenUlkeDetayModel[] arr = gson.fromJson(result, EtkilenenUlkeDetayModel[].class);

        Adapter adapter = new Adapter(arr);

        RecyclerView recyclerView = findViewById(R.id.recView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerView.setAdapter(adapter);


    }



}
