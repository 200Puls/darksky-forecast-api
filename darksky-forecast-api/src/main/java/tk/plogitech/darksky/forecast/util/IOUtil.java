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

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import static tk.plogitech.darksky.forecast.util.Assert.notNull;

/**
 * Utility for IO related tasks.
 *
 * @author Philipp-André Plogmann
 */
public final class IOUtil {

    private IOUtil() {
	// prevent construction of Utility class.
    }

    /**
     * Reads the given {@link InputStream} and returns it as byte[].
     *
     * @param is The InputStream from which is read.
     * @return The bytes read from the InputStream.
     * @throws IOException If the InputStream cannot be read.
     */
    public static byte[] readFully(InputStream is) throws IOException {
	notNull("The InputStream cannot be null", is);

	return readFully(is, -1, true);
    }

    /**
     * Reads the given {@link InputStream} and returns it as byte[].
     *
     * TODO: Very performant copy of sun.misc.IOUtils. Replace with Java 9 version.
     *
     * @param is The InputStream from which is read.
     * @param length The max number of bytes read. Use -1 to read everything.
     * @param readAll Flag to signal that all bytes need to be read. An exception will be thrown if less bytes than the given length value is read (if length is not -1).
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
}
