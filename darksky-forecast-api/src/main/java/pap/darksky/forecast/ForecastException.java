package pap.darksky.forecast;

/**
 * Signals that a WeatherForecast cannot be fetched.
 *
 * @author Puls
 */
public class ForecastException extends Exception {

    public ForecastException(String message) {
        super(message);
    }

    public ForecastException(String message, Throwable cause) {
        super(message, cause);
    }
}
