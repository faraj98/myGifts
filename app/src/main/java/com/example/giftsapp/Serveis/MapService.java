package com.example.giftsapp.Serveis;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

<<<<<<< HEAD
import com.example.giftsapp.HomeActivity;
import com.example.giftsapp.MallDetailsActivity;
import com.example.giftsapp.MapsActivity;
import com.example.giftsapp.R;
=======
import com.example.giftsapp.Activity.HomeActivity;
import com.example.giftsapp.Activity.MallDetailsActivity;
import com.example.giftsapp.Activity.MapsActivity;
import com.example.giftsapp.Firebase.MyFirebase;
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
import com.example.giftsapp.models.Mall;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

<<<<<<< HEAD
import java.util.ArrayList;

=======
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
public class MapService extends Service {
    boolean isRunning=true;
    int anInt = 0;
    int y = 0;
    final double[] lat = new double[5];
    final double[] lng = new double[5];
    Context context;

<<<<<<< HEAD
    public MapService(Context context) {
        this.context = context;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


=======


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
        createNotifecation();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                    anInt++;


                    FusedLocationProviderClient client = LocationServices.getFusedLocationProviderClient(getApplicationContext());
                    LocationRequest request = LocationRequest.create();
                    request.setInterval(5000);
                    request.setFastestInterval(1000);
<<<<<<< HEAD

                    request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        LocationCallback lcb;


                    if (ActivityCompat.checkSelfPermission(MapService.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MapService.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
=======
                    request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        LocationCallback lcb;
                    if (ActivityCompat.checkSelfPermission(MapService.this, Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED &&
                            ActivityCompat.checkSelfPermission(MapService.this, Manifest.permission.ACCESS_COARSE_LOCATION)
                                    != PackageManager.PERMISSION_GRANTED) {
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
<<<<<<< HEAD
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        ActivityCompat.requestPermissions((Activity)getApplicationContext(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 0);


=======
                        //                                          int[] grantResults)// to handle the case where the user grants the permission. See the documentation// for ActivityCompat#requestPermissions for more details.
                        ActivityCompat.requestPermissions((Activity)getApplicationContext(), new String[]{
                                Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION},
                                0);
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
                    }
                    client.requestLocationUpdates(request, new LocationCallback() {
                        @Override
                        public void onLocationResult(@NonNull LocationResult locationResult) {
                            super.onLocationResult(locationResult);
                            if (locationResult != null) {
                                Location location = locationResult.getLastLocation();
                                if (location != null) {
                                    Log.d(location.getLatitude() + "," + location.getLongitude() + "خطوط الطول والعرض ===", "aaa");
<<<<<<< HEAD

                                    lat[0]= location.getLatitude();
                                    lng[0] = location.getLongitude();

=======
                                    lat[0]= location.getLatitude();
                                    lng[0] = location.getLongitude();
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
                                }
                            }
                        }


                    }, Looper.getMainLooper());

<<<<<<< HEAD
                    Mall m=new Mall();
=======
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde

                    Log.d(lat[0] + "," + lng[0] + "خطوط الطول والعرض ===", "aaa");
                    float[] result = new float[1];
                    if (lat[0]!=0 && lng[0]!=0){
                        if (!isRunning)break;
<<<<<<< HEAD
                        for (Mall e : m.getAllMall()) {

                            Location.distanceBetween(lat[0], lng[0], e.getLat(), e.getLng(), result);
                            float distance = result[0];
                            if (distance <= 2000) {
                                Intent intent1 = new Intent(getApplicationContext(), MallDetailsActivity.class);
                                intent1.putExtra("MallName", e.getName());
                                intent1.putExtra("MallImage",e.getImage());
=======
                        for (Mall e : new Mall().getAllMall()) {

                            Location.distanceBetween(lat[0], lng[0], (Double)e.getLat(), (Double)e.getLng(), result);
                            Log.d("ddd", "run: 0000"+e.getLat()+"jjjj"+e.getLng());
                            float distance = result[0];
                            if (distance <= 2000) {
                                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                                intent1.setData(Uri.parse(e.getUri()));
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
                                PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent1, 0);
                                //////
                                Intent imap = new Intent(getApplicationContext(), MapsActivity.class);
                                PendingIntent pimap = PendingIntent.getActivity(getApplicationContext(), 0, imap, 0);
<<<<<<< HEAD


                                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "ch1")
=======
                                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),
                                        "ch1")
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
                                        .setSmallIcon(e.getImage())
                                        .setContentTitle(e.getName())
                                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), e.getImage()))
                                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
<<<<<<< HEAD

=======
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
                                        .setContentText(e.getName() + "  على بعد" + distance + "متر منك")
                                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                        .setContentIntent(pimap)
                                        .addAction(e.getImage(), "زيارة المتجر", pi);
                                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());

                                // notificationId is a unique int for each notification that you must define
                                y++;
                                Log.d("yyy", "run: "+y);

                                notificationManager.notify(y, builder.build());
                                stopService(new Intent(MapService.this,MapService.class));

                            }
                            Log.d(distance + "المسافة===", "aaa");
                        }
                        Log.d("aaa", "onStartCommand: "+anInt);
                    }
                }
            }
        }).start();
        return Service.START_STICKY;





    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        isRunning=false;

    }


    public void createNotifecation() {
        if (Build.VERSION.SDK_INT >= 26) {
<<<<<<< HEAD
            NotificationChannel channel = new NotificationChannel("ch1", "foureground channel", NotificationManager.IMPORTANCE_HIGH);
=======
            NotificationChannel channel = new NotificationChannel("ch1", "foureground channel",
                    NotificationManager.IMPORTANCE_HIGH);
>>>>>>> 26f4474f4e235853898e68ae667fe679c02b6bde
            channel.setDescription("Notification");
            channel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), null);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{1000, 1000, 1000});
            channel.enableLights(true);
            channel.setLightColor(Color.YELLOW);
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(channel);

        }
    }
}


