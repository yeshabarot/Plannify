package com.example.navigationdrawer;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class rateus extends AppCompatActivity {
    RatingBar rtngBar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rateus);
        rtngBar1=findViewById(R.id.rtngBar1);
        rtngBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Float rtng=rtngBar1.getRating();

                Toast.makeText(getApplicationContext(),"Your Rating :"+rtng,Toast.LENGTH_SHORT).show();
            }
        });
    }
}