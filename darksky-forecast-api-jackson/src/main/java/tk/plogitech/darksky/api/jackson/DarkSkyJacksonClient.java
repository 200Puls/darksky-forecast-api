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
package tk.plogitech.darksky.api.jackson;

import com.fasterxml.jackson.core.JsonParser;
import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_GETTERS;
import static com.fasterxml.jackson.databind.MapperFeature.REQUIRE_SETTERS_FOR_GETTERS;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.io.InputStream;
import static java.util.logging.Level.FINE;
import java.util.logging.Logger;
import tk.plogitech.darksky.forecast.APIKey;
import tk.plogitech.darksky.forecast.DarkSkyClient;
import tk.plogitech.darksky.forecast.ForecastException;
import tk.plogitech.darksky.forecast.ForecastRequest;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder;
import tk.plogitech.darksky.forecast.GeoCoordinates;
import tk.plogitech.darksky.forecast.model.Forecast;
import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;
import static tk.plogitech.darksky.forecast.util.Assert.notNull;

/**
 * Client to fetch weather data from the DarkSky API which uses the Jackson
 * library to parse the JSON response into JavaBean objects.
 *
 * @author Puls
 */
public class DarkSkyJacksonClient extends DarkSkyClient {

    private static final Logger logger = Logger.getLogger(DarkSkyJacksonClient.class.getSimpleName());
    private static final ObjectMapper mapper = objectMapper();

    /**
     * Returns the forecast as {@link Forecast} object parsed by Jackson.
     *
     * @param request The Forecast Request which is executed. Use
     * {@link ForecastRequestBuilder} to build the request.
     * @return The forecast parsed as {@link Forecast}.
     *
     * @throws ForecastException if the forecast cannot be fetched.
     */
    public Forecast forecast(ForecastRequest request) throws ForecastException {
        notNull("The ForecastRequest cannot be null.", request);
        logger.log(FINE, "Executing Forecat request: {0}", request);

        try (InputStream is = executeForecastRequest(request)) {
            return mapper.readValue(is, Forecast.class);

        } catch (IOException e) {
            throw new ForecastException("Forecast cannot be fetched.", e);
        }
    }

    static ObjectMapper objectMapper() {
        ObjectMapper result = new ObjectMapper();
        result.registerModule(new JavaTimeModule());
        result.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES);
        result.configure(REQUIRE_SETTERS_FOR_GETTERS, false);
        result.configure(AUTO_DETECT_GETTERS, true);
        result.configure(INDENT_OUTPUT, true);
        result.configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        return result;
    }

    public static void main(String[] args) throws ForecastException {
        if (args.length != 3) {
            System.err.println("Please provide yout API-Key and a Longitude / Latitrude combination. Usage as follows: '<your-secret-key> <longitude> <latitude>");
            System.exit(1);
        }
        String apikey = args[0];
        String latitude = args[1];
        String longitude = args[2];

        ForecastRequest request = new ForecastRequestBuilder()
                .key(new APIKey(apikey))
                .location(new GeoCoordinates(new Longitude(Double.valueOf(latitude)), new Latitude(Double.valueOf(longitude)))).build();

        DarkSkyJacksonClient client = new DarkSkyJacksonClient();
        Forecast forecast = client.forecast(request);
        System.out.println("The current weather: " + forecast.getCurrently().getSummary());
    }
}
