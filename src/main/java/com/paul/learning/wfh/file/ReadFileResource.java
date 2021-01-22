package com.paul.learning.wfh.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

/**
 * A class which implements the reading of a specified file.
 */
public class ReadFileResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFileResource.class);

    /**
     *
     * Reads a file into a {@link List} of {@link String}.
     *
     * @param fileName - The file name to be processed.
     * @return A {@link List} of {@link String} for each line of the file.
     */
    public List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (inputStream != null) {
            try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lines.add(line);
                }
                // note that Scanner suppresses exceptions
                if (scanner.ioException() != null) {
                    throw scanner.ioException();
                }
                inputStream.close();
            } catch (IOException exception) {
                LOGGER.error("Exception:{0}", exception);
            }
        }
        return lines;
    }
}
