/*
 * The MIT License
 *
 * Copyright 2017 Philipp-André Plogmann.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package tk.plogitech.darksky.forecast.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * DataPint containing the weather information.
 *
 * A data point object contains various properties, each representing the average (unless otherwise specified) of a particular weather phenomenon occurring during a period of time:
 * an instant in the case of currently, a minute for minutely, an hour for hourly, and a day for daily.
 *
 * @author Puls
 */
public class DataPoint implements Serializable {

    private Instant time;
    private String summary;
    private String icon;
    private Double precipIntensity;
    private Double precipProbability;
    private String precipType;
    private Double temperature;
    private Double apparentTemperature;
    private Double dewPoint;
    private Double humidity;
    private Double windSpeed;
    private Integer windBearing;
    private Double pressure;
    private Double cloudCover;
    private Double ozone;
    private Double visibility;

    /**
     * @return The UNIX time at which this data point begins. minutely data point are always aligned to the top of the minute, hourly data point objects to the top of the hour, and
     * daily data point objects to midnight of the day, all according to the local time zone.
     */
    public Instant getTime() {
	return time;
    }

    /**
     * @param time The UNIX time at which this data point begins. minutely data point are always aligned to the top of the minute, hourly data point objects to the top of the hour,
     * and daily data point objects to midnight of the day, all according to the local time zone.
     */
    public void setTime(Instant time) {
	this.time = time;
    }

    /**
     * @return A human-readable text summary of this data point. (This property has millions of possible values, so don’t use it for automated purposes: use the icon property,
     * instead!)
     */
    public String getSummary() {
	return summary;
    }

    /**
     * @param summary A human-readable text summary of this data point. (This property has millions of possible values, so don’t use it for automated purposes: use the icon
     * property, instead!)
     */
    public void setSummary(String summary) {
	this.summary = summary;
    }

    /**
     * @return A machine-readable text summary of this data point, suitable for selecting an icon for display. If defined, this property will have one of the following values:
     * clear-day, clear-night, rain, snow, sleet, wind, fog, cloudy, partly-cloudy-day, or partly-cloudy-night. (Developers should ensure that a sensible default is defined, as
     * additional values, such as hail, thunderstorm, or tornado, may be defined in the future.)
     */
    public String getIcon() {
	return icon;
    }

    /**
     * @param icon A machine-readable text summary of this data point, suitable for selecting an icon for display. If defined, this property will have one of the following values:
     * clear-day, clear-night, rain, snow, sleet, wind, fog, cloudy, partly-cloudy-day, or partly-cloudy-night. (Developers should ensure that a sensible default is defined, as
     * additional values, such as hail, thunderstorm, or tornado, may be defined in the future.)
     */
    public void setIcon(String icon) {
	this.icon = icon;
    }

    /**
     * @return The intensity (in inches of liquid water per hour) of precipitation occurring at the given time. This value is conditional on probability (that is, assuming any
     * precipitation occurs at all) for minutely data points, and unconditional otherwise.
     */
    public Double getPrecipIntensity() {
	return precipIntensity;
    }

    /**
     * @param precipIntensity The intensity (in inches of liquid water per hour) of precipitation occurring at the given time. This value is conditional on probability (that is,
     * assuming any precipitation occurs at all) for minutely data points, and unconditional otherwise.
     */
    public void setPrecipIntensity(Double precipIntensity) {
	this.precipIntensity = precipIntensity;
    }

    /**
     * @return The probability of precipitation occurring, between 0 and 1, inclusive.
     */
    public Double getPrecipProbability() {
	return precipProbability;
    }

    /**
     * @param precipProbability The probability of precipitation occurring, between 0 and 1, inclusive.
     */
    public void setPrecipProbability(Double precipProbability) {
	this.precipProbability = precipProbability;
    }

    /**
     * @return The air temperature in degrees Fahrenheit.
     */
    public Double getTemperature() {
	return temperature;
    }

    /**
     * @param temperature The air temperature in degrees Fahrenheit.
     */
    public void setTemperature(Double temperature) {
	this.temperature = temperature;
    }

    /**
     * @return The apparent (or “feels like”) temperature in degrees Fahrenheit.
     */
    public Double getApparentTemperature() {
	return apparentTemperature;
    }

    /**
     * @param apparentTemperature The apparent (or “feels like”) temperature in degrees Fahrenheit.
     */
    public void setApparentTemperature(Double apparentTemperature) {
	this.apparentTemperature = apparentTemperature;
    }

    /**
     * @return The dew point in degrees Fahrenheit.
     */
    public Double getDewPoint() {
	return dewPoint;
    }

    /**
     * @param dewPoint The dew point in degrees Fahrenheit.
     */
    public void setDewPoint(Double dewPoint) {
	this.dewPoint = dewPoint;
    }

    /**
     * @return The relative humidity, between 0 and 1, inclusive.
     */
    public Double getHumidity() {
	return humidity;
    }

    /**
     * @param humidity The relative humidity, between 0 and 1, inclusive.
     */
    public void setHumidity(Double humidity) {
	this.humidity = humidity;
    }

    /**
     * @return The wind speed in miles per hour.
     */
    public Double getWindSpeed() {
	return windSpeed;
    }

