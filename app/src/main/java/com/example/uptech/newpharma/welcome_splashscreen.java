package com.example.uptech.newpharma;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class welcome_splashscreen extends AppCompatActivity {
    LinearLayout one,two;
    Animation uptodown , downtoup;

    private static int SPLASH_TIME = 4000; //This is 4 seconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_splashscreen);

        one=(LinearLayout) findViewById(R.id.welc_linear_1);
        two=(LinearLayout) findViewById(R.id.welc_linear_2);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        one.setAnimation(uptodown);

        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        two.setAnimation(downtoup);

        //Code to start timer and take action after the timer ends
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do any action here. Now we are moving to next page
                Intent mySuperIntent = new Intent(welcome_splashscreen.this,login_form.class);
                startActivity(mySuperIntent);
                /* This 'finish()' is for exiting the app when back button pressed
                *  from Home page which is ActivityHome
                */
                finish();
            }
        }, SPLASH_TIME);

    }
}
