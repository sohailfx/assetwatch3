package com.example.assetwatch3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Reports_fragment extends Fragment {
 private static final String TAG = "Over view fragment";
private CardView mButton;
 @Nullable
 @Override
 public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

  View view = inflater.inflate(R.layout.reports_fragment, container,false);
  mButton = view.findViewById(R.id.report_button_id);
  mButton.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
    Intent intent = new Intent(getActivity(), pdf_report_view.class);
    startActivity(intent);
   }
  });

  return  view;
 }
}
