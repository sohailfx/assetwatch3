package com.example.assetwatch3;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AssetsFragment extends Fragment {
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_assets,
      container, false);

    LinearLayout edit_button =view.findViewById(R.id.edit_button_id);
    LinearLayout report_button=view.findViewById(R.id.report_button_id);
    edit_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(getActivity(), activity_edit_asset.class);
        startActivity(intent);
      }
    });

    report_button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(getActivity(), report_create_activity.class);
        startActivity(intent);
      }
    });

    return  view;

  }
}
