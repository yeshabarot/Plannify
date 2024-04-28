package com.example.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {
    private static int SPLASH_SCREEN = 4000;

    //Variables for Animations
    Animation topAnim;

    ImageView image;
    //TextView logo,slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //Animations
        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        //bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //Hooks
        image=findViewById(R.id.imageView);
        //logo=findViewById(R.id.textView);
        //slogan=findViewById(R.id.textView2);

        image.setAnimation(topAnim);
        //logo.setAnimation(bottomAnim);
        //slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash.this, CoverPage.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}