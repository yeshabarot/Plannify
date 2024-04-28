package com.example.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.navigationdrawer.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ////////////////
    ActivityMainBinding binding;

    //////////////
    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    MeowBottomNavigation bottomNavigation;
    Toolbar toolbar;
    Menu menu;
    TextView textView;
    FrameLayout frameLayout;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        /////////////////


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
        navigationView.setNavigationItemSelectedListener(this);
/////
        bottomNavigation = findViewById(R.id.bottom);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.plus));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.memory_icon));
        bottomNavigation.setBackground(null);
////
        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Fragment fragment = null;
                switch (model.getId()) {
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        fragment = new PlusFragment();
                        break;
                    case 3:
                        fragment = new MemoryFragment();
                        break;
                }
                loadFragment(fragment);
                return null;
            }
        });
        bottomNavigation.show(1, true);
        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                return null;
            }

        });
        fragmentManager = getSupportFragmentManager();{}
        //openFragment(new HomeFragment());


    }




    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {

        int itemId=item.getItemId();

        if(itemId==R.id.nav_home)

        {
            Toast.makeText(MainActivity.this,"This is navigation Home",Toast.LENGTH_SHORT).show();

        }

        if(itemId==R.id.nav_profile)

        {
            Toast.makeText(MainActivity.this,"You Clicked Profile",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,Profile_page.class);
            startActivity(intent);
        }
        if(itemId==R.id.nav_settings)

        {
            Toast.makeText(MainActivity.this,"You Clicked Settings",Toast.LENGTH_SHORT).show();

        }
        if(itemId==R.id.nav_logout)

        {
            Toast.makeText(MainActivity.this,"You've Logged Out!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,LoginPage.class);
            startActivity(intent);

        }
        if(itemId==R.id.nav_aboutus)

        {
            Toast.makeText(MainActivity.this,"You Clicked AboutUs",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,aboutus.class);
            startActivity(intent);
        }
        if(itemId==R.id.nav_rateus)

        {
            Toast.makeText(MainActivity.this,"Rate Us Please",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,rateus.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openFragment(Fragment fragment){

        FragmentTransaction transaction= fragmentManager.beginTransaction();
        transaction.replace(R.id.home,fragment);
        transaction.commit();


    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout1,fragment)
                .commit();
    }
}

