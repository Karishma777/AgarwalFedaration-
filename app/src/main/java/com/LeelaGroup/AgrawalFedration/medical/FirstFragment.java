package com.LeelaGroup.AgrawalFedration.medical;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.LeelaGroup.AgrawalFedration.R;

/**
 * Created by Adwait on 11/05/2017.
 */
public class FirstFragment extends Fragment {


    GridView simpleGrid;
    int logos[] = {R.drawable.medical, R.drawable.medical1, R.drawable.medical3, R.drawable.medical4,
            R.drawable.medical6,R.drawable.medical6,R.drawable.medical7,R.drawable.medical8,R.drawable.medical9};


    @Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_first, container, false);

    simpleGrid = (GridView) view.findViewById(R.id.simpleGridView); // init GridView
    CustomAdapterTabGrid customAdapter = new CustomAdapterTabGrid(getActivity().getApplicationContext(), logos);
    simpleGrid.setAdapter(customAdapter);
    // implement setOnItemClickListener event on GridView
    simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // set an Intent to Another Activity
            Intent intent = new Intent(getActivity(), SearchResult_Medical.class);
            intent.putExtra("image", logos[position]); // put image data in Intent
            startActivity(intent); // start Intent
        }
    });

    return view;
}
}