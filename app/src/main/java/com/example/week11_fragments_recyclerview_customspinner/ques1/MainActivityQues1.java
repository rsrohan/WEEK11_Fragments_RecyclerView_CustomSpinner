package com.example.week11_fragments_recyclerview_customspinner.ques1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.week11_fragments_recyclerview_customspinner.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityQues1 extends AppCompatActivity {
    public static final String[] titles = new String[] { "Apple",
            "Banana", "Strawberry", "Mango", "Grapes" };

    public static final Integer[] images = { R.drawable.image1,
            R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5 };

    Spinner spinner;
    List<FruitItem> fruitItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ques1);
        fruitItems = new ArrayList<FruitItem>();
        for (int i = 0; i < titles.length; i++) {

            FruitItem item = new FruitItem(titles[i],images[i]);
            fruitItems.add(item);
        }

        spinner = (Spinner)findViewById(R.id.spinner);
        CustomAdapter adapter = new CustomAdapter(this,
                R.layout.listitems_layout, R.id.title, fruitItems);
        spinner.setAdapter(adapter);
    }
    public class CustomAdapter extends ArrayAdapter<FruitItem> {

        LayoutInflater flater;

        public CustomAdapter(Activity context, int resourceId, int textViewId, List<FruitItem> list){

            super(context,resourceId,textViewId, list);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            return rowview(convertView,position);
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return rowview(convertView,position);
        }

        private View rowview(View convertView , final int position){

            final FruitItem FruitItem = getItem(position);

            viewHolder holder ;
            View rowview = convertView;
            if (rowview==null) {

                holder = new viewHolder();
                flater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                rowview = flater.inflate(R.layout.listitems_layout, null, false);

                holder.txtTitle = (TextView) rowview.findViewById(R.id.text);
                holder.imageView = (ImageView) rowview.findViewById(R.id.image);
                rowview.setTag(holder);
            }else{
                holder = (viewHolder) rowview.getTag();
            }
            holder.imageView.setImageResource((FruitItem.getImage()));
            holder.txtTitle.setText(FruitItem.getName());
            rowview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), FruitActivity.class).putExtra("image", FruitItem.getImage()).putExtra("name", FruitItem.getName()+" at position "+position));
                }
            });

            return rowview;
        }

        private class viewHolder{
            TextView txtTitle;
            ImageView imageView;
        }
    }
}
