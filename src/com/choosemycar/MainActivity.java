package com.choosemycar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {
    ImageView splashimage;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        splashimage = (ImageView)findViewById(R.id.splash);

    }
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                i=new Intent(getApplicationContext(),ActivityFilterCars.class);
                startActivity(i);
                finish();
            }
        }, 2000);

    }
    class MyThread extends Thread {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }


    }
}

