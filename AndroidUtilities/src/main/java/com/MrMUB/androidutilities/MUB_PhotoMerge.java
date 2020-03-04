package com.MrMUB.androidutilities;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

public class MUB_PhotoMerge {

    Activity activity;
    Bitmap BackgroundPhoto;
    Bitmap ForegroundPhoto;
    Bitmap Result = null;

    public MUB_PhotoMerge(Activity activity){
        this.activity = activity;
    }

    public MUB_PhotoMerge setBackgroundPhoto(Bitmap BackgroundPhoto){
        this.BackgroundPhoto = BackgroundPhoto;
        return this;
    }

    public MUB_PhotoMerge setForegroundPhoto(Bitmap ForegroundPhoto){
        this.ForegroundPhoto = ForegroundPhoto;
        return this;
    }


    public MUB_PhotoMerge setPosition(float left, float top){

        Result = Bitmap.createBitmap(BackgroundPhoto.getWidth(), BackgroundPhoto.getHeight(), BackgroundPhoto.getConfig());
        Canvas canvas = new Canvas(Result);
        canvas.drawBitmap(BackgroundPhoto, new Matrix(), null);
        canvas.drawBitmap(ForegroundPhoto, left, top, null);

        return this;
    }

    public Bitmap toBitmap(){
        return Result;
    }

    public String Save() {
        return new MUB_SaveAFile()
                .setBitmap(Result)
                .BitmapToImage();
    }

}
