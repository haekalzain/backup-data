package com.example.viewerpdf;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

import static com.example.viewerpdf.pdf1.checkImageOnDirectory;

public class pdf2 extends AppCompatActivity {
    PDFView pdfView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);
        pdfView2=findViewById(R.id.pdfview2);
//        pdfView2.fromAsset("pdf2.pdf").load();
        File file = checkImageOnDirectory("pdf2.pdf","DAYA");
        pdfView2.fromFile(file).load();
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
//    private void (){
//        // Create a MediaSessionCompat
//       MediaSessionCompat mediaSession = new MediaSessionCompat(this, "a");
//
//        // Enable callbacks from MediaButtons and TransportControls
//        mediaSession.setFlags(
//                MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS |
//                        MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS);
//
//        // Do not let MediaButtons restart the player when the app is not visible
//        mediaSession.setMediaButtonReceiver(null);
//
//        // Set an initial PlaybackState with ACTION_PLAY, so media buttons can start the player
//        PlaybackStateCompat.Builder stateBuilder = new PlaybackStateCompat.Builder()
//                .setActions(
//                        PlaybackStateCompat.ACTION_PLAY |
//                                PlaybackStateCompat.ACTION_PLAY_PAUSE);
//        mediaSession.setPlaybackState(stateBuilder.build());
//
//        // MySessionCallback has methods that handle callbacks from a media controller
//      //  mediaSession.setCallback(new MySessionCallback());
//
//        // Create a MediaControllerCompat
//        MediaControllerCompat mediaController =
//                new MediaControllerCompat(this, mediaSession);
//
//        MediaControllerCompat.setMediaController(this, mediaController);
//    }
//    }
}

