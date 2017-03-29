package com.amonsul.muhammad.a5o5a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BomboFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BomboFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BomboFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Integer[] mThumbIds = {
            R.drawable.bombo_1, R.drawable.bombo_2,
            R.drawable.bombo_3, R.drawable.bombo_4,
            R.drawable.bombo_5, R.drawable.bombo_6,
            R.drawable.bombo_7, R.drawable.bombo_8,
            R.drawable.bombo_9, R.drawable.bombo_10};
    private Integer[] stringId = {
            R.string.bombo_1 , R.string.bombo_2,
            R.string.bombo_3 , R.string.bombo_4,
            R.string.bombo_5 , R.string.bombo_6,
            R.string.bombo_7 , R.string.bombo_8,
            R.string.bombo_9 , R.string.bombo_10};

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BomboFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BomboFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BomboFragment newInstance(String param1, String param2) {
        BomboFragment fragment = new BomboFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bombo, container, false);
        GridView gridview = (GridView)view.findViewById(R.id.bombo_gridview);
        gridview.setAdapter(new BomboFragment.ImageAdapter(getActivity().getApplicationContext()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                displayImage(position);
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private class ImageAdapter extends BaseAdapter {
        private Context mContext;

        private ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {  // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageBitmap(MainActivity.decodeSampledBitmapFromResource(getResources(),mThumbIds[position],100,100) );
            return imageView;
        }

        // references to our images

    }
    protected void displayImage(int position){
        DisplayFragment fragment = new DisplayFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        MainActivity.imageSourceId = mThumbIds[position];
        MainActivity.stringSourceId = stringId[position];
        fragmentManager.beginTransaction().replace(R.id.container, fragment ,"visible_fragment").setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit();


    }
}
