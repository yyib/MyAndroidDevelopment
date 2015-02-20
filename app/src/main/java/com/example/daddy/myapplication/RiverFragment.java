package com.example.daddy.myapplication;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RiverFragment extends Fragment {


    public RiverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        int position = getArguments().getInt("position");

        String [] rivers = getResources().getStringArray(R.array.rivers);
        View v = inflater.inflate(R.layout.fragment_layout,container, false);
        TextView tv = (TextView) v.findViewById(R.id.tv_content);
        tv.setText(rivers[position]);
        getActivity().getActionBar().setTitle(rivers[position]);
        return v;

      //  return inflater.inflate(R.layout.fragment_layout, container, false);
    }


}
