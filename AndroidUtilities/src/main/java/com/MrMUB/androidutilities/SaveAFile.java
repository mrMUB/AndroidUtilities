package com.MrMUB.androidutilities;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

public class SaveAFile {

    private String path = Environment.getExternalStorageDirectory().toString();
    private String fileName = new GenerateChar().setSize(32).generate();
    private Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
    private int imageQuality = 75;
    private Bitmap bitmapFile = null;

    String LOG = "SaveAFile";

    public SaveAFile setCustomPath(String path){
        this.path = path;
        return this;
    }

    public SaveAFile setFileName(String fileName){
        this.fileName = fileName;
        return this;
    }

    public SaveAFile setBitmap(Bitmap bitmapFile){
        this.bitmapFile = bitmapFile;
        return this;
    }

    public SaveAFile setCompressFormat(Bitmap.CompressFormat compressFormat){
        this.compressFormat = compressFormat;
        return this;
    }

    public SaveAFile setImageQuality(int imageQuality){
        this.imageQuality = imageQuality;
        return this;
    }


    public String BitmapToImage(){

        if(bitmapFile == null){
            Log.e(LOG, "Bitmap is empty, set bitmap by calling 'setBitmap'.");
            return null;
        }

        File myDir = new File(path);
        myDir.mkdirs();
        String fname = "/"+fileName+".jpg";
        File file = new File(myDir, fname);
        if (file.exists()) {
            file.delete();
            Log.w(LOG, "File existed, deleting the old file.");
        }
        Log.i(LOG, "Saving the file to: "+path + fname);
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmapFile.compress(compressFormat, imageQuality, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            Log.e(LOG, e.getMessage());
            e.printStackTrace();
        }
        return path + fname;

    }
}
