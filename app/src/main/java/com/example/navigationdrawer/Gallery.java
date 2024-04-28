package com.example.navigationdrawer;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Gallery extends AppCompatActivity {



    ImageView img1,img2,img3;

    TextView txt1,txt2,txt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        img1=findViewById(R.id.img1);
        String imageResourceID1 = getIntent().getStringExtra("image_url1");
        Uri myUri1 = Uri.parse(imageResourceID1);
        img1.setImageURI(myUri1);

        img2=findViewById(R.id.img2);
        String imageResourceID2 = getIntent().getStringExtra("image_url2");
        Uri myUri2 = Uri.parse(imageResourceID2);
        img2.setImageURI(myUri2);

        img3=findViewById(R.id.img3);
        String imageResourceID3 = getIntent().getStringExtra("image_url3");
        Uri myUri3 = Uri.parse(imageResourceID3);
        img3.setImageURI(myUri3);

        txt1=findViewById(R.id.text1);
        txt1.setText(getIntent().getStringExtra("message1"));

        txt2=findViewById(R.id.text2);
        txt2.setText(getIntent().getStringExtra("message2"));

        txt3=findViewById(R.id.text3);
        txt3.setText(getIntent().getStringExtra("message3"));

    }
}