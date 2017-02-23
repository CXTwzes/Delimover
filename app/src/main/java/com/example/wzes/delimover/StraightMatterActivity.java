package com.example.wzes.delimover;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class StraightMatterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_straight_matter);
    }

    //On click of back image, go back to select activity
    public void backOnClick(View view) {
        Intent intent = new Intent(this, SelectActivity.class);
        startActivity(intent);
    }

    //On click of transmit image, start the transmit activity
    public void transmitOnClick(View view) {
        Intent intent = new Intent(this, TransmitActivity.class);
        startActivity(intent);
    }
}
