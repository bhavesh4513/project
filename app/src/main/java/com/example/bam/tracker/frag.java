package com.example.bam.tracker;

import android.app.Fragment;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by bhavesh on 02/03/2016.
 */
public class frag extends Fragment {

    TextView v;
    Button b;
    Double lat,lon;

    LocationInterface dataPasser;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        b=(Button)getActivity().findViewById(R.id.location);
        v = (TextView) getActivity().findViewById(R.id.data);
        dataPasser=(LocationInterface)getActivity();
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        loc l = new loc();
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, l);



    }




    public class loc implements LocationListener {


        @Override
        public void onLocationChanged(android.location.Location location) {
            lat=location.getLatitude();
            lon=location.getLongitude();
            dataPasser.update(lat,lon);
            String locations = "Long" +lat + "lat" + "long"+lon;
            Toast.makeText(getActivity(), "LocationInterface" + locations, Toast.LENGTH_SHORT).show();
            ArrayList<Double> al = new ArrayList<>();
            al.add(lat);
            al.add(lon);
            new CommonAsync(this).execute((Runnable) al);


        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }
}
