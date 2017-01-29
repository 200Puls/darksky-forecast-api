package pap.darksky.forecast;

import static pap.darkysky.forecast.util.Assert.nonNull;

/**
 * Represents GeoCoordinates which identify one exact place for which a weather forecast is returned..
 *
 * @author Puls
 */
public class GeoCoordinates {

    private final Longitude longitude;
    private final Latitude latitude;

    public GeoCoordinates(Longitude longitude, Latitude latitude) {
        nonNull("The Latitude cannot be null.", latitude);
        nonNull("The Longitude cannot be null.", longitude);

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
