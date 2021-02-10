package com.example.assetwatch3;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.FloatMath;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link image_dialoge#newInstance} factory method to
 * create an instance of this fragment.
 */
public class image_dialoge  extends DialogFragment {

 ImageView imageDetail;
 Matrix matrix = new Matrix();
 Matrix savedMatrix = new Matrix();
 PointF startPoint = new PointF();
 PointF midPoint = new PointF();
 float oldDist = 1f;
 static final int NONE = 0;
 static final int DRAG = 1;
 static final int ZOOM = 2;
 int mode = NONE;



 @Override
 public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
 }

 @Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState) {
  // Inflate the layout for this fragment
  View view = inflater.inflate(R.layout.fragment_image_dialoge, container, false);
  imageDetail = view.findViewById(R.id.imageEnhance);
/**
 * set on touch listner on image
 */
  imageDetail.setOnTouchListener(new View.OnTouchListener() {

   @Override
   public boolean onTouch(View v, MotionEvent event) {

    ImageView view = (ImageView) v;
    System.out.println("matrix=" + savedMatrix.toString());
    switch (event.getAction() & MotionEvent.ACTION_MASK) {
     case MotionEvent.ACTION_DOWN:

      savedMatrix.set(matrix);
      startPoint.set(event.getX(), event.getY());
      mode = DRAG;
      break;

     case MotionEvent.ACTION_POINTER_DOWN:

      oldDist = spacing(event);

      if (oldDist > 10f) {
       savedMatrix.set(matrix);
       midPoint(midPoint, event);
       mode = ZOOM;
      }
      break;

     case MotionEvent.ACTION_UP:

     case MotionEvent.ACTION_POINTER_UP:
      mode = NONE;

      break;

     case MotionEvent.ACTION_MOVE:
      if (mode == DRAG) {
       matrix.set(savedMatrix);
       matrix.postTranslate(event.getX() - startPoint.x, event.getY() - startPoint.y);
      } else if (mode == ZOOM) {
       float newDist = spacing(event);

       if (newDist > 10f) {
        matrix.set(savedMatrix);
        float scale = newDist / oldDist;
        matrix.postScale(scale, scale, midPoint.x, midPoint.y);
       }
      }
      break;
    }
    view.setImageMatrix(matrix);

    return true;
   }

   @SuppressLint("FloatMath")
   private float spacing(MotionEvent event) {
    float x = event.getX(0) - event.getX(1);
    float y = event.getY(0) - event.getY(1);
    return (float)Math.sqrt(x * x + y * y);
   }

   private void midPoint(PointF point, MotionEvent event) {
    float x = event.getX(0) + event.getX(1);
    float y = event.getY(0) + event.getY(1);
    point.set(x / 2, y / 2);
   }
  });
  return view;
 }

 @Override
 public Dialog onCreateDialog(Bundle savedInstanceState) {
  // The only reason you might override this method when using onCreateView() is
  // to modify any dialog characteristics. For example, the dialog includes a
  // title by default, but your custom layout might not need it. So here you can
  // remove the dialog title, but you must call the superclass to get the Dialog.
  Dialog dialog = super.onCreateDialog(savedInstanceState);
  dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

  return dialog;
 }


}