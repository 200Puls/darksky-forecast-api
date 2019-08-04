/*//
 * The MIT License
 *
 * Copyright 2018 Philipp-André Plogmann.
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

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import java.time.Instant;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;
import tk.plogitech.darksky.forecast.APIKey;
import tk.plogitech.darksky.forecast.ForecastException;
import tk.plogitech.darksky.forecast.ForecastRequest;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder.Block;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder.Language;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder.Units;
import tk.plogitech.darksky.forecast.GeoCoordinates;
import tk.plogitech.darksky.forecast.model.Forecast;
import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;

/**
 * Tests to verify certain values can be serializes / deserialized.
 *
 * @author Philipp-André Plogmann
 */
public class SerializationTest {

    @Test
    public void longitude_latitude_integer_can_be_serialized() throws JsonProcessingException, IOException, ForecastException {

	Forecast forecast = DarkSkyJacksonClient.objectMapper().readValue(getClass().getResource("/forecast_ints.json").openStream(), Forecast.class);

	assertEquals((double) 41.0, (double) forecast.getLatitude().value(), 0);
	assertEquals((double) 22.0, (double) forecast.getLongitude().value(), 0);
    }

    @Test
    public void longitude_latitude_double_can_be_serialized() throws JsonProcessingException, IOException, ForecastException {

	Forecast forecast = DarkSkyJacksonClient.objectMapper().readValue(getClass().getResource("/forecast.json").openStream(), Forecast.class);

	assertEquals((double) 41.12, (double) forecast.getLatitude().value(), 0);
	assertEquals((double) 22.1234, (double) forecast.getLongitude().value(), 0);
    }

    @Test
    @Ignore
    public void longitude_can_be_serialized() throws JsonProcessingException, IOException, ForecastException {

	ForecastRequest request = new ForecastRequestBuilder().key(new APIKey(""))
		.location(new GeoCoordinates(new Longitude(22.1234), new Latitude(41.0)))
		.time(Instant.now())
		.language(Language.en)
		.units(Units.si)
		.exclude(Block.minutely, Block.hourly, Block.daily)
		.build();

	DarkSkyJacksonClient client = new DarkSkyJacksonClient();

	Forecast forecast = client.forecast(request);

    }
    

}
