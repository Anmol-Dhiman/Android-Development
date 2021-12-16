package com.example.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.text.DecimalFormat;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.graphics.drawable.GradientDrawable;

import androidx.core.content.ContextCompat;


public class EarthQuakeAdaptor extends ArrayAdapter<EarthQuakeData> {
    public EarthQuakeAdaptor(Context context, ArrayList<EarthQuakeData> quakeData) {
        super(context, 0, quakeData);
    }

    private static final String LOCATION_SEPARATOR = " of ";
    private String primaryLocation;
    private String locationOffset;

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(Double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }


    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemview = convertView;
        if (listitemview == null) {
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.listitemlayout, parent, false);
        }

        EarthQuakeData currentEarthQuake = getItem(position);

        TextView magnitudeView = (TextView) listitemview.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMagnitude(currentEarthQuake.getMagnitude());
        magnitudeView.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
//        as we specify the background into the drawable file so that we have to use the GradientDrawable object
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthQuake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


//        form here
        String originalLocation = currentEarthQuake.getLocation();
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView locationOffSetView = (TextView) listitemview.findViewById(R.id.location_offset);
        locationOffSetView.setText(locationOffset);

        TextView primaryLocationSetView = (TextView) listitemview.findViewById(R.id.primary_location);
        primaryLocationSetView.setText(primaryLocation);
//upto here
//is the code for spliting the location string so that can show the distance and proper location separately
        TextView dateView = (TextView) listitemview.findViewById(R.id.date);
        TextView timeView = (TextView) listitemview.findViewById(R.id.time);

        //for converting the unix time into the perfect date and the time, we have make Date object and pass the unix value into it and
        // and then pass the Date object into the SimpleDataFormat object.
        Date dateObject = new Date(currentEarthQuake.gettimeinMilliseconds());

        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        String formattdTime = formatTime(dateObject);
        timeView.setText(formattdTime);


//        here we will set the onClickListener for setting the web page of the specific list item


        return listitemview;


    }
}
