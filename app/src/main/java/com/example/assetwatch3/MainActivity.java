package com.example.assetwatch3;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  BottomNavigationView bottomView = findViewById(R.id.bottom_navigation);
  bottomView.setOnNavigationItemSelectedListener(navListener);
  getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Assets_Fragment()).commit();
  bottomView.getMenu().findItem(R.id.nav_assets).setChecked(true);
 }

 private BottomNavigationView.OnNavigationItemSelectedListener navListener =
   new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
     Fragment selectedFragment = null;
     switch (item.getItemId()) {
      case R.id.nav_home:
       selectedFragment = new HomeFragment();
       break;
      case R.id.nav_assets:
       selectedFragment = new Assets_Fragment();
       break;
      case R.id.nav_map:
       selectedFragment = new MapFragment();
       break;
      case R.id.nav_settings:
       selectedFragment = new SettingsFragment();
       break;
     }
     getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
     return true;
    }
   };
}