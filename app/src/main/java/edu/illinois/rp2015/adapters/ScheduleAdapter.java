package edu.illinois.rp2015.adapters;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.illinois.rp2015.MainActivity;
import edu.illinois.rp2015.R;

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
            if(MainActivity.width!=0){
                holder.time.setWidth((int) (MainActivity.width/3.5));
            }

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ParseObject event = data.get(position);
        if (event != null) {
            Date date = event.getDate("StartTime");
            String AM_PM;
            int hours = date.getHours();
            if(hours == 0){
                hours = 12;
                AM_PM = "AM";
            }
            else if(hours < 12){
                AM_PM = "AM";
            }
            else if(hours == 12){
                AM_PM = "PM";
            }
            else{
                hours = hours - 12;
                AM_PM = "PM";
            }

            String minutes = String.format("%02d", date.getMinutes());
            String time = date.getMonth() + 1 + "/" + date.getDate() + " " + hours + ":" + minutes + " " + AM_PM;
            //holder.time.setText(event.getDate("StartTime").toString());
            holder.time.setText(time);
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