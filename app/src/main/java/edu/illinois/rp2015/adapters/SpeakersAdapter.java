package edu.illinois.rp2015.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.List;

import edu.illinois.rp2015.R;

public class SpeakersAdapter extends ArrayAdapter<ParseObject> {

    Context context;
    int layoutResourceId;
    List<ParseObject> data = null;

    public SpeakersAdapter(Context context, int layoutResourceId, List<ParseObject> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ViewHolder();
            holder.speaker = (TextView) row.findViewById(R.id.txtName);
            holder.talk = (TextView) row.findViewById(R.id.txtTalk);
            holder.talkTitle = (TextView) row.findViewById(R.id.txtTalkTitle);
            holder.bio = (TextView) row.findViewById(R.id.txtBio);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ParseObject event = data.get(position);
        if (event != null) {
            holder.speaker.setText(event.getString("Speaker"));
            String talkTitle = event.getString("TalkTitle");
            if(talkTitle == null) talkTitle = "";
            holder.talkTitle.setText("Talk: " + talkTitle);
            holder.talk.setText(event.getString("Talk"));
            holder.bio.setText(event.getString("Bio"));
        }

        return row;
    }

    static class ViewHolder
    {
        TextView speaker;
        TextView talkTitle;
        TextView talk;
        TextView bio;
    }
}