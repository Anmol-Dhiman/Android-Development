package com.example.myapplication;

import static android.app.NotificationManager.IMPORTANCE_LOW;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TrackingService extends LifecycleService {
    //    private static final String ACTION_SERVICE_START = "ACTION_SERVICE_START";
//    private static final String ACTION_SERVICE_STOP = "ACTION_SERVICE_STOP";
    private static final String NOTIFICATION_CHANNEL_ID = "tracker_notification_id";
    private static final String NOTIFICATION_CHANNEL_NAME = "tracker_notification";
    private static final int NOTIFICATION_ID = 3;
    private static final int PENDING_INTENT_REQUEST_CODE = 100;
    private FusedLocationProviderClient fusedLocationProviderClient;
    public static MutableLiveData<Boolean> started;
    private MutableLiveData<List<LatLng>> locationLiveData;
    private MutableLiveData<Long> startTime;
    private MutableLiveData<Long> stopTime;
    private ArrayList<LatLng> locationLiveDataList;
    private NotificationCompat.Builder notification;
    private NotificationManager notificationManager;
    private static final long LOCATION_UPDATE_INTERVAL = 10000L;
    private static final long LOCATION_FASTEST_UPDATE_INTERVAL = 2000L;


    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(@NonNull LocationResult result) {
            super.onLocationResult(result);
            List<Location> locations = result.getLocations();
            Log.d("main", "onLocationResult: " + locations.toString());
            for (Location location : locations) {
                updateLocationList(location);
                updateNotificationPeriodically();
            }
        }
    };

    private void updateLocationList(Location location) {
//        here we have to make the post request
        LatLng newLatLng = new LatLng(location.getLatitude(), location.getLongitude());
        locationLiveDataList.add(newLatLng);

        locationLiveData.postValue(locationLiveDataList);
    }

    private void updateNotificationPeriodically() {
        notification.setContentTitle("Distance Travelled").setContentText("" + distanceTraveled(locationLiveData.getValue()) + "km");
    }

    @Override
    public void onCreate() {
        setInitialValues();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        super.onCreate();
    }

    private void setInitialValues() {
        started = new MutableLiveData<>();
        locationLiveDataList = new ArrayList<>();
        locationLiveData = new MutableLiveData<>();
        startTime = new MutableLiveData<>();
        stopTime = new MutableLiveData<>();
        started.postValue(false);
        locationLiveData.postValue(new ArrayList<>());
        startTime.postValue(0L);
        stopTime.postValue(0L);
        notification = provideNotificationBuilder();
        notificationManager = provideNotificationManager();
    }


    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        if (intent.getAction().equals("start")) {
            startForegroundService();
            startLocationUpdates();
            started.postValue(true);
            Toast.makeText(this, "started", Toast.LENGTH_LONG).show();
        } else if (intent.getAction().equals("stop")) {
            started.postValue(false);
            stopForegoundService();
        }

        return super.onStartCommand(intent, flags, startId);

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel(
                    NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, IMPORTANCE_LOW
            ));
        }
    }

    private void startForegroundService() {
        createNotificationChannel();
        startForeground(NOTIFICATION_ID, notification.build());
    }

    private void stopForegoundService() {
        fusedLocationProviderClient.removeLocationUpdates(mLocationCallback);
        NotificationManager systemService = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        systemService.cancel(NOTIFICATION_ID);
        stopForeground(true);
        stopSelf();
        stopTime.postValue(System.currentTimeMillis());
    }

    @SuppressLint("MissingPermission")
    private void startLocationUpdates() {

        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(LOCATION_UPDATE_INTERVAL);
        locationRequest.setFastestInterval(LOCATION_FASTEST_UPDATE_INTERVAL);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        fusedLocationProviderClient.requestLocationUpdates(
                locationRequest, mLocationCallback, Looper.getMainLooper()
        );
        startTime.postValue(System.currentTimeMillis());
    }

    private String distanceTraveled(List<LatLng> location) {
        if (location.size() > 1) {
            float meters = Float.valueOf(String.valueOf(SphericalUtil.computeDistanceBetween(location.get(0), location.get(location.size() - 1))));
            String kilometers = String.valueOf(meters / 1000);
            return new DecimalFormat("#.##").format(kilometers);
        }
        return "0.00";
    }

    private String calculateTime(Long startTime, Long stopTime) {
        long elapsedTime = stopTime - startTime;
        long seconds = Integer.valueOf(Math.toIntExact(elapsedTime / 1000)) % 60;
        long minutes = (elapsedTime / (1000 * 60) % 60);
        long hours = (elapsedTime / (1000 * 60 * 60) % 24);
        return hours + ":" + minutes + ":" + seconds;
    }

    private CameraPosition setCameraPosition(LatLng location) {
        return new CameraPosition.Builder().target(location).zoom(18f).build();
    }

    private NotificationCompat.Builder provideNotificationBuilder() {
        return new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID).setAutoCancel(false)
                .setOngoing(true)
                .setContentIntent(providePendingIntent());
    }


    private PendingIntent providePendingIntent() {
        return PendingIntent.getActivity(
                this,
                PENDING_INTENT_REQUEST_CODE,
                new Intent(this, MainActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT
        );
    }

    private NotificationManager provideNotificationManager() {
        return (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
    }
}


