package com.MrMUB.androidutils;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

import com.MrMUB.androidutilities.MUB_GetFileFromAssets;
import com.MrMUB.androidutilities.MUB_PhotoMerge;

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
        Bitmap background = new MUB_GetFileFromAssets(this).setAssetName("picture1.jpg").toBitmap();
        Bitmap forground = new MUB_GetFileFromAssets(this).setAssetName("minion1.png").toBitmap();

        String filePath = new MUB_PhotoMerge(this)
                .setBackgroundPhoto(background)
                .setForegroundPhoto(forground)
                .setPosition(200,500)
                .Save();

        Log.i(LOG,"FilePath: "+filePath);

    }


}
