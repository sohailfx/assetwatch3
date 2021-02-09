package com.example.assetwatch3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class report_create_activity extends AppCompatActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.report_create_activity);
  Toolbar toolbar = findViewById(R.id.toolbar_id);
  setSupportActionBar(toolbar);
  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  getSupportActionBar().setDisplayShowHomeEnabled(true);
 }

 @Override
 public boolean onSupportNavigateUp() {
  onBackPressed();
  return true;
 }
}