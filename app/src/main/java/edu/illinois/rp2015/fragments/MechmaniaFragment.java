package edu.illinois.rp2015.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.illinois.rp2015.R;

public class MechmaniaFragment extends Fragment {

    public MechmaniaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mechmania, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
//        TextView text = (TextView) getActivity().findViewById(R.id.txtBody1);
//        text.setText(Html.fromHtml("<span class=\"center\">&lt;INCOMING TRANSMISSION&gt;</span>\n" +
//                "                        <br>\n" +
//                "                        Hello cybercommander!\n" +
//                "                        <br><br>\n" +
//                "                        The 21st annual Military Electronic Combat Hardware Training Competition (Mechmania) is fast approaching! The competition ranks cyberwarriors by pitting them against each other in a simulated cyber-warfare environment. However, there is one major catch – since the United Nations Network Security Agency (UN-NSA) deems it too dangerous for human cyberwarriors to participate, they have instructed you to build a computer program to do so instead!\n" +
//                "                        <br><br>\n" +
//                "                        Should you accept this mission, you and up to 3 friends will have 24 hours to build, test, and deploy your automatic cyberwarriors against the world’s finest cybercommanders. The UN-NSA will provide meals and snacks to all participants as well as prizes for the best performances.\n" +
//                "                        <br>\n" +
//                "                        Good luck, cybercommander. You’ll need it out there.\n" +
//                "                        <br><br>\n" +
//                "                        <span class=\"center\">&lt;END TRANSMISSION&gt;</span>"));
        super.onCreate(savedInstanceState);
    }
}