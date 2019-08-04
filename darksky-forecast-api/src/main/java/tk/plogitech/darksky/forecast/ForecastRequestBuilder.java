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
package tk.plogitech.darksky.forecast;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import static tk.plogitech.darksky.forecast.util.Assert.notNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * Builder to create {@link ForecastRequest} objects.
 *
 * @author Puls
 */
public class ForecastRequestBuilder {

    private static final Timeouts DEFAULT_TIMEOUTS = new Timeouts(Duration.ofSeconds(6), Duration.ofSeconds(6));
    private static final String URL = "https://api.darksky.net/forecast/##key##/##latitude##,##longitude####time##";
    private final List<Block> exclusion = new ArrayList<>();
    private Language language = Language.de;
    private Units units = Units.si;
    private String overrideUrl;
    private boolean extendHourly;
    private GeoCoordinates geoCoordinates;
    private APIKey apiKey;
    private Instant time;
    private Timeouts timeouts = DEFAULT_TIMEOUTS;

    /**
     * @param apiKey Your Dark Sky secret key. (Your secret key must be kept secret; in particular, do not embed it in JavaScript source code that you
     * transmit to clients.)
     * @return This for fluent API.
     */
    public ForecastRequestBuilder key(APIKey apiKey) {
	notNull("APIKey cannot be null.", apiKey);

	this.apiKey = apiKey;
	return this;
    }

    /**
     * @param geoCoordinates The Geo coordinates of a location for which the weather forecast is requested.
     * @return This for fluent API.
     */
    public ForecastRequestBuilder location(GeoCoordinates geoCoordinates) {
	notNull("GeoCoordinates cannot be null.", geoCoordinates);

	this.geoCoordinates = geoCoordinates;
	return this;
    }

    /**
     * @param url Override the default DarksSky API Url. The URL must contain the following patterns for the key and gelocation:<br>
     *
     * ##key## ##latitude## ##longitude##
     *
     * @return This for fluent API.
     */
    public ForecastRequestBuilder url(String url) {
	notNull("url cannot be null.", url);

	this.overrideUrl = url;
	return this;
    }

    /**
     * @param language The summary properties are returned in the desired language. (Note that units in the summary will be set according to the units
     * parameter, so be sure to set both parameters appropriately.)
     * @return This for fluent API.
     */
    public ForecastRequestBuilder language(Language language) {
	notNull("language cannot be null.", language);

	this.language = language;
	return this;
    }

    /**
     * When set, return hour-by-hour data for the next 168 hours, instead of the next 48. When using this option, we strongly recommend enabling HTTP
     * compression.
     *
     * @return This for fluent API.
     */
    public ForecastRequestBuilder extendHourly() {
	this.extendHourly = true;
	return this;
    }

    /**
     * @param block The Blocks which shall be excluded from the response to save data / latency. This method can be called multiple times and the
     * exclusion will add up.
     * @return This for fluent API.
     */
    public ForecastRequestBuilder exclude(Block... block) {
	this.exclusion.addAll(Arrays.asList(block));
	return this;
    }

    /**
     * @param units Return weather conditions in the requested units.
     * @return This for fluent API.
     */
    public ForecastRequestBuilder units(Units units) {
	notNull("units cannot be null.", units);

	this.units = units;
	return this;
    }

    /**
     * @param time The Time for which the historical weather data is returned.
     * @return This for fluent API.
     */
    public ForecastRequestBuilder time(Instant time) {
	notNull("time cannot be null.", time);

	this.time = time;
	return this;
    }

    /**
     * @param timeouts Override the default timeouts (6 seconds) for connection to the API and reading from the API.
     * @return This for fluent API.
     */
    public ForecastRequestBuilder timeouts(Timeouts timeouts) {
	notNull("timeouts cannot be null.", timeouts);

	this.timeouts = timeouts;
	return this;
    }

    /**
     * @return The Request with the given parameters set.
     */
    public ForecastRequest build() {
	try {
	    return new ForecastRequest(getUrl(), timeouts);
	} catch (MalformedURLException ex) {
	    throw new IllegalArgumentException("Cannot create Forecast Request. The provided URL is invalid!", ex);
	}
    }

    /**
     * @return The Url build from the given paramters.
     * @throws MalformedURLException
     */
    private URL getUrl() throws MalformedURLException {
	notNull("The ApIkey must be set. Please call the corresponding method.", apiKey);
	notNull("The Gelocation must be set. Please call the corresponding method.", geoCoordinates);

	String forecastUrlString = URL;
	if (overrideUrl != null) {
	    forecastUrlString = overrideUrl;
	}

	String unixTimestamp = "";
	if (time != null) {
	    unixTimestamp = "," + String.valueOf(time.getEpochSecond());
	}

	forecastUrlString = forecastUrlString.replaceAll("##key##", apiKey.value())
		.replaceAll("##latitude##", String.valueOf(geoCoordinates.latitude().toString()))
		.replaceAll("##longitude##", String.valueOf(geoCoordinates.longitude().toString()))
		.replaceAll("##time##", unixTimestamp)
		+ requuestParamtersAsString();

	return new URL(forecastUrlString);
    }

