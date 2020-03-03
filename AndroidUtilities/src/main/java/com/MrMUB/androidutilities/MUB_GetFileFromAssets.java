package com.MrMUB.androidutilities;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class MUB_GetFileFromAssets {

    Context context;
    String assetName;

    String LOG = "MUB_GetFileFromAssets";

    public MUB_GetFileFromAssets(Context context){
        this.context = context;
    }

    public MUB_GetFileFromAssets setAssetName(String assetName ){
        this.assetName = assetName;
        return this;
    }

    public InputStream toInputStream(){
        AssetManager assetManager = context.getAssets();
        InputStream istr;
        try {
            istr = assetManager.open(assetName);
            return istr;
        } catch (IOException e) {
            Log.e(LOG,e.getMessage());
            return null;
        }
    }

    public Bitmap toBitmap(){
        AssetManager assetManager = context.getAssets();

        InputStream istr;
        Bitmap bitmap = null;
        try {
            istr = assetManager.open(assetName);
            bitmap = BitmapFactory.decodeStream(istr);
            return bitmap;
        } catch (IOException e) {
            Log.e(LOG,e.getMessage());
            return null;
        }
    }
}
