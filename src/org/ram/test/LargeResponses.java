package org.ram.test;

import java.util.*;
import java.util.stream.*;
import java.util.logging.*;
import java.io.*;
import java.nio.file.*;

public class LargeResponses {

    private static final Logger LOGGER = Logger.getLogger(LargeResponses.class.getName());

    private static final String RESPONSE_FILE_PREFIX = "bytes_";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFile = scanner.next();
        try {
            writeLargeResponsesToFile(inputFile, RESPONSE_FILE_PREFIX + "result");
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING,  "Unable to write response to file", ex);
        }
    }

    private static void writeLargeResponsesToFile(String inputFile, String outputFile) throws IOException {
        int noOfBytes = 0;
        List<String> recordsWithResponseMoreThan5000Bytes;
        try(Stream<String> records = Files.lines(Paths.get(inputFile))) {
            recordsWithResponseMoreThan5000Bytes = records.filter(record -> getResponseBytes(record) > 5000).collect(Collectors.toList());
            for(String record: recordsWithResponseMoreThan5000Bytes) {
                noOfBytes += getResponseBytes(record);
            }
            Files.write(
                    Paths.get(outputFile),
                    (Iterable<String>)Stream.of(recordsWithResponseMoreThan5000Bytes.size()+"", noOfBytes+"")::iterator
            );
        }
    }

    private static int getResponseBytes(String record) {
        return Integer.parseInt(record.substring(record.lastIndexOf(" ") + 1));
    }
}
