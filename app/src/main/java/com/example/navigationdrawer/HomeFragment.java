package com.example.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        RelativeLayout cafesB = (RelativeLayout) rootView.findViewById(R.id.main_cafeB1);
        cafesB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cafesB();
            }
        });
        RelativeLayout restB = (RelativeLayout) rootView.findViewById(R.id.main_RestB1);
        restB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restB();
            }
        });
        RelativeLayout ViewB = (RelativeLayout) rootView.findViewById(R.id.main_viewpointsB1);
        ViewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewB();
            }

        });
        RelativeLayout mallB = (RelativeLayout) rootView.findViewById(R.id.main_mallsB1);
        mallB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mallB();
            }

        });
        RelativeLayout cinemaB = (RelativeLayout) rootView.findViewById(R.id.main_cinemaB1);
        cinemaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cinemasB();
            }

        });
        RelativeLayout ideasB = (RelativeLayout) rootView.findViewById(R.id.main_parksB1);
        ideasB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ideasB();
            }

        });
        return rootView;
    }
        public void cafesB(){
            Intent intent = new Intent(getActivity(),cafes.class);
            startActivity(intent);
            Toast.makeText(getActivity(), "Cafes Clicked", Toast.LENGTH_SHORT).show();}
        public void restB() {
            Intent intent = new Intent(getActivity(), diner.class);
            startActivity(intent);
            Toast.makeText(getActivity(), "Diners Clicked", Toast.LENGTH_SHORT).show();}

        public void ViewB(){
            Toast.makeText(getActivity(), "Viewpoints Clicked", Toast.LENGTH_SHORT).show();
        }
        public void mallB(){
        Toast.makeText(getActivity(), "Malls Clicked", Toast.LENGTH_SHORT).show();
        }
         public void cinemasB(){
        Toast.makeText(getActivity(), "Cinemas Clicked", Toast.LENGTH_SHORT).show();
        }
     public void ideasB(){
         Intent intent = new Intent(getActivity(),weblist.class);
         startActivity(intent);
        Toast.makeText(getActivity(), "Date Ideas Clicked", Toast.LENGTH_SHORT).show();
        }


    }

