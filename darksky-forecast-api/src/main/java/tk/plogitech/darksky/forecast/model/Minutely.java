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
 * A data block containing the weather conditions minute-by-minute for the next
 * hour.
 *
 * @author Puls
 */
public class Minutely implements Serializable {

    private String summary;
    private String icon;
    private List<DataPoint> data;

    /**
     * @return A human-readable summary of this data block.
     */
    public String getSummary() {
	return summary;
    }

    /**
     * @param summary A human-readable summary of this data block.
     */
    public void setSummary(String summary) {
	this.summary = summary;
    }

    /**
     * @return A machine-readable text summary of this data block. (May take on
     * the same values as the iconproperty of data points.)
     */
    public String getIcon() {
	return icon;
    }

    /**
     * @param icon A machine-readable text summary of this data block. (May take
     * on the same values as the iconproperty of data points.)
     */
    public void setIcon(String icon) {
	this.icon = icon;
    }

    /**
     * @return List containing all DataPoints, ordered by time.
     */
    public List<DataPoint> getData() {
	return data;
    }

    /**
     * @param data List containing all DataPoints, ordered by time.
     */
    public void setData(List<DataPoint> data) {
	this.data = data;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 97 * hash + Objects.hashCode(this.summary);
	hash = 97 * hash + Objects.hashCode(this.icon);
	hash = 97 * hash + Objects.hashCode(this.data);
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
	final Minutely other = (Minutely) obj;
	if (!Objects.equals(this.summary, other.summary)) {
	    return false;
	}
	if (!Objects.equals(this.icon, other.icon)) {
	    return false;
	}
	return Objects.equals(this.data, other.data);
    }
}
