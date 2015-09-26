package edu.illinois.rp2015.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import edu.illinois.rp2015.R;

public class PuzzlebangFragment extends Fragment {

    public PuzzlebangFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_puzzlebang, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ScrollView scrollView = (ScrollView) view.findViewById(R.id.aboutScroll);
        scrollView.fullScroll(View.FOCUS_DOWN);
    }
}