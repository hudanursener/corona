package com.example.androidvizeproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DetayUlke extends AppCompatActivity implements DetayRequest.RequestListener {

    TextView ulkeAdi;
    TextView vakaSayisi;
    TextView olumSayisi;
    TextView toplamIyilesen;
    TextView yeniOlumler;
    TextView yeniVakalar;
    TextView kritikVaka;
    TextView aktifVakalar;
    TextView birMVaka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulke_detay_ulke);

        ulkeAdi =findViewById(R.id.ulkeAdi);
        vakaSayisi =findViewById(R.id.vakaSayisi);
        olumSayisi =findViewById(R.id.olumSayisi);
        toplamIyilesen =findViewById(R.id.toplamIyilesen);
        yeniOlumler =findViewById(R.id.yeniOlumler);
        yeniVakalar =findViewById(R.id.yeniVakalar);
        kritikVaka = findViewById(R.id.kritikVaka);
        aktifVakalar =findViewById(R.id.aktifVakalar);
        birMVaka =findViewById(R.id.birMVaka);


        DetayRequest request = new DetayRequest(this);
        request.execute();
    }

    @Override
    public void RequesDone(String result) {

        Gson gson = new Gson();
        UlkleDetayModel model = gson.fromJson(result, UlkleDetayModel.class);

        Bundle bundle = getIntent().getExtras();
        String son = bundle.getString("ulkeAdi");

        for (int i = 0 ; i<model.countries_stat.length ; i++){
            if (model.countries_stat[i].country_name.equals(son)){
                ulkeAdi.setText(""+model.countries_stat[i].country_name);
                olumSayisi.setText(""+model.countries_stat[i].deaths);
                kritikVaka.setText(""+model.countries_stat[i].serious_critical);
                toplamIyilesen.setText(""+model.countries_stat[i].total_recovered);
                yeniOlumler.setText(""+model.countries_stat[i].new_deaths);
                yeniVakalar.setText(""+model.countries_stat[i].new_cases);
                vakaSayisi.setText(""+model.countries_stat[i].cases);
                birMVaka.setText(""+model.countries_stat[i].total_cases_per_1m_population);
                aktifVakalar.setText(""+model.countries_stat[i].active_cases);
            }
        }
    }
}
