package com.example.androidvizeproje;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public abstract class TemelRequest extends AsyncTask<Void,Void,Void> {

    String result  = "";
    public  abstract  String getReqUrl();

    @Override
    protected Void doInBackground(Void... voids) {


        try {
            URL url = new URL (getReqUrl());

            HttpURLConnection connection =(HttpsURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();

            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bfReader = new BufferedReader(reader);

            String res = "";
            while ((res = bfReader.readLine()) != null){
                result += res;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.d("hataRq:",result);
        return null;
    }
}
