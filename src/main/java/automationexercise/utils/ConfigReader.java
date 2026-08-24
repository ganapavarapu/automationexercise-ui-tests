package automationexercise.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input != null) {
                properties.load(input);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        String systemProperty = System.getProperty(key);

        if (systemProperty != null && !systemProperty.isBlank()) {
            return systemProperty;
        }
        return properties.getProperty(key);
    }
}