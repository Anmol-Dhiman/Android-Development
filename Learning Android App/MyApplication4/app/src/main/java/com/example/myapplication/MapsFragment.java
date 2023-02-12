package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import android.Manifest;
import android.content.Intent;
import android.media.metrics.TrackChangeEvent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.myapplication.databinding.FragmentMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import pub.devrel.easypermissions.EasyPermissions;

public class MapsFragment extends Fragment {


    private FragmentMapsBinding binding;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {


        @Override
        public void onMapReady(GoogleMap googleMap) {


            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentMapsBinding.inflate(inflater, container, false);

//        make a get request to database
        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStartButtonClicked();
            }
        });
        return binding.getRoot();
    }

    private void onStartButtonClicked() {
        if (hasBackgroundLocationPermission() && hasLocationPermission()) {
            sendActionCommandtoService("start");
            Toast.makeText(getContext(), "tracking started", Toast.LENGTH_SHORT).show();
            TrackingService.started.observe((LifecycleOwner) getContext(), new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean result) {
                    if (result == true) {
                        Toast.makeText(getContext(), "started", Toast.LENGTH_SHORT).show();
                        Log.d("main", "onChanged: started");

                    }
                    else {
                        Log.d("main" +
                                "", "onChanged: not started");
                    }
                }
            });
        } else {
            requestBackgroundPermission();
            requestLocationPermission();
        }
    }


    private void sendActionCommandtoService(String action) {
        Intent intent = new Intent(getContext(), TrackingService.class);
        intent.setAction(action);
        getActivity().startService(intent);
//        here we have to send the post request of current location
    }


    private boolean hasLocationPermission() {
        return EasyPermissions.hasPermissions(
                getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
        );
    }

    private boolean hasBackgroundLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            return EasyPermissions.hasPermissions(
                    getContext(),
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
            );
        }
        return true;
    }

    private void requestBackgroundPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            EasyPermissions.requestPermissions(
                    this,
                    "Require Background permission to track the movement",
                    2,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
            );
        }

    }

    private void requestLocationPermission() {
        EasyPermissions.requestPermissions(
                this,
                "This permission is needed to give our service",
                1,
                Manifest.permission.ACCESS_FINE_LOCATION
        );
    }


}