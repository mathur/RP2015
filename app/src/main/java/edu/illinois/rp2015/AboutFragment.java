package edu.illinois.rp2015;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AboutFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about_fragment,container,false);

        TextView careerFair = (TextView) v.findViewById(R.id.textView4);
        careerFair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                AboutModalFragment aboutModalFragment = new AboutModalFragment();
                fragmentTransaction.add(R.id.outerFrame, aboutModalFragment);
                fragmentTransaction.commit();
            }
        });

        return v;
    }
}