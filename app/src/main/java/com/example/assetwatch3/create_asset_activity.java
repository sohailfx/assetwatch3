package com.example.assetwatch3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class create_asset_activity extends AppCompatActivity {
 Button mSaveButton;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.create_asset_activity);
  Toolbar toolbar = findViewById(R.id.toolbar_id);
  mSaveButton = findViewById(R.id.save_button_id);

  setSupportActionBar(toolbar);
  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  getSupportActionBar().setDisplayShowHomeEnabled(true);

  mSaveButton.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    Intent myIntent = new Intent(create_asset_activity.this, MainActivity.class);
    startActivity(myIntent);
   }
  });
 }

 @Override
 public boolean onSupportNavigateUp() {
  onBackPressed();
  return true;
 }

}