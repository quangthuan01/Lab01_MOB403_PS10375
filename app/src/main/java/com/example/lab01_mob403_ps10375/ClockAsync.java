package com.example.lab01_mob403_ps10375;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class ClockAsync  extends AsyncTask<Void, String , String > {

    TextView tv;
    public ClockAsync(TextView tv){
        this.tv = tv;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String myTime = "00:00:00";
        for(int i=0; true; i++){
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            myTime = sdf.format(sdf.getCalendar().getTime());
            Log.i("time: ", myTime);
            publishProgress(myTime);
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void onPostExecute(String unused) {
        super.onPostExecute(unused);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        tv.setText(values[0]);
    }
}
