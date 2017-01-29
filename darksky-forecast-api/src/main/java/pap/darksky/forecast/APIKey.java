package pap.darksky.forecast;

import static pap.darkysky.forecast.util.Assert.notNullOrEmpty;

/**
 * Represents the authentication Key for DarkSky API.
 *
 * @author Puls
 */
public class APIKey {

    private final String value;

    /**
     * @param value The Key value as String.
     */
    public APIKey(String value) {
        notNullOrEmpty("The API-Key cannot be null or empty.", value);
        
        this.value = value;
    }

    /**
     * @return The Key value as String.
     */
    public String value() {
        return value;
    }

}
