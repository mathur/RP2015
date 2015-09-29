package edu.illinois.rp2015.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import edu.illinois.rp2015.R;

public class MapsAdapter extends ArrayAdapter<Integer> {

    Context context;
    int layoutResourceId;
    List<Integer> data = null;

    public MapsAdapter(Context context, int layoutResourceId, List<Integer> data) {
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
            holder.title = (TextView) row.findViewById(R.id.txtMapTitle);
            holder.map = (ImageView) row.findViewById(R.id.mapIV);


            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

 //       Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), data.get(position));


        try {
            holder.map.setImageDrawable(getContext().getResources().getDrawable(data.get(position), null));
        }
        catch(java.lang.OutOfMemoryError e){
            Log.e("MapsAdapter", e.toString());
            Toast.makeText(getContext(), "Not enough memory to show map", Toast.LENGTH_SHORT).show();
        }

        if(position == 0){
            holder.title.setText("Startup Fair Map");
        }
        else{
            holder.title.setText("Job Fair Map");
        }

        return row;
    }

    static class ViewHolder
    {
        TextView title;
        ImageView map;
    }
}