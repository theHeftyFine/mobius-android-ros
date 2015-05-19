package com.example.hayo.rostopics;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final List<String> values;

    public MyArrayAdapter(Context context, List<String> values) {
        super(context, R.layout.topics_list_item,values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.topics_list_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.secondLine);
        TextView scoreView = (TextView) rowView.findViewById(R.id.score);
        TextView mainText = (TextView) rowView.findViewById(R.id.firstLine);
        scoreView.setText(String.valueOf(values.get(position).length()));
        if(values.get(position).length()>4) scoreView.setTextColor(Color.RED);
        textView.setText(values.get(position).getBytes().toString());
        mainText.setText(values.get(position));


        return rowView;
    }
}