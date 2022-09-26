package com.example.weahterforecast;


import android.content.Context;
import android.hardware.Camera;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private Context context;
    private ArrayList<WeatherData> weatherDataArrayList;

    public WeatherAdapter(Context context, ArrayList<WeatherData> weatherDataArrayList) {
        this.context = context;
        this.weatherDataArrayList = weatherDataArrayList;
    }

    @NonNull
    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherData singleObject = weatherDataArrayList.get(position);
        holder.temperature.setText(singleObject.getTemperature() + "°C");
        holder.windSpeed.setText(singleObject.getWindSpeed() + "Km/h");
//        for using the picasso we have to add the dependency for an image downloading lib.
        Picasso.get().load("http:".concat(singleObject.getIcon())).into(holder.conditionImage);

//     here we will take out the time form the format of : - "yyyy-MM-dd hh:mm" to "hh:mm aa"
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        SimpleDateFormat output = new SimpleDateFormat("hh:mm aa");
        try {
            Date t = input.parse(singleObject.getTime());

            holder.time.setText(output.format(t));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return weatherDataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView time, temperature, windSpeed;
        private ImageView conditionImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time_text_view);
            temperature = itemView.findViewById(R.id.temperature_text_view);
            windSpeed = itemView.findViewById(R.id.wind_speed_text_view);
            conditionImage = itemView.findViewById(R.id.image_view_rv);
        }
    }
}
