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
 * DataPoint for the data of a single day.
 *
 * @author Puls
 */
public class DailyDataPoint implements Serializable {

    private Instant time;
    private String summary;
    private String icon;
    private Instant sunriseTime;
    private Instant sunsetTime;
    private Double moonPhase;
    private Double precipIntensity;
    private Double precipIntensityMax;
    private Double precipProbability;
    private Instant precipIntensityMaxTime;
    private Double precipAccumulation;
    private String precipType;
    private Double temperatureHigh;
    private Instant temperatureHighTime;
    private Double temperatureLow;
    private Instant temperatureLowTime;
    private Double apparentTemperatureHigh;
    private Instant apparentTemperatureHighTime;
    private Double apparentTemperatureLow;
    private Instant apparentTemperatureLowTime;
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
    private Double pressure;
    private Double windSpeed;
    private Double windGust;
    private Instant windGustTime;
    private Integer windBearing;
    private Double cloudCover;
    private Integer uvIndex;
    private Instant uvIndexTime;
    private Double visibility;
    private Double ozone;

    /**
     * @return The UNIX time at which this data point begins. minutely data point are always aligned to the top of the minute, hourly data point
     * objects to the top of the hour, and daily data point objects to midnight of the day, all according to the local time zone.
     */
    public Instant getTime() {
	return time;
    }

    /**
     * @param time The UNIX time at which this data point begins. minutely data point are always aligned to the top of the minute, hourly data point
     * objects to the top of the hour, and daily data point objects to midnight of the day, all according to the local time zone.
     */
    public void setTime(Instant time) {
	this.time = time;
    }

    /**
     * @return A human-readable text summary of this data point. (This property has millions of possible values, so don’t use it for automated
     * purposes: use the icon property, instead!)
     */
    public String getSummary() {
	return summary;
    }

    /**
     * @param summary A human-readable text summary of this data point. (This property has millions of possible values, so don’t use it for automated
     * purposes: use the icon property, instead!)
     */
    public void setSummary(String summary) {
	this.summary = summary;
    }

    /**
     * @return A machine-readable text summary of this data point, suitable for selecting an icon for display. If defined, this property will have one
     * of the following values: clear-day, clear-night, rain, snow, sleet, wind, fog, cloudy, partly-cloudy-day, or partly-cloudy-night. (Developers
     * should ensure that a sensible default is defined, as additional values, such as hail, thunderstorm, or tornado, may be defined in the future.)
     */
    public String getIcon() {
	return icon;
    }

    /**
     * @param icon A machine-readable text summary of this data point, suitable for selecting an icon for display. If defined, this property will have
     * one of the following values: clear-day, clear-night, rain, snow, sleet, wind, fog, cloudy, partly-cloudy-day, or partly-cloudy-night.
     * (Developers should ensure that a sensible default is defined, as additional values, such as hail, thunderstorm, or tornado, may be defined in
     * the future.)
     */
    public void setIcon(String icon) {
	this.icon = icon;
    }

    /**
     * @return The intensity (in inches of liquid water per hour) of precipitation occurring at the given time. This value is conditional on
     * probability (that is, assuming any precipitation occurs at all) for minutely data points, and unconditional otherwise.
     */
    public Double getPrecipIntensity() {
	return precipIntensity;
    }

    /**
     * @param precipIntensity The intensity (in inches of liquid water per hour) of precipitation occurring at the given time. This value is
     * conditional on probability (that is, assuming any precipitation occurs at all) for minutely data points, and unconditional otherwise.
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
     * @return The direction that the wind is coming from in degrees, with true north at 0° and progressing clockwise. (If windSpeed is zero, then
     * this value will not be defined.)
     */
    public Integer getWindBearing() {
	return windBearing;
    }

    /**
     * @param windBearing The direction that the wind is coming from in degrees, with true north at 0° and progressing clockwise. (If windSpeed is
     * zero, then this value will not be defined.)
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
     * @return The type of precipitation occurring at the given time. If defined, this property will have one of the following values: "rain", "snow",
     * or "sleet" (which refers to each of freezing rain, ice pellets, and “wintery mix”). (If precipIntensity is zero, then this property will not be
     * defined.)
     */
    public String getPrecipType() {
	return precipType;
    }

    /**
     * @param precipType The type of precipitation occurring at the given time. If defined, this property will have one of the following values:
     * "rain", "snow", or "sleet" (which refers to each of freezing rain, ice pellets, and “wintery mix”). (If precipIntensity is zero, then this
     * property will not be defined.)
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

    /**
     * @return The UNIX time of when the sun will rise during a given day.
     */
    public Instant getSunriseTime() {
	return sunriseTime;
    }

