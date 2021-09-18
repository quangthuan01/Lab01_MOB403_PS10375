package com.example.lab01_mob403_ps10375;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity implements Runnable {

    TextView tvContent, tvTime;
    Thread thread;
    String myTime = "00:00:00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = findViewById(R.id.tvContent);
        tvTime = findViewById(R.id.tvTime);
        thread = new Thread(this);
        thread.start();
        tvContent.setText("Thuan__");

    }

    @Override
    public void run() {

        for(int i=0; thread.isAlive(); i++){
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            myTime = sdf.format(sdf.getCalendar().getTime());
            Log.i("time: ", myTime);
            tvTime.post(new Runnable() {
                @Override
                public void run() {
                    tvTime.setText(myTime);
                }
            });
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                Log.i("error",e+"");
            }
        }
    }
}