package test.automation.school.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    public static String getConfigValue(String key) {
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("src\\test\\resources\\config.properties");
            properties.load(input);
        } catch (IOException e) {
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties.getProperty(key);
    }
}

