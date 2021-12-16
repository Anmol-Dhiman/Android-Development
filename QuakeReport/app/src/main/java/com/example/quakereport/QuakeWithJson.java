package com.example.quakereport;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public final class QuakeWithJson {


    private static final String SAMPLE_JSON_RESPONSE = "{\"type\":\"FeatureCollection\",\"metadata\":{\"generated\":1639455545000,\"url\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?starttime=2021-12-01&endtime=2021-12-10&minmag=5.8&format=geojson\",\"title\":\"USGS Earthquakes\",\"status\":200,\"api\":\"1.12.3\",\"count\":7},\"features\":[{\"type\":\"Feature\",\"properties\":{\"mag\":6,\"place\":\"119 km N of Naze, Japan\",\"time\":1639015507709,\"updated\":1639265681708,\"tz\":null,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us6000gaq5\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us6000gaq5&format=geojson\",\"felt\":13,\"cdi\":6.7,\"mmi\":5.119,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":563,\"net\":\"us\",\"code\":\"6000gaq5\",\"ids\":\",us6000gaq5,usauto6000gaq5,pt21343000,at00r3tsgo,\",\"sources\":\",us,usauto,pt,at,\",\"types\":\",dyfi,ground-failure,internal-moment-tensor,internal-origin,losspager,moment-tensor,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":2.258,\"rms\":0.65,\"gap\":24,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.0 - 119 km N of Naze, Japan\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[129.3791,29.4428,7]},\"id\":\"us6000gaq5\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":5.8,\"place\":\"off the coast of Oregon\",\"time\":1638926465668,\"updated\":1639067447015,\"tz\":null,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us6000gaag\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us6000gaag&format=geojson\",\"felt\":10,\"cdi\":2.2,\"mmi\":0,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":1,\"sig\":600,\"net\":\"us\",\"code\":\"6000gaag\",\"ids\":\",at00r3rvr9,us6000gaag,usauto6000gaag,pt21342001,\",\"sources\":\",at,us,usauto,pt,\",\"types\":\",dyfi,general-text,impact-link,internal-moment-tensor,internal-origin,losspager,moment-tensor,origin,phase-data,shakemap,significance,\",\"nst\":null,\"dmin\":1.486,\"rms\":0.89,\"gap\":166,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 5.8 - off the coast of Oregon\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-128.9672,44.4369,10]},\"id\":\"us6000gaag\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":5.8,\"place\":\"off the coast of Oregon\",\"time\":1638923798804,\"updated\":1639010445395,\"tz\":null,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us6000ga9w\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us6000ga9w&format=geojson\",\"felt\":6,\"cdi\":2,\"mmi\":0,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":1,\"sig\":519,\"net\":\"us\",\"code\":\"6000ga9w\",\"ids\":\",at00r3rtp5,us6000ga9w,usauto6000ga9w,pt21342000,\",\"sources\":\",at,us,usauto,pt,\",\"types\":\",dyfi,general-text,impact-link,internal-moment-tensor,internal-origin,losspager,moment-tensor,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":1.426,\"rms\":1.32,\"gap\":159,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 5.8 - off the coast of Oregon\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-129.5319,44.4012,10]},\"id\":\"us6000ga9w\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":5.8,\"place\":\"South Sandwich Islands region\",\"time\":1638892553707,\"updated\":1639431792683,\"tz\":null,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us6000ga3a\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us6000ga3a&format=geojson\",\"felt\":2,\"cdi\":8.1,\"mmi\":3.675,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":519,\"net\":\"us\",\"code\":\"6000ga3a\",\"ids\":\",us6000ga3a,usauto6000ga3a,\",\"sources\":\",us,usauto,\",\"types\":\",dyfi,internal-moment-tensor,losspager,moment-tensor,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":6.83,\"rms\":0.91,\"gap\":56,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 5.8 - South Sandwich Islands region\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-25.7473,-57.4626,31]},\"id\":\"us6000ga3a\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":6,\"place\":\"259 km N of Tobelo, Indonesia\",\"time\":1638661677708,\"updated\":1638891900040,\"tz\":null,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us6000g944\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us6000g944&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":3.516,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":554,\"net\":\"us\",\"code\":\"6000g944\",\"ids\":\",us6000g944,usauto6000g944,pt21338000,at00r3m7fx,\",\"sources\":\",us,usauto,pt,at,\",\"types\":\",ground-failure,internal-moment-tensor,internal-origin,losspager,moment-tensor,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":3.363,\"rms\":0.96,\"gap\":25,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.0 - 259 km N of Tobelo, Indonesia\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[128.1359,4.0681,174.26]},\"id\":\"us6000g944\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":6,\"place\":\"South Sandwich Islands region\",\"time\":1638520419061,\"updated\":1638607033063,\"tz\":null,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us6000g8nd\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us6000g8nd&format=geojson\",\"felt\":null,\"cdi\":null,\"mmi\":3.477,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":554,\"net\":\"us\",\"code\":\"6000g8nd\",\"ids\":\",usauto6000g8nd,pt21337000,at00r3j6g6,us6000g8nd,\",\"sources\":\",usauto,pt,at,us,\",\"types\":\",internal-moment-tensor,internal-origin,losspager,moment-tensor,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":8.675,\"rms\":0.55,\"gap\":54,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.0 - South Sandwich Islands region\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-27.1115,-60.4583,9.92]},\"id\":\"us6000g8nd\"},\n" +
            "{\"type\":\"Feature\",\"properties\":{\"mag\":6.2,\"place\":\"Easter Island region\",\"time\":1638506404030,\"updated\":1638593130804,\"tz\":null,\"url\":\"https://earthquake.usgs.gov/earthquakes/eventpage/us6000g8md\",\"detail\":\"https://earthquake.usgs.gov/fdsnws/event/1/query?eventid=us6000g8md&format=geojson\",\"felt\":5,\"cdi\":3.4,\"mmi\":3.106,\"alert\":\"green\",\"status\":\"reviewed\",\"tsunami\":0,\"sig\":593,\"net\":\"us\",\"code\":\"6000g8md\",\"ids\":\",us6000g8md,usauto6000g8md,\",\"sources\":\",us,usauto,\",\"types\":\",dyfi,ground-failure,internal-moment-tensor,losspager,moment-tensor,origin,phase-data,shakemap,\",\"nst\":null,\"dmin\":2.898,\"rms\":1.38,\"gap\":38,\"magType\":\"mww\",\"type\":\"earthquake\",\"title\":\"M 6.2 - Easter Island region\"},\"geometry\":{\"type\":\"Point\",\"coordinates\":[-112.2613,-28.6292,10]},\"id\":\"us6000g8md\"}],\"bbox\":[-129.5319,-60.4583,7,129.3791,44.4369,174.26]}";

    public static ArrayList<EarthQuakeData> extractEarthquakes() {

        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<EarthQuakeData> earthquakes = new ArrayList<>();


        try {
            JSONObject root = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray feature = root.getJSONArray("features");
            for (int i = 0; i < feature.length(); i++) {
                JSONObject featuresList = feature.getJSONObject(i);
                JSONObject properties = featuresList.getJSONObject("properties");
                String url = properties.getString("url");
                Double magnitude = properties.getDouble("mag");
                String place = properties.getString("place");
                long time = properties.getLong("time");
                earthquakes.add(new EarthQuakeData(magnitude, place, time,url));

            }


        } catch (JSONException e) {

            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }


        return earthquakes;
    }

}