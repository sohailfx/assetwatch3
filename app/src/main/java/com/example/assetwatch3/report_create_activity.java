package com.example.assetwatch3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class report_create_activity extends AppCompatActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.report_create_activity);
  Toolbar toolbar = findViewById(R.id.toolbar_id);
  setSupportActionBar(toolbar);
  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  getSupportActionBar().setDisplayShowHomeEnabled(true);

  RelativeLayout thumbnail_1 = findViewById(R.id.thumbnail_image_1);
  thumbnail_1.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    DialogFragment newFragment = new image_dialoge();
    newFragment.show(getSupportFragmentManager(), "Image View");
   }
  });

  Button report_button=findViewById(R.id.preview_button_id);
  report_button.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    Intent intent = new Intent(report_create_activity.this, pdf_view.class);
    startActivity(intent);
   }
  });

 }

 @Override
 public boolean onSupportNavigateUp() {
  onBackPressed();
  return true;
 }
}