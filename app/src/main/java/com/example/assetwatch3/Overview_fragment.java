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
import androidx.fragment.app.Fragment;

public class Overview_fragment extends Fragment {
 private static final String TAG = "Over view fragment";
private Button mButton;
 @Nullable
 @Override
 public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

  View view = inflater.inflate(R.layout.overview_fragment, container,false);
//  mButton = view.findViewById(R.id.button1);
//  mButton.setOnClickListener(new View.OnClickListener() {
//   @Override
//   public void onClick(View view) {
//    Toast.makeText(getActivity(), "Test Button click 1", Toast.LENGTH_SHORT).show();
//   }
//  });
  return  view;
 }
}
