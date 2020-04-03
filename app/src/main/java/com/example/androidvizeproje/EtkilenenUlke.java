package com.example.androidvizeproje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class EtkilenenUlke extends AppCompatActivity implements EtkilenenUlkeReq.EtkUlkeReqListener {

    ArrayList<String> arr = new ArrayList<String>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etkilenen_ulke);

        listView =findViewById(R.id.listView);

        EtkilenenUlkeReq request = new EtkilenenUlkeReq(this);
        request.execute();


    }



    @Override
    public void onRequestDone(final String result) {


        Gson gson = new Gson();
        final EtkilenenUlkeModel model = gson.fromJson(result,EtkilenenUlkeModel.class);


        final List<String> values = new ArrayList<>();

        for (int i =0; i< model.affected_countries.length ;i++){
            values.add(model.affected_countries[i]);

        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, values);

        listView.setAdapter(arrayAdapter);





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)  {

                Intent intent = new Intent(EtkilenenUlke.this,DetayGecis.class);

                startActivity(intent);
            }
        });

    }

}
