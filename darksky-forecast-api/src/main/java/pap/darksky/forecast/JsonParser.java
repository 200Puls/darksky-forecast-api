package pap.darksky.forecast;

import java.io.InputStream;
import pap.darksky.forecast.model.Forecast;

/**
 *
 * @author Puls
 */
public interface JsonParser {
    
    Forecast parse(InputStream inputStream);
}
