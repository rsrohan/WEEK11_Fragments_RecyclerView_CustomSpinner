package com.example.week11_fragments_recyclerview_customspinner.ques1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.week11_fragments_recyclerview_customspinner.R;

public class FruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        ImageView imageView = findViewById(R.id.image);
        TextView textView = findViewById(R.id.name);

        imageView.setImageResource(getIntent().getIntExtra("image", R.drawable.image1));

        textView.setText(getIntent().getStringExtra("name"));
    }
}
