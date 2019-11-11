package com.example.listviewtest;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceID;
    public FruitAdapter(Context context, int textViewResourceID, List<Fruit> objects){
        super(context, textViewResourceID, objects);
        resourceID = textViewResourceID;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Fruit fruit = getItem(position);//获取当前的fruit实例
        View view;
        ViewHolder viewHolder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceID, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = view.findViewById(R.id.fruit_image);
            viewHolder.textView = view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }
        else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(fruit.getImageID());
        viewHolder.textView.setText(fruit.getName());
        return view;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }

}
