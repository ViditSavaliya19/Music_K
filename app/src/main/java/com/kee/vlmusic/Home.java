package com.kee.vlmusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.jean.jcplayer.view.JcPlayerView;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kee.vlmusic.Fragment.CategoryFragment;
import com.kee.vlmusic.Fragment.HomeFragment;
import com.kee.vlmusic.Fragment.SettingsFragment;

public class Home extends AppCompatActivity {

    private BottomNavigationView bottom_app_bar;
    private FrameLayout contact;
    public static JcPlayerView jcPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        intiView();
    }

    private void intiView() {
        bottom_app_bar=findViewById(R.id.bottom_app_bar);
        bottom_app_bar.setOnNavigationItemSelectedListener(selectedListener);
        contact=findViewById(R.id.contact);
        jcPlayerView = findViewById(R.id.jcplayer);

        HomeFragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contact, fragment, "");
        fragmentTransaction.commit();

    }

    BottomNavigationView.OnNavigationItemSelectedListener selectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.nav_home:
                    HomeFragment fragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.contact, fragment, "");
                    fragmentTransaction.commit();
                    return true;

                case R.id.nav_profile:
                    SettingsFragment fragment1 = new SettingsFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.contact, fragment1);
                    fragmentTransaction1.commit();
                    return true;
            }
            return false;
        }
    };
}