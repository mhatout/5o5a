package com.amonsul.muhammad.a5o5a;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {

    public ImageView imageView;
    public TextView textView;

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);

         imageView = (ImageView) view.findViewById(R.id.myImageView);
         textView = (TextView) view.findViewById(R.id.myImageViewText);
         imageView.setImageBitmap(MainActivity.decodeSampledBitmapFromResource(getResources(),MainActivity.imageSourceId,300,300));
         textView.setText(MainActivity.stringSourceId);
        return view;
    }

}
