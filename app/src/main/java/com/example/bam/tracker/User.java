package com.example.bam.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by bhavesh on 29/02/2016.
 */
public class User extends ActionBarActivity{
    TextView vw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        vw = (TextView)findViewById(R.id.textView);
       

    }
    public void onClick_track(View view)
    {
        Intent onClick_track = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(onClick_track);

    }




}
