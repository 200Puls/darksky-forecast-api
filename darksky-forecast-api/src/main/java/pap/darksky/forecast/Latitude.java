package pap.darksky.forecast;

import static pap.darkysky.forecast.util.Assert.nonNull;

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
        nonNull("The Latitude value cannot be null.", value);

        this.value = value;
    }

    /**
     * @return The Latitude value.
     */
    public Double value() {
        return value;
    }

}
