package com.example.quakereport;

import android.content.Context;
import android.content.AsyncTaskLoader;
import java.util.List;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<EarthQuakeData>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
     public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {

        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<EarthQuakeData> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        return QuakeWithJson.fetchEarthquakeData(mUrl);
    }
}
