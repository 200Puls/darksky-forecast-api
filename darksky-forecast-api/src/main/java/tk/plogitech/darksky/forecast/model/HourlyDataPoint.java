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

import java.util.Objects;

/**
 * DataPoint for the data of a single hour.
 *
 * @author Puls
 */
public class HourlyDataPoint extends DataPoint {

    private Double precipAccumulation;

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

    @Override
    public int hashCode() {
	int hash = super.hashCode();
	hash = 43 * hash + Objects.hashCode(this.precipAccumulation);
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
	if (!super.equals(obj)) {
	    return false;
	}
	final HourlyDataPoint other = (HourlyDataPoint) obj;
	return Objects.equals(this.precipAccumulation, other.precipAccumulation);
    }

}
