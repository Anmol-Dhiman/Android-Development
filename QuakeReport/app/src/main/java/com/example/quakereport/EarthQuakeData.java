package com.example.quakereport;

public class EarthQuakeData {
    private Double Magnitude;
    private Long Date;
    private String Location;
    private String Url;

    public EarthQuakeData(Double Magnitude, String Location, Long Date, String Url) {
        this.Magnitude = Magnitude;
        this.Location = Location;
        this.Date = Date;
        this.Url = Url;

    }

    public String getUrl() {
        return Url;
    }

    public Double getMagnitude() {
        return Magnitude;
    }

    public Long gettimeinMilliseconds() {
        return Date;
    }

    public String getLocation() {
        return Location;
    }
}
