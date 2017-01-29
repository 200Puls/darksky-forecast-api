package pap.darksky.forecast;

import java.net.URL;
import static pap.darkysky.forecast.util.Assert.nonNull;

/**
 * Represents a single Request.
 *
 * @author Puls
 */
public class ForecastRequest {

    private final URL url;

    /**
     * @param url The URL which contains the parameters to request the weather forecast.
     */
    ForecastRequest(URL url) {
        nonNull("URL cannot be null.", url);

        this.url = url;
    }

    /**
     * @return The URL which contains the parameters to request the weather forecast.
     */
    public URL getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ForecastRequest{" + "url=" + url + '}';
    }

}
