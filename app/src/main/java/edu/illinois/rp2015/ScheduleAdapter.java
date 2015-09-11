package edu.illinois.rp2015;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.List;

public class ScheduleAdapter extends ArrayAdapter<ParseObject> {

    Context context;
    int layoutResourceId;
    List<ParseObject> data = null;

    public ScheduleAdapter(Context context, int layoutResourceId, List<ParseObject> data) {
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
            holder.time = (TextView) row.findViewById(R.id.txtTime);
            holder.name = (TextView) row.findViewById(R.id.txtName);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ParseObject event = data.get(position);
        if (event != null) {
            holder.time.setText(event.getDate("StartTime").toString());
            holder.name.setText(event.getString("Name"));
        }

        return row;
    }

    static class ViewHolder
    {
        TextView time;
        TextView name;
    }
}