    /**
     * @param windSpeed The wind speed in miles per hour.
     */
    public void setWindSpeed(Double windSpeed) {
	this.windSpeed = windSpeed;
    }

    /**
     * @return The direction that the wind is coming from in degrees, with true north at 0° and progressing clockwise. (If windSpeed is zero, then this value will not be defined.)
     */
    public Integer getWindBearing() {
	return windBearing;
    }

    /**
     * @param windBearing The direction that the wind is coming from in degrees, with true north at 0° and progressing clockwise. (If windSpeed is zero, then this value will not be
     * defined.)
     */
    public void setWindBearing(Integer windBearing) {
	this.windBearing = windBearing;
    }

    /**
     * @return The percentage of sky occluded by clouds, between 0 and 1, inclusive.
     */
    public Double getCloudCover() {
	return cloudCover;
    }

    /**
     * @param cloudCover The percentage of sky occluded by clouds, between 0 and 1, inclusive.
     */
    public void setCloudCover(Double cloudCover) {
	this.cloudCover = cloudCover;
    }

    /**
     * @return The columnar density of total atmospheric ozone at the given time in Dobson units.
     */
    public Double getOzone() {
	return ozone;
    }

    /**
     * @param ozone The columnar density of total atmospheric ozone at the given time in Dobson units.
     */
    public void setOzone(Double ozone) {
	this.ozone = ozone;
    }

    /**
     * @return The sea-level air pressure in millibars.
     */
    public Double getPressure() {
	return pressure;
    }

    /**
     * @param pressure The sea-level air pressure in millibars.
     */
    public void setPressure(Double pressure) {
	this.pressure = pressure;
    }

    /**
     * @return The type of precipitation occurring at the given time. If defined, this property will have one of the following values: "rain", "snow", or "sleet" (which refers to
     * each of freezing rain, ice pellets, and “wintery mix”). (If precipIntensity is zero, then this property will not be defined.)
     */
    public String getPrecipType() {
	return precipType;
    }

    /**
     * @param precipType The type of precipitation occurring at the given time. If defined, this property will have one of the following values: "rain", "snow", or "sleet" (which
     * refers to each of freezing rain, ice pellets, and “wintery mix”). (If precipIntensity is zero, then this property will not be defined.)
     */
    public void setPrecipType(String precipType) {
	this.precipType = precipType;
    }

    /**
     * @return The average visibility in miles, capped at 10 miles.
     */
    public Double getVisibility() {
	return visibility;
    }

    /**
     * @param visibility The average visibility in miles, capped at 10 miles.
     */
    public void setVisibility(Double visibility) {
	this.visibility = visibility;
    }

    @Override
    public int hashCode() {
	int hash = 5;
	hash = 37 * hash + Objects.hashCode(this.time);
	hash = 37 * hash + Objects.hashCode(this.summary);
	hash = 37 * hash + Objects.hashCode(this.icon);
	hash = 37 * hash + Objects.hashCode(this.precipIntensity);
	hash = 37 * hash + Objects.hashCode(this.precipProbability);
	hash = 37 * hash + Objects.hashCode(this.precipType);
	hash = 37 * hash + Objects.hashCode(this.temperature);
	hash = 37 * hash + Objects.hashCode(this.apparentTemperature);
	hash = 37 * hash + Objects.hashCode(this.dewPoint);
	hash = 37 * hash + Objects.hashCode(this.humidity);
	hash = 37 * hash + Objects.hashCode(this.windSpeed);
	hash = 37 * hash + Objects.hashCode(this.windBearing);
	hash = 37 * hash + Objects.hashCode(this.pressure);
	hash = 37 * hash + Objects.hashCode(this.cloudCover);
	hash = 37 * hash + Objects.hashCode(this.ozone);
	hash = 37 * hash + Objects.hashCode(this.visibility);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final DataPoint other = (DataPoint) obj;
	if (!Objects.equals(this.summary, other.summary)) {
	    return false;
	}
	if (!Objects.equals(this.icon, other.icon)) {
	    return false;
	}
	if (!Objects.equals(this.precipType, other.precipType)) {
	    return false;
	}
	if (!Objects.equals(this.time, other.time)) {
	    return false;
	}
	if (!Objects.equals(this.precipIntensity, other.precipIntensity)) {
	    return false;
	}
	if (!Objects.equals(this.precipProbability, other.precipProbability)) {
	    return false;
	}
	if (!Objects.equals(this.temperature, other.temperature)) {
	    return false;
	}
	if (!Objects.equals(this.apparentTemperature, other.apparentTemperature)) {
	    return false;
	}
	if (!Objects.equals(this.dewPoint, other.dewPoint)) {
	    return false;
	}
	if (!Objects.equals(this.humidity, other.humidity)) {
	    return false;
	}
	if (!Objects.equals(this.windSpeed, other.windSpeed)) {
	    return false;
	}
	if (!Objects.equals(this.windBearing, other.windBearing)) {
	    return false;
	}
	if (!Objects.equals(this.pressure, other.pressure)) {
	    return false;
	}
	if (!Objects.equals(this.cloudCover, other.cloudCover)) {
	    return false;
	}
	if (!Objects.equals(this.ozone, other.ozone)) {
	    return false;
	}
	return Objects.equals(this.visibility, other.visibility);
    }

}
