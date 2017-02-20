package com.example.effie.cleverpet;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

import stanford.androidlib.SimpleActivity;

public class MainActivity extends SimpleActivity {

    public ArrayList<String> pictures = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //$IV(R.id.dog_pic).setImageDrawable(get(R.drawable.dog));
    }

    public void findDogClick(View view) {//        Intent picIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(picIntent, REQ_CODE_PHOTO_GALLERY);
        File picturesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

//        Log.d("Intro", picturesDir.toString());
//        Log.d("Intro", Boolean.toString(picturesDir.canExecute()));
//        Log.d("Intro", Boolean.toString(picturesDir.canRead()));
//        Log.d("Intro", Boolean.toString(picturesDir.isDirectory()));
//        Log.d("Intro", Boolean.toString(picturesDir.exists()));

        listFiles(picturesDir);
        toast("Pictures analyzed!");
        Intent intent = new Intent(this, Intro.class);
        startActivity(intent);
    }

    public void listFiles(File picturesDir) {
        String[] pictureString = picturesDir.list();
        File[] files = picturesDir.listFiles();

        if (pictureString != null) {
            Log.d("Intro", Integer.toString(pictureString.length));
            for (int i = 0; i < pictureString.length; i++) {
                if (files[i].isDirectory()) {
                    Log.d("Intro", pictureString[i]);
                    listFiles(files[i]);
                } else {
                    Log.d("Intro", pictureString[i]);
                    pictures.add(pictureString[i]);
                }
            }
        }
    }
}
