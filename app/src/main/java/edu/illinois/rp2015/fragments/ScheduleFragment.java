package edu.illinois.rp2015.fragments;

import android.content.Context;
import android.os.Bundle;
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

import java.util.List;

import edu.illinois.rp2015.R;
import edu.illinois.rp2015.adapters.ScheduleAdapter;

public class ScheduleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.schedule_fragment, container, false);
        final ListView scheduleList = (ListView) v.findViewById(R.id.lstSchedule);
        final Context context = getActivity();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Events");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> events, ParseException e) {
                if (e == null) {
                    ScheduleAdapter adapter = new ScheduleAdapter(context, R.layout.schedule_item_list, events);
                    scheduleList.setAdapter(adapter);
                } else {
                    Log.e("Error", e.getMessage());
                }
            }
        });

        return v;
    }
}
