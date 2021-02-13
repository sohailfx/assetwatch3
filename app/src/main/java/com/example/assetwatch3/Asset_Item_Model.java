package com.example.assetwatch3;

import android.os.Parcel;
import android.os.Parcelable;

public class Asset_Item_Model implements Parcelable {
  private int mAssetStatus_Image;
  private String mAssetNumber_tv;
  private String mAssetReadTime_tv;
  private String mAssetSubCategory_tv;
  private String mAssetDescription_tv;
  private String mAssetStatusString;


  public Asset_Item_Model(
    int assetStatus_Image,
    String assetNumber_tv,
    String assetReadTime_tv,
    String assetSubCategory_tv,
    String assetDescription,
    String assetStatusString) {
    mAssetStatus_Image = assetStatus_Image;
    mAssetNumber_tv = assetNumber_tv;
    mAssetReadTime_tv = assetReadTime_tv;
    mAssetSubCategory_tv = assetSubCategory_tv;
    mAssetDescription_tv = assetDescription;
    mAssetStatusString = assetStatusString;
  }

  protected Asset_Item_Model(Parcel in) {
    mAssetStatus_Image = in.readInt();
    mAssetNumber_tv = in.readString();
    mAssetReadTime_tv = in.readString();
    mAssetSubCategory_tv = in.readString();
    mAssetDescription_tv = in.readString();
  }

  public static final Creator<Asset_Item_Model> CREATOR = new Creator<Asset_Item_Model>() {
    @Override
    public Asset_Item_Model createFromParcel(Parcel in) {
      return new Asset_Item_Model(in);
    }

    @Override
    public Asset_Item_Model[] newArray(int size) {
      return new Asset_Item_Model[size];
    }
  };

  public int getAssetStatus_Image() {
    return mAssetStatus_Image;
  }

  public String getAssetNumber_tv() {
    return mAssetNumber_tv;
  }

  public String getAssetReadTime_tv() {
    return mAssetReadTime_tv;
  }

  public String getAssetSubCategory_tv() {
    return mAssetSubCategory_tv;
  }

  public String getAssetDescription_tv() {
    return mAssetDescription_tv;
  }

  public String getAssetStatusString() {
    return mAssetStatusString;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeInt(mAssetStatus_Image);
    parcel.writeString(mAssetNumber_tv);
    parcel.writeString(mAssetDescription_tv);
    parcel.writeString(mAssetSubCategory_tv);
    parcel.writeString(mAssetReadTime_tv);
  }
}
