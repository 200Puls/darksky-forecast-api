package pap.darksky.forecast.model;

import java.time.Instant;

/**
 * The weather data for a single day.
 *
 * @author Puls
 */
public class DailyWeatherData {

    private Instant time;
    private String summary;
    private String icon;
    private Instant sunriseTime;
    private Instant sunsetTime;
    private Double moonPhase;
    private Double precipIntensity;
    private Double precipIntensityMax;
    private Double precipProbability;
    private String precipType;
    private Double temperatureMin;
    private Instant temperatureMinTime;
    private Double temperatureMax;
    private Instant temperatureMaxTime;
    private Double apparentTemperatureMin;
    private Instant apparentTemperatureMinTime;
    private Double apparentTemperatureMax;
    private Instant apparentTemperatureMaxTime;
    private Double dewPoint;
    private Double humidity;
    private Double windSpeed;
    private Integer windBearing;
    private Double visibility;
    private Double cloudCover;
    private Double pressure;
    private Double ozone;

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(Double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public Double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(Double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(Integer windBearing) {
        this.windBearing = windBearing;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public Double getOzone() {
        return ozone;
    }

    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    public Instant getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(Instant sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public Instant getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(Instant sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public Double getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(Double moonPhase) {
        this.moonPhase = moonPhase;
    }

    public Double getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public void setPrecipIntensityMax(Double precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    public Double getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public Instant getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public void setTemperatureMinTime(Instant temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public Double getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public Instant getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public void setTemperatureMaxTime(Instant temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public Double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public void setApparentTemperatureMin(Double apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    public Instant getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMinTime(Instant apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public Double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public void setApparentTemperatureMax(Double apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public Instant getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    public void setApparentTemperatureMaxTime(Instant apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

}
