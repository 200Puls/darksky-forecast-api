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
import java.util.Objects;
import static tk.plogitech.darksky.forecast.util.Assert.notNull;

/**
 * Represents the Latitude of a GeoCordinate of a location.
 *
 * @author Puls
 */
public class Latitude implements Serializable {

    private final Double value;

    /**
     * @param value The latitude of a location (in decimal degrees). Positive is north, negative is south.
     */
    public Latitude(Double value) {
	notNull("The Latitude value cannot be null.", value);
	if (value < -90 || value > 90) {
	    throw new IllegalArgumentException("Latitude must be between -90 and 90. Latitude value invalid: " + value);
	}

	this.value = value;
    }

    /**
     * @param value The latitude of a location (in decimal degrees). Positive is north, negative is south.
     */
    public Latitude(Integer value) {
	notNull("The Latitude value cannot be null.", value);
	if (value < -180 || value > 180) {
	    throw new IllegalArgumentException("Latitude must be between -90 and 90. Latitude value invalid: " + value);
	}

	this.value = value.doubleValue();
    }

    /**
     * @return The latitude of a location (in decimal degrees). Positive is north, negative is south.
     */
    public Double value() {
	return value;
    }

    /**
     * @return String correctly formatted ("-0.000066" instead of "-6.6E-5").
     */
    @Override
    public String toString() {
	return String.format("%f", value);
    }

    @Override
    public int hashCode() {
	int hash = 3;
	hash = 17 * hash + Objects.hashCode(this.value);
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
	final Latitude other = (Latitude) obj;
	return Objects.equals(this.value, other.value);
    }
}
