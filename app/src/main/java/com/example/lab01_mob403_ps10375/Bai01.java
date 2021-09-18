package com.example.lab01_mob403_ps10375;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Bai01 extends AppCompatActivity {

    private TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai01);

        tvTime = findViewById(R.id.tvTime);
        ClockAsync clockAsync = new ClockAsync(tvTime);
        clockAsync.execute();

    }
}