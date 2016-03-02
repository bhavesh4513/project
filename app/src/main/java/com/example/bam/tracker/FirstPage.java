package com.example.bam.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by bhavesh on 02/03/2016.
 */
public class FirstPage extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

    }
    public void Next(View view)
    {
        Intent i = new Intent(getApplicationContext(),ChildLogin.class);
        startActivity(i);

    }
    public void Child(View view )
    {
        Intent log = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(log);

    }
}
