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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.illinois.rp2015.adapters.FaqAdapter;
import edu.illinois.rp2015.R;

public class FAQFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.faq_fragment,container,false);
        getActivity().getWindow().addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        final ListView faqList = (ListView) v.findViewById(R.id.lstFAQ);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("FAQ");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> events, ParseException e) {
                if (e == null) {
                    FaqAdapter adapter = new FaqAdapter(getActivity(), R.layout.faq_item_list, events);
                    faqList.setAdapter(adapter);
                } else {
                    Log.e("Error", e.getMessage());
                }
            }
        });
        return v;
    }
}
