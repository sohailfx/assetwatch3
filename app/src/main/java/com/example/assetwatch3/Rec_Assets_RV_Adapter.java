package com.example.assetwatch3;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Rec_Assets_RV_Adapter extends RecyclerView.Adapter<Rec_Assets_RV_Adapter.AssetList_ViewHolder> {
 private ArrayList<Asset_Item_Model> mAssetList;
 private OnItemClickListener mListener;

 public interface OnItemClickListener {
  void onItemClick(int position);
 }

 public void setOnItemClickListener(OnItemClickListener listener) {
  mListener = listener;
 }

 public static class AssetList_ViewHolder extends RecyclerView.ViewHolder {
  public ImageView mAssetStatus_image;
  public TextView mAssetNumber_tv;
  public TextView mAssetReadTime_tv;
  public TextView mAssetSubCategory_tv;
  public TextView mAssetDescription_tv;
  public String assetStatus;

  public AssetList_ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
   super(itemView);
   mAssetStatus_image = itemView.findViewById(R.id.AssetStatusIcon_image);
   mAssetNumber_tv = itemView.findViewById(R.id.AssetNumber_tv);
   mAssetReadTime_tv = itemView.findViewById(R.id.AssetReadTimeStamp_tv);
   mAssetSubCategory_tv = itemView.findViewById(R.id.AssetSubCategory_tv);
   itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
     if (listener != null) {
      int position = getAdapterPosition();
      if (position != RecyclerView.NO_POSITION) {
       listener.onItemClick(position);
      }
     }
    }
   });
  }
 }

 public Rec_Assets_RV_Adapter(ArrayList<Asset_Item_Model> assetList) {
  mAssetList = assetList;
 }

 @NonNull
 @Override
 public AssetList_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
  View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_asset_item_model, parent, false);
  AssetList_ViewHolder evh = new AssetList_ViewHolder(v, mListener);
  return evh;
 }

 @Override
 public void onBindViewHolder(@NonNull AssetList_ViewHolder holder, int position) {
  if (position % 2 == 1) {
   holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
   //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
  } else {
   holder.itemView.setBackgroundColor(Color.parseColor("#FFFAF8FD"));
   //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFAF8FD"));
  }

  Asset_Item_Model currentItem = mAssetList.get(position);
  String status = currentItem.getAssetStatusString();
  if (status.equals("workshop")) {
   holder.mAssetStatus_image.setImageResource(R.drawable.ic_workshop);
   holder.mAssetStatus_image.setColorFilter(ContextCompat.getColor(holder.mAssetStatus_image.getContext(), R.color.pinkColor));
  } else if (status.equals("available")) {
   holder.mAssetStatus_image.setImageResource(R.drawable.ic_availableasset);
   holder.mAssetStatus_image.setColorFilter(ContextCompat.getColor(holder.mAssetStatus_image.getContext(), R.color.greenColor));
  } else if (status.equals("rented")) {
   holder.mAssetStatus_image.setImageResource(R.drawable.ic_rent_asset2);
   holder.mAssetStatus_image.setColorFilter(ContextCompat.getColor(holder.mAssetStatus_image.getContext(), R.color.blueColor));
  } else if (status.equals("damaged")) {
   holder.mAssetStatus_image.setImageResource(R.drawable.ic_damagedasset);
   holder.mAssetStatus_image.setColorFilter(ContextCompat.getColor(holder.mAssetStatus_image.getContext(), R.color.redColor));
  } else if (status.equals("new")) {
   holder.mAssetStatus_image.setImageResource(R.drawable.ic_new_asset);
   holder.mAssetStatus_image.setColorFilter(ContextCompat.getColor(holder.mAssetStatus_image.getContext(), R.color.tealColor));
  } else if (status.equals("tag")) {
   holder.mAssetStatus_image.setImageResource(R.drawable.ic_tagging);
   holder.mAssetStatus_image.setColorFilter(ContextCompat.getColor(holder.mAssetStatus_image.getContext(), R.color.pinkColor));
  } else if (status.equals("device")) {
   holder.mAssetStatus_image.setImageResource(R.drawable.ic_devicing);
   holder.mAssetStatus_image.setColorFilter(ContextCompat.getColor(holder.mAssetStatus_image.getContext(), R.color.orangeColor));
  } else if (status.equals("stage")) {
   holder.mAssetStatus_image.setImageResource(R.drawable.ic_staging);
   holder.mAssetStatus_image.setColorFilter(ContextCompat.getColor(holder.mAssetStatus_image.getContext(), R.color.blueColor));
  } else if (status.equals("putaway")) {
   holder.mAssetStatus_image.setImageResource(R.drawable.ic_putaway);
   holder.mAssetStatus_image.setColorFilter(ContextCompat.getColor(holder.mAssetStatus_image.getContext(), R.color.darkGreenColor));
  } else {
   holder.mAssetStatus_image.setImageResource(R.drawable.ic_asset);
   holder.mAssetStatus_image.setColorFilter(ContextCompat.getColor(holder.mAssetStatus_image.getContext(), R.color.greyColor));
  }
  holder.mAssetNumber_tv.setText(currentItem.getAssetNumber_tv());
  holder.mAssetReadTime_tv.setText(currentItem.getAssetReadTime_tv());
  holder.mAssetSubCategory_tv.setText(currentItem.getAssetSubCategory_tv());
 }

 @Override
 public int getItemCount() {
  return mAssetList.size();
 }
}
