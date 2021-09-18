package com.example.lab01_mob403_ps10375;

import android.util.Log;

import java.text.SimpleDateFormat;

public class MyClock implements Runnable {
    @Override
    public void run() {
        for(int i=0; true; i++){
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            String myTime = sdf.format(sdf.getCalendar().getTime());
            Log.i("time: ", myTime);
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                Log.i("error",e+"");
            }
        }
    }
}
