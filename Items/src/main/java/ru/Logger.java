package ru;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Logger {
    private static final Path path = Paths.get("E://MyProjects/IJ projects/carservice/Logs/items.txt");

    public static void write(String str) throws IOException {
        Files.write(path, str.getBytes(), StandardOpenOption.APPEND);
    }
}
