package com.example.assetwatch3;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class Assets_Fragment extends Fragment {

 private ArrayList<Asset_Item_Model> mAssetList_array;
 private RecyclerView mAssetList_rv;
 private Asset_List_RV_Adapter mAssetList_array_adapter;
 private RecyclerView.LayoutManager mAssetList_layoutManager;
 private String jsonFileName = "vehicles.json";
 private String jsonFileName2 = "containers.json";
 private FloatingActionButton addAssetButton, scanAsset_button;
 Dialog mDialog;

 @Nullable
 @Override
 public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
  View view = inflater.inflate(R.layout.assets_fragment,
    container, false);
  getDataFromJson();
  mAssetList_rv = (RecyclerView) view.findViewById(R.id.AssetList_rv_id);
  mAssetList_rv.setHasFixedSize(true);
  mAssetList_layoutManager = new LinearLayoutManager(getContext());
  mAssetList_array_adapter = new Asset_List_RV_Adapter(mAssetList_array);
  mAssetList_rv.setLayoutManager(mAssetList_layoutManager);
  mAssetList_rv.setAdapter(mAssetList_array_adapter);
  mAssetList_array_adapter.setOnItemClickListener(new Asset_List_RV_Adapter.OnItemClickListener() {
   @Override
   public void onItemClick(int position) {
    Intent myIntent = new Intent(getActivity(), activity_edit_asset.class);
//        myIntent.putExtra("AlarmParcel", (Parcelable) AlarmList.get(position));
    startActivity(myIntent);
   }
  });

  addAssetButton = view.findViewById(R.id.add_asset_button_id);
  scanAsset_button = view.findViewById(R.id.scanAsset_button_id);

  addAssetButton.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    Intent myIntent = new Intent(getActivity(), create_asset_activity.class);
    startActivity(myIntent);
   }
  });

  scanAsset_button.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    mDialog.show();

    final Handler handler = new Handler(Looper.getMainLooper());
    handler.postDelayed(new Runnable() {
     @Override
     public void run() {
      Intent myIntent = new Intent(getActivity(), activity_edit_asset.class);
      startActivity(myIntent);
      mDialog.dismiss();
     }
    }, 1000);
   }
  });

  View view2 = getLayoutInflater().inflate(R.layout.scan_asset_dialog, null);

  mDialog = new Dialog(getContext(), android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen);
  mDialog.setContentView(view2);
  mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

  return view;

 }


 @Override
 public void onActivityCreated(@Nullable Bundle savedInstanceState) {
  super.onActivityCreated(savedInstanceState);

 }

 private void getDataFromJson() {
  mAssetList_array = new ArrayList<>();
  Random randomNumberGenerator;
  randomNumberGenerator = new Random();
  try {
   JSONArray jsonArray = new JSONArray(jsonParse());
   int maxLength = 0;
   if (jsonArray.length() > 10) {
    maxLength = 10;
   } else {
    maxLength = jsonArray.length();
   }
   int AlarmCount = 0;
   for (int i = 0; i < maxLength; i++) {
    JSONObject itemObject = jsonArray.getJSONObject(i);
    int asset_status = getAssetStatusID(itemObject.getString("status"));
    mAssetList_array.add(new Asset_Item_Model(
        itemObject.getString("id"),
        itemObject.getString("readtime"),
        itemObject.getString("subcategory"),
        itemObject.getString("comments"),
        itemObject.getString("status")
      )
    );
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
   InputStream is = getActivity().getAssets().open(jsonFileName2);
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
