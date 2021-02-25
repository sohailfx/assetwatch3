package com.example.assetwatch3;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class dashboard_activity extends AppCompatActivity {
 private Button receiving_button;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.dashboard_activity);
  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
  setSupportActionBar(toolbar);
  CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
  toolBarLayout.setTitle("Asset Watch");

  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
  fab.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
      .setAction("Action", null).show();
   }
  });
  receiving_button = findViewById(R.id.receiving_button_id);
  receiving_button.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    Intent myIntent = new Intent(dashboard_activity.this, receiving_assets_activity.class);
    startActivity(myIntent);
   }
  });
 }
}