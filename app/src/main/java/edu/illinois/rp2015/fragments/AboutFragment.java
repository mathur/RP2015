package edu.illinois.rp2015.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import edu.illinois.rp2015.R;

public class AboutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about_fragment,container,false);

        final ScrollView scrollView = (ScrollView) v.findViewById(R.id.aboutScroll);

        TextView startupFair = (TextView) v.findViewById(R.id.startupFairTV);
        TextView careerFair = (TextView) v.findViewById(R.id.careerFairTV);
        TextView mechmania = (TextView) v.findViewById(R.id.mechmaniaTV);
        TextView puzzlebang = (TextView) v.findViewById(R.id.puzzlebangTV);
        TextView projects = (TextView) v.findViewById(R.id.projectsTV);

        showInitialFragment();

        startupFair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                StartupFairFragment startupFairFragment = new StartupFairFragment();
                fragmentTransaction.replace(R.id.learnMore, startupFairFragment);
                fragmentTransaction.commit();
            }
        });

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


        puzzlebang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                PuzzlebangFragment puzzlebangFragment = new PuzzlebangFragment();
                fragmentTransaction.replace(R.id.learnMore, puzzlebangFragment);
                fragmentTransaction.commit();
            }
        });

        projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ProjectsFragment projectsFragment = new ProjectsFragment();
                fragmentTransaction.replace(R.id.learnMore, projectsFragment);
                fragmentTransaction.commit();
            }
        });

        return v;
    }

    public void showInitialFragment(){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        StartupFairFragment startupFairFragment = new StartupFairFragment();
        fragmentTransaction.replace(R.id.learnMore, startupFairFragment);
        fragmentTransaction.commit();
    }
}