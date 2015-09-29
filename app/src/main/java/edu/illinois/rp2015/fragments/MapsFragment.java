package edu.illinois.rp2015.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.illinois.rp2015.adapters.MapsAdapter;
import edu.illinois.rp2015.R;

public class MapsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.maps_fragment,container,false);
        getActivity().getWindow().addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        final ListView mapsList = (ListView) v.findViewById(R.id.lstMaps);
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.startupfairmap);
        images.add(R.drawable.careerfairmap);
        MapsAdapter adapter = new MapsAdapter(getActivity(), R.layout.maps_item_list, images);
        mapsList.setAdapter(adapter);
        return v;
    }

}
