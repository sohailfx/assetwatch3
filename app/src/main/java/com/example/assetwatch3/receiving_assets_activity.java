package com.example.assetwatch3;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class receiving_assets_activity extends AppCompatActivity {
 private ArrayList<Asset_Item_Model> mAssetList_array;
 private RecyclerView mAssetList_rv;
 private Rec_Assets_RV_Adapter mAssetList_array_adapter;
 private RecyclerView.LayoutManager mAssetList_layoutManager;
 private String jsonFileName = "vehicles.json";
 private String jsonFileName2 = "containers.json";
 private FloatingActionButton addAssetButton, scanAsset_button;
 Dialog mDialog;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.receiving_assets_activity);
  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
  setSupportActionBar(toolbar);
  CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
  toolBarLayout.setTitle("Receiving Assets");

  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
  fab.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
      .setAction("Action", null).show();
   }
  });

  getDataFromJson();
  mAssetList_rv = findViewById(R.id.receivingAssets_rv_id);
  mAssetList_rv.setHasFixedSize(true);
  mAssetList_layoutManager = new LinearLayoutManager(getBaseContext());
  mAssetList_array_adapter = new Rec_Assets_RV_Adapter(mAssetList_array);
  mAssetList_rv.setLayoutManager(mAssetList_layoutManager);
  mAssetList_rv.setAdapter(mAssetList_array_adapter);
  mAssetList_array_adapter.setOnItemClickListener(new Rec_Assets_RV_Adapter.OnItemClickListener() {
   @Override
   public void onItemClick(int position) {
    Intent myIntent = new Intent(receiving_assets_activity.this, activity_edit_asset.class);
//        myIntent.putExtra("AlarmParcel", (Parcelable) AlarmList.get(position));
    startActivity(myIntent);
   }
  });


 }

 private void getDataFromJson() {
  mAssetList_array = new ArrayList<>();
  Random randomNumberGenerator;
  randomNumberGenerator = new Random();
  try {
   JSONArray jsonArray = new JSONArray(jsonParse());
   int maxLength = 0;
   if (jsonArray.length() > 10) {
    maxLength = 50;
   } else {
    maxLength = jsonArray.length();
   }
   int AlarmCount = 0;
   for (int i = 0; i < maxLength; i++) {
    JSONObject itemObject = jsonArray.getJSONObject(i);
    String status1 = itemObject.getString("status");
    if (status1.equals("new") || status1.equals("tag") || status1.equals("device") || status1.equals("stage") || status1.equals("putaway")) {
     mAssetList_array.add(new Asset_Item_Model(
         itemObject.getString("id"),
         itemObject.getString("readtime"),
         itemObject.getString("subcategory"),
         itemObject.getString("comments"),
         itemObject.getString("status")
       )
     );
    }
   }

//      mAlarmCount_tv.setText("High Priority and Active Alarms : " + String.valueOf(AlarmCount));
  } catch (JSONException e) {
   e.printStackTrace();
  }
 }

 private int getAssetStatusID(String assetStatus) {
  int return_status = R.drawable.ic_availableasset;
  if (assetStatus.equals("workshop")) {
   return_status = R.drawable.ic_workshop;
  } else if (assetStatus.equals("available")) {
   return_status = R.drawable.ic_availableasset;
  } else if (assetStatus.equals("rented")) {
   return_status = R.drawable.ic_rentedasset;
  } else if (assetStatus.equals("damaged")) {
   return_status = R.drawable.ic_damagedasset;
  } else if (assetStatus.equals("new")) {
   return_status = R.drawable.ic_new_asset;
  } else {
   return_status = R.drawable.ic_availableasset;
  }
  return return_status;
 }

 private String jsonParse() {

  String json = null;
  try {
   InputStream is = getAssets().open(jsonFileName2);
   int size = is.available();
   byte[] buffer = new byte[size];
   is.read(buffer);
   is.close();
   json = new String(buffer, "UTF-8");
  } catch (IOException ex) {
   ex.printStackTrace();
   return null;
  }
  return json;
 }
}