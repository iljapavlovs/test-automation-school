package test.automation.school.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    public static String loadProperty(String name){
        return loadProperty(name, "/config.properties");
    }

    public static String loadProperty(String name, String fromResource) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(fromResource));
        } catch (IOException e) {
            System.out.println("Unable to load proeprty for file: " + fromResource);
        }
        return props.getProperty(name);
    }
}

