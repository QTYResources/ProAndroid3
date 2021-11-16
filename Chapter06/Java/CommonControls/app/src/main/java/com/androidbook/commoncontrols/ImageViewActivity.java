package com.androidbook.commoncontrols;

import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.ComponentActivity;

public class ImageViewActivity extends ComponentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview);

        ImageView imgView = (ImageView) findViewById(R.id.image3);

        imgView.setImageResource(R.drawable.icon);

        imgView.setImageBitmap(BitmapFactory.decodeResource(
                this.getResources(), R.drawable.manatee14));

        imgView.setImageDrawable(
                Drawable.createFromPath("/mnt/sdcard/dave2.jpg"));

        imgView.setImageURI(Uri.parse("file://mnt/sdcard/dave2.jpg"));
    }
}
