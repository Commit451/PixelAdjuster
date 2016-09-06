package com.commit451.pixeladjustor.sample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.commit451.pixeladjuster.PixelAdjuster;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inMutable = true;
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.horizon, opts);

        ImageView imageView = (ImageView) findViewById(R.id.image);

        long startTime = System.currentTimeMillis();
        JavaPixelAdjuster.adjustColor(image, Color.WHITE, Color.MAGENTA);

        Log.d("TIMER", "Java Time taken: " + (System.currentTimeMillis() - startTime) + " ms");
        imageView.setImageBitmap(image);

        ImageView nativeImageView = (ImageView) findViewById(R.id.natively_processed_image);

        Bitmap image2 = BitmapFactory.decodeResource(getResources(), R.drawable.horizon, opts);

        startTime = System.currentTimeMillis();
        PixelAdjuster.adjustColor(image2, Color.WHITE, Color.MAGENTA);
        Log.d("TIMER", "Native Time taken: " + (System.currentTimeMillis() - startTime) + " ms");
        nativeImageView.setImageBitmap(image2);
    }




}
