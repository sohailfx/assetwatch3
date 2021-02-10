package com.example.assetwatch3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class pdf_report_view extends AppCompatActivity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.pdf_report_view_activity);

  Toolbar toolbar = findViewById(R.id.toolbar_id);
  setSupportActionBar(toolbar);
  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  getSupportActionBar().setDisplayShowHomeEnabled(true);

  final ProgressDialog progressDialog = new ProgressDialog(this);
  progressDialog.setMessage("Loading Data...");
  progressDialog.setCancelable(false);

  WebView mWebView = findViewById(R.id.webView);
  mWebView.requestFocus();

  mWebView.getSettings().setJavaScriptEnabled(true);
  mWebView.getSettings().setBuiltInZoomControls(true);

  String url1 = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
  String url2 = "http://157.119.108.41:6061/sensornet/Mockups/esol2/js/installationreport.pdf";
  String finalUrl = "http://drive.google.com/viewerng/viewer?embedded=true&url=" + url2;

  mWebView.loadUrl(finalUrl);
  mWebView.setWebViewClient(new WebViewClient() {
   @Override
   public boolean shouldOverrideUrlLoading(WebView view, String finalUrl) {
    view.loadUrl(finalUrl);
    return true;
   }
  });

  mWebView.setWebChromeClient(new WebChromeClient() {
   public void onProgressChanged(WebView view, int progress) {
    if (progress < 100) {
     progressDialog.show();
    }
    if (progress == 100) {
     progressDialog.dismiss();
    }
   }
  });
 }
 @Override
 public boolean onSupportNavigateUp() {
  onBackPressed();
  return true;
 }
}