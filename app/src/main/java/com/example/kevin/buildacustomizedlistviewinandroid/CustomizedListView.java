package com.example.kevin.buildacustomizedlistviewinandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class CustomizedListView extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;

    int[] animalImages = { R.drawable.bear, R.drawable.bird, R.drawable.cat, R.drawable.cow, R.drawable.dolphin, R.drawable.fish, R.drawable.fox,
            R.drawable.horse, R.drawable.lion, R.drawable.tiger};
    String[] animalNames = {"Bear", "Bird", "Cat", "Cow", "Dolphin", "Fish", "Fox", "Horse", "Lion", "Tiger"};
    int[] animalsPower = {200, 20, 50, 150, 50, 10, 70, 400, 250, 220 };
    int[] animalsSpeed = {50, 80, 60, 10, 50, 40, 80, 350, 200, 100 };

    //Constructor
    public CustomizedListView(Context context) {

        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return animalImages.length;
    }

    @Override
    public Object getItem(int position) {
        return animalImages[position];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
