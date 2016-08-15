package com.commit451.pixeladjustor.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.commit451.pixeladjustor.PixelAdjustor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, PixelAdjustor.fromJni(), Toast.LENGTH_SHORT).show();
    }




}
