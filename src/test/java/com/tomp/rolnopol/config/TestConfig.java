package com.tomp.rolnopol.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = TestConfig.class
                .getClassLoader()
                .getResourceAsStream("config/test.properties")) {

            if (inputStream == null) {
                throw new RuntimeException("Missing config/test.properties");
            }

            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Could not load test configuration", e);
        }
    }

    public static String get(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}
