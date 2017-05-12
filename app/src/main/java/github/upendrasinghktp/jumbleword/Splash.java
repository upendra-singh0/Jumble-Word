package github.upendrasinghktp.jumbleword;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Upendra on 5/8/2017.
 */

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefs = getSharedPreferences("userId", 0);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(Splash.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

   /* private void fun()
    {
        if(prefs.getInt("userId", 0) != 0){
        }else {
            Intent i = new Intent(Splash.this, DetailActivity.class);
            startActivity(i);
        }
    }*/
}

