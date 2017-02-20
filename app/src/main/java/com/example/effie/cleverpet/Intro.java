package com.example.effie.cleverpet;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import stanford.androidlib.SimpleActivity;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Intro extends SimpleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        $ET(R.id.url).setText("twitter.com/");
    }

    private static final int REQ_CODE_PHOTO_GALLERY = 30211;  // 1-65535
    private static int REQ_CODE_URL = 1234;


    public void permissionClick(View view) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == REQ_CODE_PHOTO_GALLERY && resultCode == RESULT_OK) {
            Uri targetUri = intent.getData();   // location of photo file
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(
                        getContentResolver().openInputStream(targetUri));
            } catch (FileNotFoundException fnfe) {
                Log.wtf("onActivityResult", fnfe);
            }
        }
    }

    public void urlClick(View view) {
        Intent intent = new Intent(this, PetInfo.class);
        //System.out.println("url: "+$ET(R.id.url).getText().toString());
        String URL = "https://www." + $ET(R.id.url).getText().toString();
        startActivityForResult(PetInfo.class, REQ_CODE_URL, "URL", URL);
        //startActivityForResult(PetInfo.class, REQ_CODE_URL, "URL", $ET(R.id.url).getText());
        toast("Tweets analyzed!");
    }
}
