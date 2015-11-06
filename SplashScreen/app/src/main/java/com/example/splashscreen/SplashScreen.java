package com.example.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {
    private static final int SPLASH_TIME_OUT = 2000;
    private Handler handler;
    private Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(SplashScreen.this, HomeActivity.class);
                startActivity(in);
                finish();
            }
        };
        handler.postDelayed(runnable, SPLASH_TIME_OUT);
}
    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        handler.removeCallbacks(runnable);
    }
}
