package com.commit451.pixeladjustor.sample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.commit451.pixeladjustor.PixelAdjustor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inMutable = true;
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.ic_print_white_48dp, opts);

        ImageView imageView = (ImageView) findViewById(R.id.image);

        JavaPixelAdjustor.decodeWithColorReplaced(image, Color.WHITE, Color.MAGENTA);

        imageView.setImageBitmap(image);

        ImageView nativeImageView = (ImageView) findViewById(R.id.natively_processed_image);

        Bitmap image2 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_print_white_48dp, opts);

        PixelAdjustor.adjustBitmap(image2, Color.WHITE, Color.MAGENTA);

        nativeImageView.setImageBitmap(image2);
    }




}
