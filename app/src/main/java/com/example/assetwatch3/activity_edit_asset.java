package com.example.assetwatch3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class activity_edit_asset extends AppCompatActivity {
 private static final String TAG = "main activity";
 private SectionsPageAdapter mSectionsPageAdapter;
 private ViewPager mViewPager;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_edit_asset);
  Toolbar toolbar =  findViewById(R.id.toolbar_id);
  setSupportActionBar(toolbar);
  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  getSupportActionBar().setDisplayShowHomeEnabled(true);

  mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager(), 0);
  mViewPager = findViewById(R.id.item_details_view_pager);
  setupViewPage(mViewPager);
  TabLayout tabLayout = findViewById(R.id.item_details_tabLayout);
  tabLayout.setupWithViewPager(mViewPager);
 }

 private void setupViewPage(ViewPager viewPager) {
  SectionsPageAdapter viewPagerAdapter = new SectionsPageAdapter(getSupportFragmentManager(), 0);
  viewPagerAdapter.addFragment(new Overview_fragment(), "Overview");
  viewPagerAdapter.addFragment(new History_fragment(), "History");
  viewPagerAdapter.addFragment(new Reports_fragment(), "Reports");
  viewPager.setAdapter(viewPagerAdapter);
 }

}