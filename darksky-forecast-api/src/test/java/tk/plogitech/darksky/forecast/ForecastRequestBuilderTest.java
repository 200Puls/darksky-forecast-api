package tk.plogitech.darksky.forecast;

import org.junit.Test;
import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;

import static org.junit.Assert.assertTrue;

public class ForecastRequestBuilderTest {

    @Test
    public void language_param_is_correct() {
        ForecastRequestBuilder builder = new ForecastRequestBuilder()
                .key(new APIKey("testing-api-key"))
                .location(new GeoCoordinates(new Longitude(13.377704), new Latitude(52.516275)))
                .language(ForecastRequestBuilder.Language.zh_tw);
        ForecastRequest request = builder.build();
        assertTrue(request.url().getQuery().contains("lang=zh-tw"));
    }
}
