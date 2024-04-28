package com.example.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.card.MaterialCardView;


public class MemoryFragment extends Fragment {

    MaterialCardView addButton1,addButton2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_memory, container, false);
        addButton1 = rootView.findViewById(R.id.addMemory);

        addButton2= rootView.findViewById(R.id.gallery);
        addButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),addmemory.class);
                startActivity(intent);
            }
        });
        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),gallery2.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}