package com.example.assetwatch3;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Overview_fragment extends Fragment {
 private static final String TAG = "Over view fragment";
 private Button mSaveButton;
 private CardView mInstallation_report_button, mEntry_report_button, mExit_report_button, mDamage_report_button;


 Dialog mDialog;

 @Nullable
 @Override
 public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

  View view = inflater.inflate(R.layout.overview_fragment, container, false);
  View view2 = getLayoutInflater().inflate(R.layout.dialog_fragment, null);

  mDialog = new Dialog(getContext());
  mDialog.setContentView(view2);
  mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

  final LinearLayout report_button = view.findViewById(R.id.report_button_id);
  LinearLayout frameLayout;
  frameLayout = view2.findViewById(R.id.dialog_layout_id);
  mInstallation_report_button = view2.findViewById(R.id.installation_report_button_id);
  mEntry_report_button = view2.findViewById(R.id.entry_report_button_id);
  mExit_report_button = view2.findViewById(R.id.exit_report_button_id);
  mDamage_report_button = view2.findViewById(R.id.damage_report_button_id);

  mSaveButton = view.findViewById(R.id.save_button_id);

  report_button.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    mDialog.show();
   }
  });

  mInstallation_report_button.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    gotoCreateReport();
   }
  });
  mEntry_report_button.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    gotoCreateReport();
   }
  });
  mExit_report_button.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    gotoCreateReport();
   }
  });
  mDamage_report_button.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    gotoCreateReport();
   }
  });
  mSaveButton.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    Intent myIntent = new Intent(getActivity(), MainActivity.class);
    startActivity(myIntent);
   }
  });

  frameLayout.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
//    mDialog.dismiss();
   }
  });

//  mButton = view.findViewById(R.id.button1);
//  mButton.setOnClickListener(new View.OnClickListener() {
//   @Override
//   public void onClick(View view) {
//    Toast.makeText(getActivity(), "Test Button click 1", Toast.LENGTH_SHORT).show();
//   }
//  });
  return view;
 }

 private void gotoPreviousPage() {

 }

 private void gotoCreateReport() {
//  getParentFragment().getActivity().onBackPressed();
  Intent myIntent = new Intent(getActivity(), report_create_activity.class);
  startActivity(myIntent);
 }


}
