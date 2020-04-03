package com.example.androidvizeproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ResimGoster((ImageView) findViewById(R.id.imageView))
                .execute("https://coronavirus-monitor.p.rapidapi.com/coronavirus/random_masks_usage_instructions.php?rapidapi-key=577e1f28d2msh8b2bf1fed9ebd7ep1df55fjsn5b55f896a62a");



        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                new ResimGoster((ImageView) findViewById(R.id.imageView))
                        .execute("https://coronavirus-monitor.p.rapidapi.com/coronavirus/random_masks_usage_instructions.php?rapidapi-key=577e1f28d2msh8b2bf1fed9ebd7ep1df55fjsn5b55f896a62a");


                Intent intent = new Intent(MainActivity.this,DunyaRapor.class);
                startActivity(intent);
            }
        },9000);






    }
}
