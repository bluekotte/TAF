package configuration;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String browserName() {
        return properties.getProperty("browser");
    }

    public static String username() {
        return properties.getProperty("username");
    }

    public static String password() {
        return properties.getProperty("password");
    }

    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }
    public static String milestoneName1() {
        return properties.getProperty("milestoneName1");
    }

    public static String milestoneName2() {
        return properties.getProperty("milestoneName2");
    }

    public static String reference1() {
        return properties.getProperty("reference1");
    }

    public static String reference2() {
        return properties.getProperty("reference2");
    }

    public static String parent1() {
        return properties.getProperty("parent1");
    }

    public static String parent2() {
        return properties.getProperty("parent2");
    }

    public static String description1() {
        return properties.getProperty("descriptionText1");
    }

    public static String description2() {
        return properties.getProperty("descriptionText2");
    }

    public static boolean competed1() {
        return Boolean.parseBoolean(properties.getProperty("completed1"));
    }

    public static boolean competed2() {
        return Boolean.parseBoolean(properties.getProperty("completed2"));
    }
}
