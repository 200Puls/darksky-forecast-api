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
package tk.plogitech.darksky.forecast;

import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import static tk.plogitech.darksky.forecast.util.Assert.notNull;
import tk.plogitech.darksky.forecast.util.IOUtil;

/**
 * Client to fetch weather data from the DarkSky API.
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
        notNull("The ForecastRequest cannot be null.", request);
        logger.log(Level.FINE, "Executing Forecat request: {0}", request);

        return executeForecastRequest(request);
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
        notNull("The ForecastRequest cannot be null.", request);

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
        notNull("The ForecastRequest cannot be null.", request);
        logger.log(Level.FINE, "Executing Forecat request: {0}", request);

        try (InputStream is = executeForecastRequest(request)) {
            return IOUtil.readFully(is);

        } catch (IOException e) {
            throw new ForecastException("Forecast cannot be fetched.", e);
        }
    }

    protected InputStream executeForecastRequest(ForecastRequest request) throws ForecastException {
        notNull("The ForecastRequest cannot be null.", request);
        
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) request.getUrl().openConnection();
            connection.setDoOutput(false);
            connection.setConnectTimeout(request.getTimeout());
            connection.setReadTimeout(request.getTimeout());
            return connection.getInputStream();
        } catch (IOException ex) {
            String errorMessage = "Forecast cannot be fetched.";
            if (connection != null && connection.getErrorStream() != null) {
                try {
                    connection.getErrorStream().close();
                    connection.disconnect();
                    errorMessage = errorMessage + " Status: " + connection.getResponseCode() + " " + connection.getResponseMessage();
                } catch (IOException e) {
                    logger.log(Level.SEVERE, "Error closing errorstream.", e);
                }
            }
            throw new ForecastException(errorMessage, ex);
        }
    }

    public static void main(String[] args) throws ForecastException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Please provide your APIKey as argument");
        }
        
        ForecastRequest request = new ForecastRequestBuilder()
                .key(new APIKey(args[0]))
                .location(new GeoCoordinates(new Longitude(-130.377704), new Latitude(89.516275))).build();

        DarkSkyClient client = new DarkSkyClient();
        String forecast = client.forecastJsonString(request);
        System.out.println("forecast " + forecast);
    }
}
