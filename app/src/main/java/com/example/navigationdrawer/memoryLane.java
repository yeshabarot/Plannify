package com.example.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class memoryLane extends AppCompatActivity {
    MaterialCardView addButton1,addButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorylane);
        addButton1 = findViewById(R.id.addMemory);

        addButton2= findViewById(R.id.gallery);
    }
    public void openNew(View view){

        Intent n2 = new Intent(memoryLane.this, addmemory.class);

        Intent n4 = new Intent(memoryLane.this, gallery2.class);

        int id = view.getId();

        if(id==R.id.addMemory){
            startActivity(n2);
        } else if (id==R.id.gallery) {
            startActivity(n4);
        }

    }
}