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
package pap.darksky.forecast;

import static pap.darksky.forecast.util.Assert.notNull;

/**
 * Represents GeoCoordinates for a location.
 *
 * @author Puls
 */
public class GeoCoordinates {

    private final Longitude longitude;
    private final Latitude latitude;

    /**
     * @param longitude The Longitude of the place represented by this GeoCoordinate.
     * @param latitude The Latitude of the place represented by this GeoCoordinate.
     */
    public GeoCoordinates(Longitude longitude, Latitude latitude) {
        notNull("The Latitude cannot be null.", latitude);
        notNull("The Longitude cannot be null.", longitude);

        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * @return The Longitude of the place represented by this GeoCoordinate.
     */
    public Longitude longitude() {
        return longitude;
    }

    /**
     * @return The Latitude of the place represented by this GeoCoordinate.
     */
    public Latitude latitude() {
        return latitude;
    }
}
