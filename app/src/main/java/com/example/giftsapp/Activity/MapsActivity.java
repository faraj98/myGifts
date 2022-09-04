package com.example.giftsapp.Activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.giftsapp.R;
import com.example.giftsapp.adapters.MyInfowindowAdapter;

import com.example.giftsapp.models.Mall;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        final double[] lat = new double[5];
        final double[] lng = new double[5];


        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Toast.makeText(getApplicationContext(), "Please Enable GPS", Toast.LENGTH_SHORT).show();
//             manager.setTestProviderEnabled(LocationManager.GPS_PROVIDER,true);
        } else {
            Toast.makeText(getApplicationContext(), "Enabled GPS", Toast.LENGTH_SHORT).show();

        }


//        client.requestLocationUpdates(null,lcb,null);

        Mall m1 = new Mall("هايبر مول", R.drawable.haiper, "https://ar-ar.facebook.com/HyperMall.Danaf/");
        m1.setLat(31.452262349669027);
        m1.setLng(34.387949007936);
        Mall m2 = new Mall("أبو دلال مول", R.drawable.abodlal, "https://www.facebook.com/AbuDalalMall/");
        m2.setLat(31.448663593166305);
        m2.setLng(34.39207256858304);




        ///settings map
        mMap.setTrafficEnabled(true);
        mMap.setBuildingsEnabled(true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 0);

        }
        mMap.setMyLocationEnabled(true);
        // Add a marker in  and move the camera
        UiSettings settings = mMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
        settings.setAllGesturesEnabled(true);
        settings.setMyLocationButtonEnabled(true);
        settings.setCompassEnabled(true);
        settings.setIndoorLevelPickerEnabled(true);
        settings.setMapToolbarEnabled(true);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 0);

        }



        for(Mall m:new Mall().getAllMall()){
            MarkerOptions markerOptionsh = new MarkerOptions();
            markerOptionsh.title(m.getName());
            markerOptionsh.position(new LatLng(m.getLat(),m.getLng()));
            Marker markerh = mMap.addMarker(markerOptionsh);
            markerh.setTag(m);
        }





        MyInfowindowAdapter adapter = new MyInfowindowAdapter(getApplicationContext());
        mMap.setInfoWindowAdapter(adapter);

        LatLng latLnggaza = new LatLng(31.5, 34.46667);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLnggaza, 11);
        mMap.animateCamera(cameraUpdate);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
             PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(MapsActivity.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                 Manifest.permission.ACCESS_FINE_LOCATION}, 0);

        }

        FusedLocationProviderClient client = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    Log.d(location.getLatitude() + "///" + location.getLongitude() + "", "aaa");
                    lat[0] = location.getLatitude();
                    lng[0] = location.getLongitude();

                }
            }
        });

        //

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {


                Mall mall = (Mall) marker.getTag();
                PolylineOptions poly = new PolylineOptions();
                poly.width(5);
                poly.color(R.color.black);

                if (lat[0]!=0&&lng[0]!=0){
                    poly.add(new LatLng(lat[0], lng[0]));
                    poly.add(new LatLng(mall.getLat(), mall.getLng()));
//                poly.add(new LatLng());
                    mMap.addPolyline(poly);
                }


                return false;
            }
        });
    }



    public List<Double> getlastlocation() {
        List<Double> latlng = new ArrayList<Double>();


        FusedLocationProviderClient client = LocationServices.getFusedLocationProviderClient(getApplicationContext());

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 0);

        }

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    Log.d(location.getLatitude() + "///" + location.getLongitude() + "", "aaa");
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    latlng.add(latitude);
                    latlng.add(longitude);
                }
            }
        });

        return latlng;
    }
}