package com.example.androidvizeproje;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.opengl.ETC1;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class DunyaRapor extends AppCompatActivity implements Request.ReqListener{

    TextView total_cases;
    TextView total_deaths;
    TextView total_recovered;
    TextView new_cases;
    TextView new_deaths;
    TextView statistic_taken_at;
    Button etkUlkeButon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dunya_rapor);

        total_cases =findViewById(R.id.total_cases);
        total_deaths =findViewById(R.id.total_deaths);
        total_recovered =findViewById(R.id.total_recovered);
        new_cases =findViewById(R.id.new_cases);
        new_deaths =findViewById(R.id.new_deaths);
        statistic_taken_at =findViewById(R.id.statistic_taken_at);
        etkUlkeButon = findViewById(R.id.EtkilenenUlkeButon);

        Request request = new Request(this);
        request.execute();

        etkUlkeButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(DunyaRapor.this, EtkilenenUlke.class);
               startActivity(intent);
            }
        });
    }

    @Override
    public void ReqDone(String result){
    Gson gson = new Gson();
    DunyaRaporModel model = gson.fromJson(result,DunyaRaporModel.class);

    total_cases.setText(model.total_cases);
    total_deaths.setText(model.total_deaths);
    total_recovered.setText(model.total_recovered);
    new_cases.setText(model.new_cases);
    new_deaths.setText(model.new_deaths);
    statistic_taken_at.setText(model.statistic_taken_at);
    }
}
