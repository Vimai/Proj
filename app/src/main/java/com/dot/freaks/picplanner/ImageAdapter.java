package com.dot.freaks.picplanner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Tulio on 23/04/2015.
 */
public class ImageAdapter extends BaseAdapter{
    private Context cont;
    public Integer[] fotos = {R.drawable.pic_1, R.drawable.pic_2,
            R.drawable.pic_3, R.drawable.pic_4,
            R.drawable.pic_5, R.drawable.pic_6,
            R.drawable.pic_7, R.drawable.pic_8,
            R.drawable.pic_9, R.drawable.pic_10,
            R.drawable.pic_11, R.drawable.pic_12,
            R.drawable.pic_13, R.drawable.pic_14,
            R.drawable.pic_15
    };

    public ImageAdapter(Context c){
        cont = c;
    }
    public int getCount(){
        return fotos.length;
    }
    public Object getItem(int Position){
        return fotos[Position];
    }
    public long getItemId(int Position){
        return 0;
    }
    public View getView(int Position, View convertView, ViewGroup Parent){
        ImageView image = new ImageView(cont);
        image.setImageResource(fotos[Position]);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setLayoutParams(new GridView.LayoutParams(70, 70));
        return image;
    }

}