    /**
     * @param sunriseTime The UNIX time of when the sun will rise during a given day.
     */
    public void setSunriseTime(Instant sunriseTime) {
	this.sunriseTime = sunriseTime;
    }

    /**
     * @return The UNIX time of when the sun will set during a given day.
     */
    public Instant getSunsetTime() {
	return sunsetTime;
    }

    /**
     * @param sunsetTime The UNIX time of when the sun will set during a given day.
     */
    public void setSunsetTime(Instant sunsetTime) {
	this.sunsetTime = sunsetTime;
    }

    /**
     * @return The fractional part of the lunation number during the given day: a value of 0 corresponds to a new moon, 0.25 to a first quarter moon,
     * 0.5 to a full moon, and 0.75 to a last quarter moon. (The ranges in between these represent waxing crescent, waxing gibbous, waning gibbous,
     * and waning crescent moons, respectively.)
     */
    public Double getMoonPhase() {
	return moonPhase;
    }

    /**
     * @param moonPhase The fractional part of the lunation number during the given day: a value of 0 corresponds to a new moon, 0.25 to a first
     * quarter moon, 0.5 to a full moon, and 0.75 to a last quarter moon. (The ranges in between these represent waxing crescent, waxing gibbous,
     * waning gibbous, and waning crescent moons, respectively.)
     */
    public void setMoonPhase(Double moonPhase) {
	this.moonPhase = moonPhase;
    }

    /**
     * @return The maximum value of precipIntensity during a given day.
     */
    public Double getPrecipIntensityMax() {
	return precipIntensityMax;
    }

