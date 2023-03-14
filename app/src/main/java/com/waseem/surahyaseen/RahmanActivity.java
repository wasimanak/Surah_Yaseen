package com.waseem.surahyaseen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class RahmanActivity extends AppCompatActivity {
    PDFView pdfViewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);



        pdfViewer=findViewById(R.id.pdfviewer);
        pdfViewer.fromAsset("Rahman.pdf")
                .defaultPage(0)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(2)
                .enableDoubletap(false)
                .onTap(null)
                .load();




    }
}