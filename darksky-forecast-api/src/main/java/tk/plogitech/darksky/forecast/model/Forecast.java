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
import java.util.List;
import java.util.Objects;

/**
 * Represents the response to a DarkSky forecast request.
 *
 * A Forecast object contains multiple data point for weather conditions (currently, hourly, daily, minutely).<br><br>
 *
 * For details see: https://darksky.net/dev/docs/response<br><br>
 *
 * A Forecast for a Time Machine request (historical data) is identical in structure to a Forecast Request, except:<br><br>
 *
 * The currently data point will refer to the time provided, rather than the current time. The minutely data block will be omitted, unless you are requesting a time within an hour
 * of the present.<br>
 * The hourly data block will contain data points starting at midnight (local time) of the day requested, and continuing until midnight (local time) of the following day. <br>
 * The daily data block will contain a single data point referring to the requested date.<br>
 * The alerts data block will be omitted.
 *
 * @author Puls
 */
public class Forecast implements Serializable {

    private Flags flags;
    private List<Alert> alerts;
    private Currently currently;
    private Daily daily;
    private Hourly hourly;
    private Minutely minutely;
    private String timezone;
    private Longitude longitude;
    private Latitude latitude;

    /**
     * @param longitude The requested longitude.
     */
    public void setLongitude(Longitude longitude) {
	this.longitude = longitude;
    }

    /**
     * @return The requested longitude.
     */
    public Longitude getLongitude() {
	return longitude;
    }

    /**
     * @param latitude The requested latitude.
     */
    public void setLatitude(Latitude latitude) {
	this.latitude = latitude;
    }

    /**
     * @return The requested latitude.
     */
    public Latitude getLatitude() {
	return latitude;
    }

    /**
     * @return An alerts List, which, if present, contains any severe weather alerts pertinent to the requested location.
     */
    public List<Alert> getAlerts() {
	return alerts;
    }

    /**
     * @param alerts An alerts List, which, if present, contains any severe weather alerts pertinent to the requested location.
     */
    public void setAlerts(List<Alert> alerts) {
	this.alerts = alerts;
    }

    /**
     * @param flags Optional flags object containing miscellaneous metadata about the request.
     */
    public void setFlags(Flags flags) {
	this.flags = flags;
    }

    /**
     * @return Optional flags object containing miscellaneous metadata about the request.
     */
    public Flags getFlags() {
	return flags;
    }

    /**
     * @param timezone The IANA timezone name for the requested location. This is used for text summaries and for determining when hourly and daily data block objects begin. (e.g.
     * America/New_York).
     *
     */
    public void setTimezone(String timezone) {
	this.timezone = timezone;
    }

    /**
     * @return The IANA timezone name for the requested location. This is used for text summaries and for determining when hourly and daily data block objects begin. (e.g.
     * America/New_York).
     */
    public String getTimezone() {
	return timezone;
    }

    /**
     * @param currently A data point containing the current weather conditions at the requested location.
     */
    public void setCurrently(Currently currently) {
	this.currently = currently;
    }

    /**
     * @return A data point containing the current weather conditions at the requested location.
     */
    public Currently getCurrently() {
	return currently;
    }

    /**
     * @return A data block containing the weather conditions day-by-day for the next week.
     */
    public Daily getDaily() {
	return daily;
    }

    /**
     * @param daily A data block containing the weather conditions day-by-day for the next week.
     */
    public void setDaily(Daily daily) {
	this.daily = daily;
    }

    /**
     * @return A data block containing the weather conditions hour-by-hour for the next two days.
     */
    public Hourly getHourly() {
	return hourly;
    }

    /**
     * @param hourly A data block containing the weather conditions hour-by-hour for the next two days.
     */
    public void setHourly(Hourly hourly) {
	this.hourly = hourly;
    }

    /**
     * @return A data block containing the weather conditions minute-by-minute for the next hour.
     */
    public Minutely getMinutely() {
	return minutely;
    }

    /**
     * @param minutely A data block containing the weather conditions minute-by-minute for the next hour.
     */
    public void setMinutely(Minutely minutely) {
	this.minutely = minutely;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 47 * hash + Objects.hashCode(this.flags);
	hash = 47 * hash + Objects.hashCode(this.alerts);
	hash = 47 * hash + Objects.hashCode(this.currently);
	hash = 47 * hash + Objects.hashCode(this.daily);
	hash = 47 * hash + Objects.hashCode(this.hourly);
	hash = 47 * hash + Objects.hashCode(this.minutely);
	hash = 47 * hash + Objects.hashCode(this.timezone);
	hash = 47 * hash + Objects.hashCode(this.longitude);
	hash = 47 * hash + Objects.hashCode(this.latitude);
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
	final Forecast other = (Forecast) obj;
	if (!Objects.equals(this.timezone, other.timezone)) {
	    return false;
	}
	if (!Objects.equals(this.flags, other.flags)) {
	    return false;
	}
	if (!Objects.equals(this.alerts, other.alerts)) {
	    return false;
	}
	if (!Objects.equals(this.currently, other.currently)) {
	    return false;
	}
	if (!Objects.equals(this.daily, other.daily)) {
	    return false;
	}
	if (!Objects.equals(this.hourly, other.hourly)) {
	    return false;
	}
	if (!Objects.equals(this.minutely, other.minutely)) {
	    return false;
	}
	if (!Objects.equals(this.longitude, other.longitude)) {
	    return false;
	}
	return Objects.equals(this.latitude, other.latitude);
    }

}
