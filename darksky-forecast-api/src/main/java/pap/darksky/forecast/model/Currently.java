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
package pap.darksky.forecast.model;

/**
 * A data point containing the current weather conditions at the requested location.
 *
 * @author Puls
 */
public class Currently extends DataPoint {

    private Double nearestStormBearing;
    private Double nearestStormDistance;

    /**
     * @return The approximate direction of the nearest storm in degrees, with true north at 0° and progressing clockwise. (If
     * nearestStormDistance is zero, then this value will not be defined.) optional, only on currently
     */
    public Double getNearestStormBearing() {
        return nearestStormBearing;
    }

    /**
     * @param nearestStormBearing The approximate direction of the nearest storm in degrees, with true north at 0° and progressing
     * clockwise. (If nearestStormDistance is zero, then this value will not be defined.) optional, only on currently
     */
    public void setNearestStormBearing(Double nearestStormBearing) {
        this.nearestStormBearing = nearestStormBearing;
    }

    /**
     * @return The approximate distance to the nearest storm in miles. (A storm distance of 0 doesn’t necessarily refer to a storm
     * at the requested location, but rather a storm in the vicinity of that location.)
     */
    public Double getNearestStormDistance() {
        return nearestStormDistance;
    }

    /**
     * @param nearestStormDistance The approximate distance to the nearest storm in miles. (A storm distance of 0 doesn’t
     * necessarily refer to a storm at the requested location, but rather a storm in the vicinity of that location.)
     */
    public void setNearestStormDistance(Double nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }

}