    /**
     * @param precipIntensityMax The maximum value of precipIntensity during a given day.
     */
    public void setPrecipIntensityMax(Double precipIntensityMax) {
	this.precipIntensityMax = precipIntensityMax;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #getTemperatureLow()} instead.
     * @return The minimum value of temperature during a given date.
     */
    @Deprecated
    public Double getTemperatureMin() {
	return temperatureMin;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #setTemperatureLow(java.lang.Double)} instead.
     * @param temperatureMin The minimum value of temperature during a given date.
     */
    @Deprecated
    public void setTemperatureMin(Double temperatureMin) {
	this.temperatureMin = temperatureMin;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #getTemperatureLowTime()} instead.
     * @return The UNIX time of when temperatureMin occurs during a given date.
     */
    @Deprecated
    public Instant getTemperatureMinTime() {
	return temperatureMinTime;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #setTemperatureLowTime(java.time.Instant)} instead.
     * @param temperatureMinTime The UNIX time of when temperatureMin occurs during a given date.
     */
    @Deprecated
    public void setTemperatureMinTime(Instant temperatureMinTime) {
	this.temperatureMinTime = temperatureMinTime;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #getTemperatureHigh()} instead.
     * @return The maximum temperature during a given date.
     */
    @Deprecated
    public Double getTemperatureMax() {
	return temperatureMax;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #setTemperatureHigh(java.lang.Double)} instead.
     * @param temperatureMax The maximum temperature during a given date.
     */
    @Deprecated
    public void setTemperatureMax(Double temperatureMax) {
	this.temperatureMax = temperatureMax;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #getTemperatureHighTime()} instead.
     * @return The UNIX time representing when the maximum temperature during a given date occurs.
     */
    @Deprecated
    public Instant getTemperatureMaxTime() {
	return temperatureMaxTime;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #setTemperatureHighTime(java.time.Instant)} instead.
     * @param temperatureMaxTime The UNIX time representing when the maximum temperature during a given date occurs.
     */
    @Deprecated
    public void setTemperatureMaxTime(Instant temperatureMaxTime) {
	this.temperatureMaxTime = temperatureMaxTime;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #getApparentTemperatureLow()} instead.
     * @return The minimum apparent temperature during a given date.
     */
    @Deprecated
    public Double getApparentTemperatureMin() {
	return apparentTemperatureMin;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #setApparentTemperatureLow(java.lang.Double)} instead.
     * @param apparentTemperatureMin The minimum apparent temperature during a given date.
     */
    @Deprecated
    public void setApparentTemperatureMin(Double apparentTemperatureMin) {
	this.apparentTemperatureMin = apparentTemperatureMin;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #getApparentTemperatureLowTime()} instead.
     * @return The UNIX time representing when the minimum apparent temperature during a given date occurs.
     */
    @Deprecated
    public Instant getApparentTemperatureMinTime() {
	return apparentTemperatureMinTime;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #setApparentTemperatureLowTime(java.time.Instant)} instead.
     * @param apparentTemperatureMinTime The UNIX time representing when the minimum apparent temperature during a given date occurs.
     */
    @Deprecated
    public void setApparentTemperatureMinTime(Instant apparentTemperatureMinTime) {
	this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #getApparentTemperatureHigh()} instead.
     * @return The maximum apparent temperature during a given date.
     */
    @Deprecated
    public Double getApparentTemperatureMax() {
	return apparentTemperatureMax;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #setApparentTemperatureHigh(java.lang.Double)} instead.
     * @param apparentTemperatureMax The maximum apparent temperature during a given date.
     */
    @Deprecated
    public void setApparentTemperatureMax(Double apparentTemperatureMax) {
	this.apparentTemperatureMax = apparentTemperatureMax;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #getApparentTemperatureHighTime()} instead.
     * @return The UNIX time representing when the maximum apparent temperature during a given date occurs.
     */
    @Deprecated
    public Instant getApparentTemperatureMaxTime() {
	return apparentTemperatureMaxTime;
    }

    /**
     * @deprecated Deprecated by Darksky. Use {@link #setApparentTemperatureHighTime(java.time.Instant)} instead.
     * @param apparentTemperatureMaxTime The UNIX time representing when the maximum apparent temperature during a given date occurs.
     */
    @Deprecated
    public void setApparentTemperatureMaxTime(Instant apparentTemperatureMaxTime) {
	this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    /**
     * @return The overnight low temperature.
     */
    public Double getTemperatureLow() {
	return temperatureLow;
    }

    /**
     * @param temperatureLow The overnight low temperature.
     */
    public void setTemperatureLow(Double temperatureLow) {
	this.temperatureLow = temperatureLow;
    }

    /**
     * @return The UNIX time representing when the overnight low temperature occurs.
     */
    public Instant getTemperatureLowTime() {
	return temperatureLowTime;
    }

    /**
     * @param temperatureLowTime The UNIX time representing when the overnight low temperature occurs.
     */
    public void setTemperatureLowTime(Instant temperatureLowTime) {
	this.temperatureLowTime = temperatureLowTime;
    }

    /**
     * @return The daytime high temperature.
     */
    public Double getTemperatureHigh() {
	return temperatureHigh;
    }

    /**
     * @param temperatureHigh The daytime high temperature.
     */
    public void setTemperatureHigh(Double temperatureHigh) {
	this.temperatureHigh = temperatureHigh;
    }

    /**
     * @return The UNIX time representing when the daytime high temperature occurs.
     */
    public Instant getTemperatureHighTime() {
	return temperatureHighTime;
    }

    /**
     * @param temperatureHighTime The UNIX time representing when the daytime high temperature occurs.
     */
    public void setTemperatureHighTime(Instant temperatureHighTime) {
	this.temperatureHighTime = temperatureHighTime;
    }

    /**
     * @return The overnight low apparent temperature.
     */
    public Double getApparentTemperatureLow() {
	return apparentTemperatureLow;
    }

    /**
     * @param apparentTemperatureLow The overnight low apparent temperature.
     */
    public void setApparentTemperatureLow(Double apparentTemperatureLow) {
	this.apparentTemperatureLow = apparentTemperatureLow;
    }

    /**
     * @return The UNIX time representing when the overnight low apparent temperature occurs.
     */
    public Instant getApparentTemperatureLowTime() {
	return apparentTemperatureLowTime;
    }

    /**
     * @param apparentTemperatureLowTime The UNIX time representing when the overnight low apparent temperature occurs.
     */
    public void setApparentTemperatureLowTime(Instant apparentTemperatureLowTime) {
	this.apparentTemperatureLowTime = apparentTemperatureLowTime;
    }

    /**
     * @return The daytime high apparent temperature.
     */
    public Double getApparentTemperatureHigh() {
	return apparentTemperatureHigh;
    }

    /**
     * @param apparentTemperatureHigh The daytime high apparent temperature.
     */
    public void setApparentTemperatureHigh(Double apparentTemperatureHigh) {
	this.apparentTemperatureHigh = apparentTemperatureHigh;
    }

    /**
     * @return The UNIX time representing when the daytime high apparent temperature occurs.
     */
    public Instant getApparentTemperatureHighTime() {
	return apparentTemperatureHighTime;
    }

    /**
     * @param apparentTemperatureHighTime The UNIX time representing when the daytime high apparent temperature occurs.
     */
    public void setApparentTemperatureHighTime(Instant apparentTemperatureHighTime) {
	this.apparentTemperatureHighTime = apparentTemperatureHighTime;
    }

    /**
     *
     * @return The UNIX time of when precipIntensityMax occurs during a given day.
     */
    public Instant getPrecipIntensityMaxTime() {
	return precipIntensityMaxTime;
    }

    /**
     * @param precipIntensityMaxTime The UNIX time of when precipIntensityMax occurs during a given day.
     */
    public void setPrecipIntensityMaxTime(Instant precipIntensityMaxTime) {
	this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    /**
     * @return The amount of snowfall accumulation expected to occur, in inches. (If no snowfall is expected, this property will not be defined.)
     */
    public Double getPrecipAccumulation() {
	return precipAccumulation;
    }

    /**
     * @param precipAccumulation The amount of snowfall accumulation expected to occur, in inches. (If no snowfall is expected, this property will not
     * be defined.)
     */
    public void setPrecipAccumulation(Double precipAccumulation) {
	this.precipAccumulation = precipAccumulation;
    }

    /**
     * @return The wind gust speed in miles per hour.
     */
    public Double getWindGust() {
	return windGust;
    }

    /**
     * @param windGust The wind gust speed in miles per hour.
     */
    public void setWindGust(Double windGust) {
	this.windGust = windGust;
    }

    /**
     * @return The UNIX time of when the windGust occurs during a given day.
     */
    public Instant getWindGustTime() {
	return windGustTime;
    }

    /**
     * @param windGustTime The UNIX time of when the windGust occurs during a given day.
     */
    public void setWindGustTime(Instant windGustTime) {
	this.windGustTime = windGustTime;
    }

    /**
     * @return The UV index.
     */
    public Integer getUvIndex() {
	return uvIndex;
    }

    /**
     * @param uvIndex The UV index.
     */
    public void setUvIndex(Integer uvIndex) {
	this.uvIndex = uvIndex;
    }

    /**
     * @return The UNIX time of when the maximum uvIndex occurs during a given day.
     */
    public Instant getUvIndexTime() {
	return uvIndexTime;
    }

    /**
     * @param uvIndexTime The UNIX time of when the maximum uvIndex occurs during a given day.
     */
    public void setUvIndexTime(Instant uvIndexTime) {
	this.uvIndexTime = uvIndexTime;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 59 * hash + Objects.hashCode(this.time);
	hash = 59 * hash + Objects.hashCode(this.summary);
	hash = 59 * hash + Objects.hashCode(this.icon);
	hash = 59 * hash + Objects.hashCode(this.sunriseTime);
	hash = 59 * hash + Objects.hashCode(this.sunsetTime);
	hash = 59 * hash + Objects.hashCode(this.moonPhase);
	hash = 59 * hash + Objects.hashCode(this.precipIntensity);
	hash = 59 * hash + Objects.hashCode(this.precipIntensityMax);
	hash = 59 * hash + Objects.hashCode(this.precipProbability);
	hash = 59 * hash + Objects.hashCode(this.precipIntensityMaxTime);
	hash = 59 * hash + Objects.hashCode(this.precipAccumulation);
	hash = 59 * hash + Objects.hashCode(this.precipType);
	hash = 59 * hash + Objects.hashCode(this.temperatureHigh);
	hash = 59 * hash + Objects.hashCode(this.temperatureHighTime);
	hash = 59 * hash + Objects.hashCode(this.temperatureLow);
	hash = 59 * hash + Objects.hashCode(this.temperatureLowTime);
	hash = 59 * hash + Objects.hashCode(this.apparentTemperatureHigh);
	hash = 59 * hash + Objects.hashCode(this.apparentTemperatureHighTime);
	hash = 59 * hash + Objects.hashCode(this.apparentTemperatureLow);
	hash = 59 * hash + Objects.hashCode(this.apparentTemperatureLowTime);
	hash = 59 * hash + Objects.hashCode(this.temperatureMin);
	hash = 59 * hash + Objects.hashCode(this.temperatureMinTime);
	hash = 59 * hash + Objects.hashCode(this.temperatureMax);
	hash = 59 * hash + Objects.hashCode(this.temperatureMaxTime);
	hash = 59 * hash + Objects.hashCode(this.apparentTemperatureMin);
	hash = 59 * hash + Objects.hashCode(this.apparentTemperatureMinTime);
	hash = 59 * hash + Objects.hashCode(this.apparentTemperatureMax);
	hash = 59 * hash + Objects.hashCode(this.apparentTemperatureMaxTime);
	hash = 59 * hash + Objects.hashCode(this.dewPoint);
	hash = 59 * hash + Objects.hashCode(this.humidity);
	hash = 59 * hash + Objects.hashCode(this.pressure);
	hash = 59 * hash + Objects.hashCode(this.windSpeed);
	hash = 59 * hash + Objects.hashCode(this.windGust);
	hash = 59 * hash + Objects.hashCode(this.windGustTime);
	hash = 59 * hash + Objects.hashCode(this.windBearing);
	hash = 59 * hash + Objects.hashCode(this.cloudCover);
	hash = 59 * hash + Objects.hashCode(this.uvIndex);
	hash = 59 * hash + Objects.hashCode(this.uvIndexTime);
	hash = 59 * hash + Objects.hashCode(this.visibility);
	hash = 59 * hash + Objects.hashCode(this.ozone);
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
	final DailyDataPoint other = (DailyDataPoint) obj;
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
	if (!Objects.equals(this.sunriseTime, other.sunriseTime)) {
	    return false;
	}
	if (!Objects.equals(this.sunsetTime, other.sunsetTime)) {
	    return false;
	}
	if (!Objects.equals(this.moonPhase, other.moonPhase)) {
	    return false;
	}
	if (!Objects.equals(this.precipIntensity, other.precipIntensity)) {
	    return false;
	}
	if (!Objects.equals(this.precipIntensityMax, other.precipIntensityMax)) {
	    return false;
	}
	if (!Objects.equals(this.precipProbability, other.precipProbability)) {
	    return false;
	}
	if (!Objects.equals(this.precipIntensityMaxTime, other.precipIntensityMaxTime)) {
	    return false;
	}
	if (!Objects.equals(this.precipAccumulation, other.precipAccumulation)) {
	    return false;
	}
	if (!Objects.equals(this.temperatureHigh, other.temperatureHigh)) {
	    return false;
	}
	if (!Objects.equals(this.temperatureHighTime, other.temperatureHighTime)) {
	    return false;
	}
	if (!Objects.equals(this.temperatureLow, other.temperatureLow)) {
	    return false;
	}
	if (!Objects.equals(this.temperatureLowTime, other.temperatureLowTime)) {
	    return false;
	}
	if (!Objects.equals(this.apparentTemperatureHigh, other.apparentTemperatureHigh)) {
	    return false;
	}
	if (!Objects.equals(this.apparentTemperatureHighTime, other.apparentTemperatureHighTime)) {
	    return false;
	}
	if (!Objects.equals(this.apparentTemperatureLow, other.apparentTemperatureLow)) {
	    return false;
	}
	if (!Objects.equals(this.apparentTemperatureLowTime, other.apparentTemperatureLowTime)) {
	    return false;
	}
	if (!Objects.equals(this.temperatureMin, other.temperatureMin)) {
	    return false;
	}
	if (!Objects.equals(this.temperatureMinTime, other.temperatureMinTime)) {
	    return false;
	}
	if (!Objects.equals(this.temperatureMax, other.temperatureMax)) {
	    return false;
	}
	if (!Objects.equals(this.temperatureMaxTime, other.temperatureMaxTime)) {
	    return false;
	}
	if (!Objects.equals(this.apparentTemperatureMin, other.apparentTemperatureMin)) {
	    return false;
	}
	if (!Objects.equals(this.apparentTemperatureMinTime, other.apparentTemperatureMinTime)) {
	    return false;
	}
	if (!Objects.equals(this.apparentTemperatureMax, other.apparentTemperatureMax)) {
	    return false;
	}
	if (!Objects.equals(this.apparentTemperatureMaxTime, other.apparentTemperatureMaxTime)) {
	    return false;
	}
	if (!Objects.equals(this.dewPoint, other.dewPoint)) {
	    return false;
	}
	if (!Objects.equals(this.humidity, other.humidity)) {
	    return false;
	}
	if (!Objects.equals(this.pressure, other.pressure)) {
	    return false;
	}
	if (!Objects.equals(this.windSpeed, other.windSpeed)) {
	    return false;
	}
	if (!Objects.equals(this.windGust, other.windGust)) {
	    return false;
	}
	if (!Objects.equals(this.windGustTime, other.windGustTime)) {
	    return false;
	}
	if (!Objects.equals(this.windBearing, other.windBearing)) {
	    return false;
	}
	if (!Objects.equals(this.cloudCover, other.cloudCover)) {
	    return false;
	}
	if (!Objects.equals(this.uvIndex, other.uvIndex)) {
	    return false;
	}
	if (!Objects.equals(this.uvIndexTime, other.uvIndexTime)) {
	    return false;
	}
	if (!Objects.equals(this.visibility, other.visibility)) {
	    return false;
	}
	return Objects.equals(this.ozone, other.ozone);
    }

}
