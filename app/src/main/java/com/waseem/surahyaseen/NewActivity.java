package com.waseem.surahyaseen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import app.num.numandroidpagecurleffect.PageCurlView;

public class NewActivity extends AppCompatActivity {
    PageCurlView pageCurlView;
    List<Integer> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        pageCurlView=findViewById(R.id.pageCurlView);
        pageCurlView.IsCurlModeDynamic();

        imageList = new ArrayList<>();
        imageList.add(R.drawable.one);
        imageList.add(R.drawable.five);
        imageList.add(R.drawable.four);
        imageList.add(R.drawable.three);
        imageList.add(R.drawable.two);


        pageCurlView.setCurlView(imageList);
        pageCurlView.setCurlSpeed(150);


    }
}