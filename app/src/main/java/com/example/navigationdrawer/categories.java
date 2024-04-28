package com.example.navigationdrawer;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class categories extends AppCompatActivity {
    ImageButton btadd1, btsub1, btadd2, btsub2, btadd3, btsub3, btadd4, btsub4, btadd5, btsub5;
    ImageButton btadd6, btsub6, btadd7, btsub7, btadd8, btsub8, btadd9, btsub9;
    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt;

    Integer a1, a2,a3,a4,a5,a6,a7,a8,a9, res;

    String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);
        txt4=findViewById(R.id.txt4);
        txt5=findViewById(R.id.txt5);
        txt6=findViewById(R.id.txt6);
        txt7=findViewById(R.id.txt7);
        txt8=findViewById(R.id.txt8);
        txt9=findViewById(R.id.txt9);
        btadd1=findViewById(R.id.btadd1);
        btadd2=findViewById(R.id.btadd2);
        btadd3=findViewById(R.id.btadd3);
        btadd4=findViewById(R.id.btadd4);
        btadd5=findViewById(R.id.btadd5);
        btadd6=findViewById(R.id.btadd6);
        btadd7=findViewById(R.id.btadd7);
        btadd8=findViewById(R.id.btadd8);
        btadd9=findViewById(R.id.btadd9);
        btsub1=findViewById(R.id.btsub1);
        btsub2=findViewById(R.id.btsub2);
        btsub3=findViewById(R.id.btsub3);
        btsub4=findViewById(R.id.btsub4);
        btsub5=findViewById(R.id.btsub5);
        btsub6=findViewById(R.id.btsub6);
        btsub7=findViewById(R.id.btsub7);
        btsub8=findViewById(R.id.btsub8);
        btsub9=findViewById(R.id.btsub9);

        txt=findViewById(R.id.txt);
        String str1=txt1.getText().toString();
        a1=Integer.parseInt(str1);
        String str2=txt2.getText().toString();
        a2=Integer.parseInt(str2);
        String str3=txt3.getText().toString();
        a3=Integer.parseInt(str3);
        String str4=txt4.getText().toString();
        a4=Integer.parseInt(str4);
        String str5=txt5.getText().toString();
        a5=Integer.parseInt(str2);
        String str6=txt6.getText().toString();
        a6=Integer.parseInt(str6);
        String str7=txt7.getText().toString();
        a7=Integer.parseInt(str7);
        String str8=txt8.getText().toString();
        a8=Integer.parseInt(str8);
        String str9=txt9.getText().toString();
        a9=Integer.parseInt(str9);

        Integer p1=650,p2=800,p3=700,p4=500,p5=550,p6=300,p7=1100,p8=500,p9=700;


        btsub1.setOnClickListener(new View.OnClickListener() {
            String str1;
            @Override
            public void onClick(View v) {
                a1=a1-1;
                if(a1<0)
                {
                    a1=0;

                }
                else{
                    str1=Integer.toString(a1);
                    txt1.setText(str1);
                    res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                    str=Integer.toString(res);
                    txt.setText(str);

                }

            }
        });

        btadd1.setOnClickListener(new View.OnClickListener()  {
            String str1;


            @Override
            public void onClick(View view) {
                a1=a1+1;
                str1=Integer.toString(a1);
                txt1.setText(str1);
                res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                str=Integer.toString(res);
                txt.setText(str);

            }
        });


        btsub2.setOnClickListener(new View.OnClickListener() {
            String str2;
            @Override
            public void onClick(View v) {
                a2=a2-1;
                if(a2<0)
                {
                    a2=0;
                }
                else{
                    str2=Integer.toString(a2);
                    txt2.setText(str2);
                    res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                    str=Integer.toString(res);
                    txt.setText(str);

                }

            }
        });

        btadd2.setOnClickListener(new View.OnClickListener()  {
            String str2;


            @Override
            public void onClick(View view) {
                a2=a2+1;
                str2=Integer.toString(a2);
                txt2.setText(str2);
                res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                str=Integer.toString(res);
                txt.setText(str);

            }
        });


        btsub3.setOnClickListener(new View.OnClickListener() {
            String str3;
            @Override
            public void onClick(View v) {
                a3=a3-1;
                if(a3<0)
                {
                    a3=0;
                }
                else{
                    str3=Integer.toString(a3);
                    txt3.setText(str3);
                    res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                    str=Integer.toString(res);
                    txt.setText(str);

                }

            }
        });

        btadd3.setOnClickListener(new View.OnClickListener()  {
            String str3;


            @Override
            public void onClick(View view) {
                a3=a3+1;
                str3=Integer.toString(a3);
                txt3.setText(str3);
                res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                str=Integer.toString(res);
                txt.setText(str);

            }
        });


        btsub4.setOnClickListener(new View.OnClickListener() {
            String str4;
            @Override
            public void onClick(View v) {
                a4=a4-1;
                if(a4<0)
                {
                    a4=0;
                }
                else{
                    str4=Integer.toString(a4);
                    txt4.setText(str4);
                    res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                    str=Integer.toString(res);
                    txt.setText(str);

                }

            }
        });

        btadd4.setOnClickListener(new View.OnClickListener()  {
            String str4;


            @Override
            public void onClick(View view) {
                a4=a4+1;
                str4=Integer.toString(a4);
                txt4.setText(str4);
                res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                str=Integer.toString(res);
                txt.setText(str);

            }
        });

        btsub5.setOnClickListener(new View.OnClickListener() {
            String str5;
            @Override
            public void onClick(View v) {
                a5=a5-1;
                if(a5<0)
                {
                    a5=0;
                }
                else{
                    str5=Integer.toString(a5);
                    txt5.setText(str5);
                    res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                    str=Integer.toString(res);
                    txt.setText(str);

                }

            }
        });

        btadd5.setOnClickListener(new View.OnClickListener()  {
            String str5;


            @Override
            public void onClick(View view) {
                a5=a5+1;
                str5=Integer.toString(a5);
                txt5.setText(str5);
                res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                str=Integer.toString(res);
                txt.setText(str);

            }
        });


        btsub6.setOnClickListener(new View.OnClickListener() {
            String str6;
            @Override
            public void onClick(View v) {
                a6=a6-1;
                if(a6<0)
                {
                    a6=0;
                }
                else{
                    str6=Integer.toString(a6);
                    txt6.setText(str6);
                    res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                    str=Integer.toString(res);
                    txt.setText(str);

                }

            }
        });

        btadd6.setOnClickListener(new View.OnClickListener()  {
            String str6;


            @Override
            public void onClick(View view) {
                a6=a6+1;
                str6=Integer.toString(a6);
                txt6.setText(str6);
                res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                str=Integer.toString(res);
                txt.setText(str);

            }
        });


        btsub7.setOnClickListener(new View.OnClickListener() {
            String str7;
            @Override
            public void onClick(View v) {
                a7=a7-1;
                if(a7<0)
                {
                    a7=0;
                }
                else{
                    str7=Integer.toString(a7);
                    txt7.setText(str7);
                    res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                    str=Integer.toString(res);
                    txt.setText(str);

                }

            }
        });

        btadd7.setOnClickListener(new View.OnClickListener()  {
            String str7;


            @Override
            public void onClick(View view) {
                a7=a7+1;
                str7=Integer.toString(a7);
                txt7.setText(str7);
                res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                str=Integer.toString(res);
                txt.setText(str);

            }
        });


        btsub8.setOnClickListener(new View.OnClickListener() {
            String str8;
            @Override
            public void onClick(View v) {
                a8=a8-1;
                if(a8<0)
                {
                    a8=0;
                }
                else{
                    str8=Integer.toString(a8);
                    txt8.setText(str8);
                    res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                    str=Integer.toString(res);
                    txt.setText(str);

                }

            }
        });

        btadd8.setOnClickListener(new View.OnClickListener()  {
            String str8;


            @Override
            public void onClick(View view) {
                a8=a8+1;
                str8=Integer.toString(a8);
                txt8.setText(str8);
                res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                str=Integer.toString(res);
                txt.setText(str);

            }
        });


        btsub9.setOnClickListener(new View.OnClickListener() {
            String str9;
            @Override
            public void onClick(View v) {
                a9=a9-1;
                if(a9<0)
                {
                    a9=0;
                }
                else{
                    str9=Integer.toString(a9);
                    txt9.setText(str9);
                    res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                    str=Integer.toString(res);
                    txt.setText(str);

                }

            }
        });

        btadd9.setOnClickListener(new View.OnClickListener()  {
            String str9;


            @Override
            public void onClick(View view) {
                a9=a9+1;
                str9=Integer.toString(a9);
                txt9.setText(str9);
                res=(a1*p1)+(a2*p2)+(a3*p3)+(a4*p4)+(a5*p5)+(a6*p6)+(a7*p7)+(a8*p8)+(a9*p9);
                str=Integer.toString(res);
                txt.setText(str);

            }
        });





    }
}