package com.example.viewerpdf;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;
import java.net.URI;

public class pdf1 extends AppCompatActivity {
    PDFView pdfView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf1);

        pdfView1=findViewById(R.id.pdfview1);

//        pdfView1.fromAsset("Javascript.pdf").load();
        File file= checkImageOnDirectory("Javascript.pdf","DAYA");
        pdfView1.fromFile(file).load();
    }
    @Nullable
    public static File checkImageOnDirectory(String bitmapName, String photoType) {
        if (bitmapName == null || bitmapName.isEmpty()) {
            return null;
        }

        String path = Environment.getExternalStorageDirectory() + "/PRS/"+photoType;
        File myDir = new File(path);
        if (!myDir.exists()) {
            myDir.mkdirs();
        }
        File file = new File(myDir, bitmapName);
        return file;
    }
}
