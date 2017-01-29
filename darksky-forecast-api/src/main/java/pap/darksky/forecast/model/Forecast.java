package pap.darksky.forecast.model;

import java.util.List;

/**
 * Represents the response to a forecast request.
 *
 * A Forecast object actually contains multiple forecasts.
 * 
 * For details see: https://darksky.net/dev/docs/response
 *
 * @author Puls
 */
public class Forecast {

    private Flags flags;
    private List<Alert> alerts;
    private Currently currently;
    private Daily daily;
    private Hourly hourly;
    private Minutely minutely;

    private String timezone;
    private Double longitude;
    private Double latitude;

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }

    public Currently getCurrently() {
        return currently;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public Minutely getMinutely() {
        return minutely;
    }

    public void setMinutely(Minutely minutely) {
        this.minutely = minutely;
    }

}
