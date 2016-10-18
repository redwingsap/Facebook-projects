package com.arjun.sprint2;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

/**
 * Created by Arjun on 11-10-2016.
 */
public class MyLocationListner implements LocationListener{
    public static double latitude,longitude;
    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();

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
