package com.example.windows10.login3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class SplashActivity extends AppCompatActivity {
   Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         getSupportActionBar().hide();   //--------------------ActionBar atleke titleBar na show karavu hoy to?

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__splash);
        t=new Thread()
        {
            public void run()
            {
                try
                {
                    t.sleep(1500);
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
                catch(Exception e)
                {

                }
            }
        };
        t.start();
    }
}