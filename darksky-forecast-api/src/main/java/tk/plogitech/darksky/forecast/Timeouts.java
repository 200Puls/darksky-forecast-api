/*
 * The MIT License
 *
 * Copyright 2018 Philipp-André Plogmann.
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

import java.time.Duration;
import java.util.Objects;
import static tk.plogitech.darksky.forecast.util.Assert.notNull;

/**
 * Represents the Request-Timeouts of a Forecast-request.
 *
 * @author Philipp-André Plogmann
 */
public class Timeouts {

    private final Duration connectionTimeout;
    private final Duration readTimeout;

    /**
     *
     * @param connectionTimeout The Duration of the timeout when opening the
     * connection. Use Duration.ZERO for no timeout. Or e.g.
     * Duration.ofSeconds(1) for any value.
     * @param readTimeout The Duration of the timeout when reading the forecast
     * data. Use Duration.ZERO for no timeout. Or e.g. Duration.ofSeconds(1) for
     * any value.
     */
    public Timeouts(Duration connectionTimeout, Duration readTimeout) {
	notNull("The connectionTimeout cannot be null.", connectionTimeout);
	notNull("The readTimeout cannot be null.", readTimeout);

	this.connectionTimeout = connectionTimeout;
	this.readTimeout = readTimeout;
    }

    /**
     * @return The Duration of the timeout when opening the connection.
     * Duration.ZERO for no timeout.
     */
    public Duration connectionTimeout() {

	return connectionTimeout;
    }

    /**
     * @return The Duration of the timeout when reading the forecast data.
     * Duration.ZERO for no timeout.
     */
    public Duration readTimeout() {
	return readTimeout;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 97 * hash + Objects.hashCode(this.connectionTimeout);
	hash = 97 * hash + Objects.hashCode(this.readTimeout);
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
	final Timeouts other = (Timeouts) obj;
	if (!Objects.equals(this.connectionTimeout, other.connectionTimeout)) {
	    return false;
	}
	if (!Objects.equals(this.readTimeout, other.readTimeout)) {
	    return false;
	}
	return true;
    }

}
