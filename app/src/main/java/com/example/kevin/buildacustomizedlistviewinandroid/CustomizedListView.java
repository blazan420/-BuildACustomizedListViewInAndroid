package com.example.kevin.buildacustomizedlistviewinandroid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomizedListView extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;

    int[] animalImages = {R.drawable.bear, R.drawable.bird, R.drawable.cat, R.drawable.cow, R.drawable.dolphin, R.drawable.fish, R.drawable.fox,
            R.drawable.horse, R.drawable.lion, R.drawable.tiger};
    String[] animalNames = {"Bear", "Bird", "Cat", "Cow", "Dolphin", "Fish", "Fox", "Horse", "Lion", "Tiger"};
    int[] animalsPower = {200, 20, 50, 150, 50, 10, 70, 400, 250, 220};
    int[] animalsSpeed = {50, 80, 60, 10, 50, 40, 80, 350, 200, 100};

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
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = layoutInflater.inflate(R.layout.customized_list_view, null);

        ImageView imgAnimal = (ImageView) view.findViewById(R.id.imgAnimal);
        final TextView txtAnimalName = (TextView) view.findViewById(R.id.txtAnimalName);
        final TextView txtAnimalPowerValue = (TextView) view.findViewById(R.id.txtAnimalPower);
        final TextView txtAnimalSpeedValue = (TextView) view.findViewById(R.id.txtAnimalSpeed);

        String oldTxtAnimalNameValue = txtAnimalName.getText().toString();
        String oldTxtAnimalPowerValue = txtAnimalPowerValue.getText().toString();
        String oldTxtAnimalSpeedValue = txtAnimalSpeedValue.getText().toString();

        //imgAnimal.setImageResource(animalImages[position]);

        /*final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), animalImages[position],
                options);
        imgAnimal.setImageBitmap(bm);*/

        imgAnimal.setImageBitmap(decodeSampledBitmapFromResource(context.getResources(),
                animalImages[position], 30, 30));

        txtAnimalName.setText(oldTxtAnimalNameValue + animalNames[position]);
        txtAnimalPowerValue.setText(oldTxtAnimalPowerValue + animalsPower[position]);
        txtAnimalSpeedValue.setText(oldTxtAnimalSpeedValue + animalsSpeed[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, txtAnimalName.getText() + "\n" + txtAnimalPowerValue.getText() + "\n" +
                        txtAnimalSpeedValue.getText(), Toast.LENGTH_LONG).show();

            }
        });


        return view;
    }


    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

}


