package com.example.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {
    private static final int SPLASH_TIME_OUT = 2000;
    private long delay = SPLASH_TIME_OUT;
    private long startTime;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            delay = savedInstanceState.getLong("delay");
            if (delay < 0)
                delay = 0;
        }
        startTime = System.currentTimeMillis();
        setContentView(R.layout.splash);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("delay", delay - (System.currentTimeMillis() - startTime));
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(SplashScreen.this, HomeActivity.class);
                startActivity(in);
                finish();
            }
        };
        handler.postDelayed(runnable, delay);

    }
}
