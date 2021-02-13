package com.example.assetwatch3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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

public class AssetsFragment extends Fragment {

 private ArrayList<Asset_Item_Model> mAssetList_array;
 private RecyclerView mAssetList_rv;
 private Asset_List_RV_Adapter mAssetList_array_adapter;
 private RecyclerView.LayoutManager mAssetList_layoutManager;
 private String jsonFileName = "vehicles.json";
 private String jsonFileName2 = "containers.json";
 private FloatingActionButton addAssetButton;

 @Nullable
 @Override
 public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
  View view = inflater.inflate(R.layout.fragment_assets,
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
  addAssetButton.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    Intent myIntent = new Intent(getActivity(), create_asset_activity.class);
    startActivity(myIntent);
   }
  });
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
        asset_status,
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
