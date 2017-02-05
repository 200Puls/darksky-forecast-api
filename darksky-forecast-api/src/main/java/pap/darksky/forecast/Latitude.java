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
 * Represents the Latitude of a GeoCordinate of a physical place on earth.
 *
 * @author Puls
 */
public class Latitude {

    private final Double value;

    /**
     * @param value The Latitude value.
     */
    public Latitude(Double value) {
        notNull("The Latitude value cannot be null.", value);
        if (value < -90 || value > 90) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90. Latitude value invalid: " + value);
        }
        
        this.value = value;
    }

    /**
     * @return The Latitude value.
     */
    public Double value() {
        return value;
    }

}
