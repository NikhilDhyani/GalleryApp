package com.example.nikhil.glide_gallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class Focus_Activity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_);

        textView = findViewById(R.id.f_tvid);
        imageView = findViewById(R.id.f_thumbnail);


          //Receive Data

        Intent intent = getIntent();

        String Title =  intent.getExtras().getString("Title");
        String Url =  intent.getExtras().getString("Photo");


      //Setting values

        textView.setText(Title);


        Glide.with(getApplicationContext()).load(Url)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
}
