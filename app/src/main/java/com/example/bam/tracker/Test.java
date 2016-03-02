package com.example.bam.tracker;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by bhavesh on 01/03/2016.
 */
public class Test extends AppCompatActivity {

    TextView v;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_test);
        v = (TextView)findViewById(R.id.data);
        LocationManager locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        mylocation loc = new mylocation();
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,loc);
    }

    class mylocation implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            location.getLatitude();
            location.getLongitude();
            String locations = "Long" + location.getLongitude() + "lat" + location.getLatitude();
            v.setText(locations);
            Toast.makeText(getApplicationContext(), "LocationInterface" + locations, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    }
}
