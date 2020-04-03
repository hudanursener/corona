package com.example.androidvizeproje;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

class ResimGoster extends AsyncTask<String, Void, Bitmap> {

    ImageView imageView;

    public ResimGoster(ImageView imageView) {
        this.imageView = imageView;
    }


    protected Bitmap doInBackground(String... UrlAdres) {
        String url = UrlAdres[0];
        Bitmap foto = null;
        try {
            InputStream inputStream = new java.net.URL(url).openStream();
            foto = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {
            Log.e("hata", e.getMessage());
            e.printStackTrace();
        }
        return foto;
    }

    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }
}

