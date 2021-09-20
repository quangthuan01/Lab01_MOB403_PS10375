package com.example.lab01_mob403_ps10375;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Load_Image extends AppCompatActivity {

    ImageView imageView;
    Button btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);

        imageView = findViewById(R.id.imageView);
        btnLoad = findViewById(R.id.btn_load_image);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cach 1
                LoadImageInternet loadImageInternet = new LoadImageInternet();
                loadImageInternet.execute("https://funix.edu.vn/wp-content/uploads/2021/08/UI-va-UX.jpg");
                //cach 2
                // new LoadImageInternet().execute();
            }
        });

    }

    private class LoadImageInternet extends AsyncTask<String, Void, Bitmap> {
        Bitmap bitmapHinh = null;

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                // lay url string phan tu thu 0
                URL url = new URL(strings[0]);
                //lay anh ve
                InputStream inputStream = url.openConnection().getInputStream();
                //chuyen ve bitmap
                bitmapHinh = BitmapFactory.decodeStream(inputStream);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmapHinh;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            imageView.setImageBitmap(bitmap);

        }
    }

}