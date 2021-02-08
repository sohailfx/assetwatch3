package com.example.assetwatch3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsPageAdapter extends FragmentPagerAdapter {

 private List<Fragment> mFragmentList = new ArrayList<>();
 private List<String> mFragmentTitleList = new ArrayList<>();

 public SectionsPageAdapter(@NonNull FragmentManager fm, int behavior) {
  super(fm, behavior);
 }

 public void addFragment(Fragment fragment, String title) {
  mFragmentList.add(fragment);
  mFragmentTitleList.add(title);
 }

 @NonNull
 @Override
 public Fragment getItem(int position) {
  return mFragmentList.get(position);

 }

 @Override
 public int getCount() {
  return mFragmentList.size();
 }
 @Nullable
 @Override
 public CharSequence getPageTitle(int position) {
  return mFragmentTitleList.get(position);
 }
}
