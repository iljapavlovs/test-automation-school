package utils;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;


public class PropertyLoader {

    private final static Logger log = Logger.getLogger(PropertyLoader.class.getName());

    public static String loadProperty(String name) {
        return loadProperty(name, "/config.properties");
    }

    public static String loadProperty(String name, String fromResource) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream(fromResource));
        } catch (IOException e) {
            log.info("Unable to load property for file: " + fromResource);
        }
        return props.getProperty(name);
    }
}
