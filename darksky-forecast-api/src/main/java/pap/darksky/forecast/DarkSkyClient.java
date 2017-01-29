package pap.darksky.forecast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pap.darkysky.forecast.util.Assert.nonNull;

/**
 * Client which provides weather forecast information using DarkSky API.
 *
 * @author Puls
 */
public class DarkSkyClient {

    private static final Logger logger = Logger.getLogger(DarkSkyClient.class.getSimpleName());

    /**
     * Returns the forecast response as String.
     *
     * @param request The Forecast Request which is executed. Use {@link ForecastRequestBuilder} to build the request.
     * @return The forecast unparsed as byte encoded Json.
     *
     * @throws ForecastException if the forecast cannot be fetched.
     */
    public InputStream forecastJsonStream(ForecastRequest request) throws ForecastException {
        nonNull("The ForecastRequest cannot be null.", request);
        logger.log(Level.FINE, "Executing Forecat request: {0}", request);

        return executeRawForecastRequest(request.getUrl());
    }

    /**
     * Returns the forecast response as String.
     *
     * @param request The Forecast Request which is executed. Use {@link ForecastRequestBuilder} to build the request.
     * @return The forecast unparsed as byte encoded Json.
     *
     * @throws ForecastException if the forecast cannot be fetched.
     */
    public String forecastJsonString(ForecastRequest request) throws ForecastException {
        nonNull("The ForecastRequest cannot be null.", request);

        return new String(forecastJsonBytes(request));
    }

    /**
     * Returns the forecast response as bytes.
     *
     * @param request The Forecast Request which is executed. Use {@link ForecastRequestBuilder} to build the request.
     * @return The forecast unparsed as byte encoded Json.
     *
     * @throws ForecastException if the forecast cannot be fetched.
     */
    public byte[] forecastJsonBytes(ForecastRequest request) throws ForecastException {
        nonNull("The ForecastRequest cannot be null.", request);
        logger.log(Level.FINE, "Executing Forecat request: {0}", request);

        try {
            try (InputStream is = executeRawForecastRequest(request.getUrl())) {
                return readFully(is, -1, true);
            }
        } catch (IOException e) {
            throw new ForecastException("Forecast cannot be fetched.", e);
        }
    }

    protected InputStream executeRawForecastRequest(URL forecastUrl) throws ForecastException {
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) forecastUrl.openConnection();
            connection.setDoOutput(false);
            connection.setConnectTimeout(6000);
            connection.setReadTimeout(6000);
            return connection.getInputStream();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Error while doing forecast request.", ex);
            if (connection != null && connection.getErrorStream() != null) {
                try {
                    connection.getErrorStream().close();
                    connection.disconnect();
                } catch (IOException e) {
                    logger.log(Level.SEVERE, "Error closing errorstream.", e);
                }
            }
            throw new ForecastException("Forecast cannot be fetched.", ex);
        }
    }

    /**
     * TODO: Very performant copy of sun.misc.IOUtils.
     *
     * Replace with Java 9 version.
     */
    private static byte[] readFully(InputStream is, int length, boolean readAll) throws IOException {
        byte[] output = {};
        if (length == -1) {
            length = Integer.MAX_VALUE;
        }
        int pos = 0;
        while (pos < length) {
            int bytesToRead;
            if (pos >= output.length) { // Only expand when there's no room
                bytesToRead = Math.min(length - pos, output.length + 1024);
                if (output.length < pos + bytesToRead) {
                    output = Arrays.copyOf(output, pos + bytesToRead);
                }
            } else {
                bytesToRead = output.length - pos;
            }
            int cc = is.read(output, pos, bytesToRead);
            if (cc < 0) {
                if (readAll && length != Integer.MAX_VALUE) {
                    throw new IllegalStateException("Detect premature EOF");
                } else {
                    if (output.length != pos) {
                        output = Arrays.copyOf(output, pos);
                    }
                    break;
                }
            }
            pos += cc;
        }
        return output;
    }

    public static void main(String[] args) throws ForecastException {
        ForecastRequest request = new ForecastRequestBuilder()
                .key(new APIKey("your-private-key"))
                .location(new GeoCoordinates(new Longitude(13.377704), new Latitude(52.516275))).build();

        DarkSkyClient client = new DarkSkyClient();
        String forecast = client.forecastJsonString(request);
        System.out.println("forecast " + forecast);
    }
}
