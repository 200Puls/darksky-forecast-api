package pap.darksky.forecast;

import static pap.darkysky.forecast.util.Assert.nonNull;

/**
 * Represents the Longitude of a GeoCordinate of a physical place on earth.
 *
 * @author Puls
 */
public class Longitude {

    private final Double value;

    /**
     * @param value The Longitude value.
     */
    public Longitude(Double value) {
        nonNull("The Longitude value cannot be null.", value);

        this.value = value;
    }

    /**
     * @return The Longitude value.
     */
    public Double value() {
        return value;
    }
}
