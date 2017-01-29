package pap.darkysky.forecast.util;

/**
 *
 * @author Puls
 */
public class Assert {

    public static void notNullOrEmpty(String message, String string) {
        nonNull(message, string);

        if (string.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void nonNull(String message, Object... objects) {
        if (objects == null) {
            throw new IllegalArgumentException(message);
        }
        for (Object object : objects) {
            if (object == null) {
                throw new IllegalArgumentException(message);
            }
        }
    }

    public static void matches(String message, String string, String pattern) {
        if (!string.matches(pattern)) {
            throw new IllegalArgumentException(message + " Actual String " + string);
        }
    }

}