    /**
     * @return The RequestParamters as String formatted so that they can be added to the vase forecast url.
     */
    private String requuestParamtersAsString() {
	StringBuilder paramBuilder = new StringBuilder("?");
	if (language != null) {
	    paramBuilder.append(RequestParmaterType.lang.name());
	    paramBuilder.append("=");
	    paramBuilder.append(language.name());
	    paramBuilder.append("&");
	}
	if (units != null) {
	    paramBuilder.append(RequestParmaterType.units.name());
	    paramBuilder.append("=");
	    paramBuilder.append(units.name());
	    paramBuilder.append("&");
	}
	if (!exclusion.isEmpty()) {
	    paramBuilder.append(RequestParmaterType.exclude.name());
	    paramBuilder.append("=");
	    StringJoiner joiner = new StringJoiner(",");
	    exclusion.stream().forEach(s -> joiner.add(s.name()));
	    paramBuilder.append(joiner.toString());
	    paramBuilder.append("&");
	}
	if (extendHourly) {
	    paramBuilder.append(RequestParmaterType.extend.name());
	    paramBuilder.append("=");
	    paramBuilder.append(Block.hourly.name());
	    paramBuilder.append("&");
	}
	return paramBuilder.substring(0, paramBuilder.length() - 1);
    }

    /**
     * The available Languages in which the forecast response is translated.
     */
    public enum Language {
	/**
	 * Arabic
	 */
	ar,
	/**
	 * Azerbaijani
	 */
	az,
	/**
	 * Belarusian
	 */
	be,
	/**
	 * Bosnian
	 */
	bs,
	/**
	 * Catalan
	 */
	ca,
	/**
	 * Czech
	 */
	cs,
	/**
	 * German
	 */
	de,
	/**
	 * Greek
	 */
	el,
	/**
	 * English (which is the default)
	 */
	en,
	/**
	 * Spanish
	 */
	es,
	/**
	 * Estonian
	 */
	et,
	/**
	 * French
	 */
	fr,
	/**
	 * Croatian
	 */
	hr,
	/**
	 * Hungarian
	 */
	hu,
	/**
	 * Indonesian
	 */
	id,
	/**
	 * Italian
	 */
	it,
	/**
	 * Icelandic
	 */
	is,
	/**
	 * Cornish
	 */
	kw,
	/**
	 * Norwegian Bokmål
	 */
	nb,
	/**
	 * Dutch
	 */
	nl,
	/**
	 * Polish
	 */
	pl,
	/**
	 * Portuguese
	 */
	pt, /**
	 * Russian
	 */
	ru,
	/**
	 * Slovak
	 */
	sk,
	/**
	 * Slovenian
	 */
	sl,
	/**
	 * Serbian
	 */
	sr,
	/**
	 * Swedish
	 */
	sv,
	/**
	 * Tetum
	 */
	tet,
	/**
	 * Turkish
	 */
	tr,
	/**
	 * Ukrainian
	 */
	uk,
	/**
	 * simplified Chinese
	 */
	zh,
    }

    /**
     * The blocks of the forecast response which can be excluded.
     */
    public enum Block {
	currently,
	minutely,
	hourly,
	daily,
	alerts,
	flags,
    }

    public enum Units {
	/**
	 * automatically select units based on geographic location
	 */
	auto,
	/**
	 * same as si, except that windSpeed is in kilometers per hour
	 */
	ca,
	/**
	 * SI units are as follows: summary: Any summaries containing temperature or snow accumulation units will have their values in degrees Celsius
	 * or in centimeters (respectively). <br>
	 * summary: Any summaries containing temperature or snow accumulation units will have their values in degrees Celsius or in centimeters
	 * (respectively).<br>
	 * nearestStormDistance: Kilometers.<br>
	 * precipIntensity: Millimeters per hour.<br>
	 * precipIntensityMax: Millimeters per hour.<br>
	 * precipAccumulation: Centimeters.<br>
	 * temperature: Degrees Celsius. <br>
	 * temperatureMin: Degrees Celsius. <br>
	 * temperatureMax: Degrees Celsius. <br>
	 * apparentTemperature: Degrees Celsius. <br>
	 * dewPoint: Degrees Celsius. <br>
	 * windSpeed: Meters per second. <br>
	 * windGust: Meters per second. pressure: Hectopascals.<br>
	 * visibility: Kilometers.<br>
	 */
	si,
	/**
	 * same as si, except that nearestStormDistance and visibility are in miles and windSpeed is in miles per hour
	 */
	uk2,
	/**
	 * Imperial units (the default)
	 */
	us
    }

    private enum RequestParmaterType {
	exclude,
	extend,
	lang,
	units
    }
}
