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
 * The flags object contains various metadata information related to the request.
 *
 * This properties of this object are optional.
 *
 * @author Puls
 */
public class Flags implements Serializable {

    private String units;
    private boolean darkskyUnavailable;
    private boolean metnoLicense;
    private List<String> sources;

    /**
     * @param units Indicates the units which were used for the data in this request.
     */
    public void setUnits(String units) {
        this.units = units;
    }

    /**
     * @return Indicates the units which were used for the data in this request.
     */
    public String getUnits() {
        return units;
    }

    /**
     * @return The presence of this property indicates that the Dark Sky data source supports the given location, but a temporary
     * error (such as a radar station being down for maintenance) has made the data unavailable.
     */
    public boolean isDarkskyUnavailable() {
        return darkskyUnavailable;
    }

    /**
     * @param darkskyUnavailable The presence of this property indicates that the Dark Sky data source supports the given
     * location, but a temporary error (such as a radar station being down for maintenance) has made the data unavailable.
     */
    public void setDarkskyUnavailable(boolean darkskyUnavailable) {
        this.darkskyUnavailable = darkskyUnavailable;
    }

    /**
     * @return The presence of this property indicates that data from api.met.no was utilized in order to facilitate this request
     * (as per their license agreement).
     */
    public boolean isMetnoLicense() {
        return metnoLicense;
    }

    /**
     * @param metnoLicense The presence of this property indicates that data from api.met.no was utilized in order to facilitate
     * this request (as per their license agreement).
     */
    public void setMetnoLicense(boolean metnoLicense) {
        this.metnoLicense = metnoLicense;
    }

    /**
     * @return This property contains an array of IDs for each data source utilized in servicing this request.
     */
    public List<String> getSources() {
        return sources;
    }

    /**
     * @param sources This property contains an array of IDs for each data source utilized in servicing this request.
     */
    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.units);
        hash = 71 * hash + (this.darkskyUnavailable ? 1 : 0);
        hash = 71 * hash + (this.metnoLicense ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.sources);
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
        final Flags other = (Flags) obj;
        if (this.darkskyUnavailable != other.darkskyUnavailable) {
            return false;
        }
        if (this.metnoLicense != other.metnoLicense) {
            return false;
        }
        if (!Objects.equals(this.units, other.units)) {
            return false;
        }
        return Objects.equals(this.sources, other.sources);
    }

}
