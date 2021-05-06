package com.example.hdwallpaper.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.hdwallpaper.R;
import com.example.hdwallpaper.fragments.FavouritesFragment;
import com.example.hdwallpaper.fragments.HomeFragment;
import com.example.hdwallpaper.fragments.SettingsFragment;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MobileAds.initialize(this,
                "ca-app-pub-4511518851615199~8923055403");

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        displayFragment(new HomeFragment());
    }

    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_area, fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_fav:
                fragment = new FavouritesFragment();
                break;
            case R.id.nav_set:
                fragment = new SettingsFragment();
                break;
            default:
                fragment = new HomeFragment();
                break;
        }
        displayFragment(fragment);
        return true;
    }
}
