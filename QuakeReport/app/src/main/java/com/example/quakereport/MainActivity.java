package com.example.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<EarthQuakeData> DataList = QuakeWithJson.extractEarthquakes();


        ListView QuakeListView = (ListView) findViewById(R.id.list);

        EarthQuakeAdaptor adaptor = new EarthQuakeAdaptor(this, DataList);
        QuakeListView.setAdapter(adaptor);


        class EarthquakeAsyncTask extends AsyncTask<String, Void, List<EarthQuakeData>> {

            @Override
            protected List<EarthQuakeData> doInBackground(String... urls) {
                if (urls.length < 1 || urls[0] == null) {
                    return null;
                }

                List<EarthQuakeData> result = QuakeWithJson.fetchEarthquakeData(urls[0]);
                return result;
            }

            @Override
            protected void onPostExecute(List<EarthQuakeData> data) {
// Clear the adapter of previous earthquake data
                adaptor.clear();

                // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
                // data set. This will trigger the ListView to update.
                if (data != null && !data.isEmpty()) {
                    adaptor.addAll(data);
                }
            }
        }

//        here is the onItemClickListener for opening the web page when we click on any list item
//this will open up the link which are associated to the specific earthquake
        QuakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                EarthQuakeData currentEarthquake = adaptor.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });

    }
}