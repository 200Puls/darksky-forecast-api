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
package tk.plogitech.darksky.forecast.util;

/**
 * Utility for validation parameters.
 *
 * All methods throw an {@link IllegalArgumentException} if the tested assertion fails.
 *
 * @author Puls
 */
public final class Assert {

    private Assert() {
        // prevent construction of Utility class.
    }

    public static void notNullOrEmpty(String message, String string) {
        notNull(message, string);

        if (string.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(String message, Object... objects) {
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
