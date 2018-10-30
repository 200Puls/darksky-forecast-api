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
 * Represents the Longitude of a GeoCordinate of a location.
 *
 * @author Puls
 */
public class Longitude implements Serializable {

    private final Double value;

    /**
     * @param value The longitude of a location (in decimal degrees). Positive
     * is east, negative is west.
     */
    public Longitude(Double value) {
        notNull("The Longitude value cannot be null.", value);
        if (value < -180 || value > 180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180. Longitude value invalid: " + value);
        }

        this.value = value;
    }

    /**
     * @param value The longitude of a location (in decimal degrees). Positive
     * is east, negative is west.
     */
    public Longitude(Integer value) {
        notNull("The Longitude value cannot be null.", value);
        if (value < -180 || value > 180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180. Longitude value invalid: " + value);
        }

        this.value = value.doubleValue();
    }

    /**
     * @return The longitude of a location (in decimal degrees). Positive is
     * east, negative is west.
     */
    public Double value() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.value);
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
        final Longitude other = (Longitude) obj;
        return Objects.equals(this.value, other.value);
    }
}
