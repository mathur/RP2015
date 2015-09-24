package edu.illinois.rp2015.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.illinois.rp2015.R;

public class AboutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about_fragment,container,false);

        TextView careerFair = (TextView) v.findViewById(R.id.careerFairTV);
        TextView mechmania = (TextView) v.findViewById(R.id.mechmaniaTV);

        careerFair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                CareerFairFragment careerFairFragment = new CareerFairFragment();
                fragmentTransaction.replace(R.id.learnMore, careerFairFragment);
                fragmentTransaction.commit();
            }
        });

        mechmania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MechmaniaFragment mechmaniaFragment = new MechmaniaFragment();
                fragmentTransaction.replace(R.id.learnMore, mechmaniaFragment);
                fragmentTransaction.commit();
            }
        });

        return v;
    }
}