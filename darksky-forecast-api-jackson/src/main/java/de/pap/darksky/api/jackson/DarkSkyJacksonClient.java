package de.pap.darksky.api.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import static com.fasterxml.jackson.databind.MapperFeature.AUTO_DETECT_GETTERS;
import static com.fasterxml.jackson.databind.MapperFeature.REQUIRE_SETTERS_FOR_GETTERS;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import pap.darksky.forecast.APIKey;
import pap.darksky.forecast.DarkSkyClient;
import pap.darksky.forecast.ForecastException;
import pap.darksky.forecast.ForecastRequest;
import pap.darksky.forecast.ForecastRequestBuilder;
import pap.darksky.forecast.GeoCoordinates;
import pap.darksky.forecast.Latitude;
import pap.darksky.forecast.Longitude;
import pap.darksky.forecast.model.Forecast;
import static pap.darkysky.forecast.util.Assert.nonNull;

/**
 * Service for DarkSky weather forecast API which uses Jackson to parse the response into JavaBean objects.
 *
 * @author Puls
 */
public class DarkSkyJacksonClient extends DarkSkyClient {

    private static final Logger logger = Logger.getLogger(DarkSkyJacksonClient.class.getSimpleName());
    private final ObjectMapper mapper = objectMapper();

    /**
     * Returns the forecast as {@link Forecast} object parsed by Jackson.
     *
     * @param request The Forecast Request which is executed. Use {@link ForecastRequestBuilder} to build the request.
     * @return The forecast parsed as {@link Forecast}.
     *
     * @throws ForecastException if the forecast cannot be fetched.
     */
    public Forecast forecast(ForecastRequest request) throws ForecastException {
        nonNull("The ForecastRequest cannot be null.", request);

        logger.log(Level.INFO, "Executing Forecat request: {0}", request);

        try {
            try (InputStream is = executeRawForecastRequest(request.getUrl())) {
                return mapper.readValue(is, Forecast.class);
            }

        } catch (IOException e) {
            throw new ForecastException("Forecast cannot be fetched.", e);
        }
    }

    private static ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new com.fasterxml.jackson.datatype.jsr310.JavaTimeModule());
        mapper.configure(REQUIRE_SETTERS_FOR_GETTERS, false);
        mapper.configure(AUTO_DETECT_GETTERS, true);
        mapper.configure(INDENT_OUTPUT, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }

    public static void main(String[] args) throws ForecastException {
        ForecastRequest request = new ForecastRequestBuilder()
                .key(new APIKey("your-private-key"))
                .location(new GeoCoordinates(new Longitude(13.377704), new Latitude(52.516275))).build();

        DarkSkyJacksonClient client = new DarkSkyJacksonClient();
        Forecast forecast = client.forecast(request);
        System.out.println("forecast " + forecast);
        System.out.println("forecast " + forecast.getCurrently().getTemperature());
    }
}
