package com.example.navigationdrawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class addmemory extends AppCompatActivity {
    ImageButton btn1, btn2, btn3;
    Uri selectedImageUri1,selectedImageUri2,selectedImageUri3;
    ImageView img1,img2,img3;
    int SELECT_PICTURE = 200;
    int i=1;
    Button but1;

    EditText edt1,edt2;
    DatePicker dpt1;
    int year1,month,date;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmemory);

        btn1 = findViewById(R.id.but1);
        btn2 = findViewById(R.id.but2);
        btn3=findViewById(R.id.but3);
        img1 = findViewById(R.id.pic1);
        img2= findViewById(R.id.pic2);
        img3=findViewById(R.id.pic3);
        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        dpt1=findViewById(R.id.datePick1);
        but1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser1();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser2();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser3();
            }
        });
        dpt1.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date=dpt1.getDayOfMonth();
                month=(dpt1.getMonth())+1;
                year1=dpt1.getYear();
            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=edt1.getText().toString();
                String s2=edt2.getText().toString();
                //String s3=dpt1.getText().toString();
                Intent i = new Intent(addmemory.this, Gallery.class);

                i.putExtra("message1", s1);
                i.putExtra("message2", s2);
                i.putExtra("message3", date+"/"+month+"/"+year1);
                i.putExtra("image_url1",selectedImageUri1.toString());
                i.putExtra("image_url2",selectedImageUri2.toString());
                i.putExtra("image_url3",selectedImageUri3.toString());
                startActivity(i);
            }
        });


    }

    void imageChooser1() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);


    }

    // this function is triggered when user
    // selects the image from the imageChooser

    void imageChooser2() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);

    }

    void imageChooser3() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data

                if (i == 1) {
                    selectedImageUri1 = data.getData();
                    if (null != selectedImageUri1) {
                        // update the preview image in the layout
                        img1.setImageURI(selectedImageUri1);
                        i++;


                    }
                }
                else if (i == 2) {
                    selectedImageUri2 = data.getData();
                    if (null != selectedImageUri2) {
                        // update the preview image in the layout
                        img2.setImageURI(selectedImageUri2);
                        i++;


                    }


                }
                else {
                    selectedImageUri3 = data.getData();
                    if (null != selectedImageUri3) {
                        // update the preview image in the layout
                        img3.setImageURI(selectedImageUri3);



                    }

                }
            }
        }

    }



}