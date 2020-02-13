package com.example.viewerpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Arrays;

public class VideoActivity extends AppCompatActivity {
    VideoView videoView;
//    ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"));
//
//    int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoview);
        Uri uri = Uri.parse(Environment.getExternalStorageDirectory().getAbsolutePath()+"/PRS/DAYA/video.mp4");
        videoView.setVideoURI(uri);
//        videoView.start();
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);


//        final MediaController mediacontroller = new MediaController(this);
//        mediacontroller.setAnchorView(videoView);
//
//
//        videoView.setMediaController(mediacontroller);
//        videoView.setVideoURI(Uri.parse(arrayList.get(index)));
//        videoView.requestFocus();
//
//        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                Toast.makeText(getApplicationContext(), "Video over", Toast.LENGTH_SHORT).show();
//                if (index++ == arrayList.size()) {
//                    index = 0;
//                    mp.release();
//                    Toast.makeText(getApplicationContext(), "Video over", Toast.LENGTH_SHORT).show();
//                } else {
//                    videoView.setVideoURI(Uri.parse(arrayList.get(index)));
//                    videoView.start();
//                }
//
//
//            }
//        });
//
//        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
//            @Override
//            public boolean onError(MediaPlayer mp, int what, int extra) {
//                Log.d("API123", "What " + what + " extra " + extra);
//                return false;
//            }
//        });
    }
}

