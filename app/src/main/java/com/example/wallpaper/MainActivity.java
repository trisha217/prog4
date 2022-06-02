package com.example.wallpaper;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer myTimer;
    Button btn;
    WallpaperManager wpm;
    Drawable drawable;
    int image=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTimer = new Timer();
        wpm = WallpaperManager.getInstance(this);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeWallpaper();
            }

            private void changeWallpaper() {
                myTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (image==1) {
                            drawable=getResources().getDrawable(R.drawable.img1);
                            image=2;
                        } else if (image==2){
                            drawable=getResources().getDrawable(R.drawable.img3);
                            image=1;
                        }
                        Bitmap wallpaper = ((BitmapDrawable)drawable).getBitmap();
                        try {
                            wpm.setBitmap(wallpaper);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },0,3000);
            }
        });
    }
}