package com.arjun.sprint2;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class list extends AppCompatActivity {
    String S;
    ListView lv;


    final int maxResult = 5;
    String addressList[] = new String[maxResult];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lv = (ListView) findViewById(R.id.listView);


        final MyLocationListner MyLocationListener = new MyLocationListner();


        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 0, MyLocationListener);
        locationManager.requestLocationUpdates(locationManager.NETWORK_PROVIDER,0,0,MyLocationListener);

                try {
                    Geocoder geo = new Geocoder(list.this, Locale.getDefault());

                    List<Address> addresses = geo.getFromLocation(MyLocationListner.latitude, MyLocationListner.longitude, maxResult);
                    Toast.makeText(list.this, +MyLocationListner.latitude+MyLocationListner.longitude+ "", Toast.LENGTH_SHORT).show();
                    if(addresses != null&&addresses.size()>0) {
                        for (int j=0; j<maxResult; j++){
                            Address address= addresses.get(j);
                            StringBuilder sb = new StringBuilder();

                            for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {

                                sb.append(address.getAddressLine(i)).append("\n");
                            }
                            addressList[j] = sb.toString();
                        }

                        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.activity_customlist,R.id.tv1, addressList);
                        lv.setAdapter(adapter);
                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                String ad = (String) lv.getItemAtPosition(i).toString();

                                Intent p = new Intent(list.this,Post.class);
                                p.putExtra("addr",ad);
                                startActivity(p);
                            }
                        });

                    }
                    else{
                        Toast.makeText(list.this, "No Address returned!", Toast.LENGTH_SHORT).show();

                    }
                } catch (IOException e) {
                    Log.e(S, "Unable to connect");
                }




    }
          }

