package com.MrMUB.androidutils;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.MrMUB.androidutilities.GetFileFromAssets;
import com.MrMUB.androidutilities.PhotoMerge;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    String LOG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExecuteSamples();

    }


    public void ExecuteSamples(){

        photoMerge();

    }


    public void photoMerge(){
        Bitmap background = new GetFileFromAssets(this).setAssetName("picture1.jpg").toBitmap();
        Bitmap forground = new GetFileFromAssets(this).setAssetName("minion1.png").toBitmap();

        String filePath = new PhotoMerge(this)
                .setBackgroundPhoto(background)
                .setForegroundPhoto(forground)
                .setPosition(200,500)
                .Save();

        Log.i(LOG,"FilePath: "+filePath);

    }


}
