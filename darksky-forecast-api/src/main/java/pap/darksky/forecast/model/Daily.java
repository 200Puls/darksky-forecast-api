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

import java.util.List;
import java.util.Objects;

/**
 * Represents the forecast for a whole day.
 *
 * @author Puls
 */
public class Daily {

    private String summary;
    private String icon;
    private List<DailyDataPoint> data;

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
     * @return A machine-readable text summary of this data block. (May take on the same values as the iconproperty of data
     * points.)
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon A machine-readable text summary of this data block. (May take on the same values as the iconproperty of data
     * points.)
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return List containing all DataPoints, ordered by time.
     */
    public List<DailyDataPoint> getData() {
        return data;
    }

    /**
     * @param data List containing all DataPoints, ordered by time.
     */
    public void setData(List<DailyDataPoint> data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.summary);
        hash = 41 * hash + Objects.hashCode(this.icon);
        hash = 41 * hash + Objects.hashCode(this.data);
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
        final Daily other = (Daily) obj;
        if (!Objects.equals(this.summary, other.summary)) {
            return false;
        }
        if (!Objects.equals(this.icon, other.icon)) {
            return false;
        }
        return Objects.equals(this.data, other.data);
    }

}
