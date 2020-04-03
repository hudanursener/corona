package com.example.androidvizeproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetayGecis extends AppCompatActivity implements DetayReq.DetayReqListener {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay_gecis);


        tv = findViewById(R.id.tv);

        DetayReq req = new DetayReq(this);
        req.execute();
    }

    @Override
    public void onRequestDone(String result) {
        tv.setText(result);
        Intent intent = new Intent(this,EtkilenenUlkeDetay.class);

        Bundle bundle = new Bundle();
        bundle.putString("data",result);
        intent.putExtras(bundle);

        startActivity(intent);


    }
}
