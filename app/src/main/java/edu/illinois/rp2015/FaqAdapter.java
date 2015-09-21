package edu.illinois.rp2015;

import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.List;

public class FaqAdapter extends ArrayAdapter<ParseObject> {

    Context context;
    int layoutResourceId;
    List<ParseObject> data = null;

    public FaqAdapter(Context context, int layoutResourceId, List<ParseObject> data) {
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
            holder.question = (TextView) row.findViewById(R.id.txtQuestion);
            holder.answer = (TextView) row.findViewById(R.id.txtAnswer);

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        ParseObject event = data.get(position);
        if (event != null) {
            holder.question.setText(Html.fromHtml(event.getString("Question")));
//            holder.answer.setText(event.getString("Answer"));
            holder.answer.setText(Html.fromHtml(event.getString("Answer")));
            holder.answer.setMovementMethod(LinkMovementMethod.getInstance());
        }

        return row;
    }

    static class ViewHolder
    {
        TextView question;
        TextView answer;
    }
}