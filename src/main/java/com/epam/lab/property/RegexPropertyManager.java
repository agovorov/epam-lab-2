package com.epam.lab.property;

import com.epam.lab.Main;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by Andy on 05.11.2015.
 */
public final class RegexPropertyManager {
    //private final static String REGEX_PROPERTIES = "regexes.properties";
    private final static String REGEX_PROPERTIES = "regex.properties";
    private static RegexPropertyManager instance = null;
    private Properties properties = new Properties();

    public static RegexPropertyManager getInstance() {
        if (instance == null) {
            instance = new RegexPropertyManager();
            try {
                instance.readProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    private void readProperties() throws IOException {
        InputStream is = Main.class.getClassLoader().getResourceAsStream(REGEX_PROPERTIES);
        properties.load(is);
        is.close();
    }

    /**
     * Get property and Convert to UTF-8.
     *
     * @param key
     * @return
     */
    public String getProperty(String key) {
        final String value = properties.getProperty(key);
        if (value == null)
            return null;
        try {
            return new String(value.getBytes("ISO-8859-1"), "UTF-8");
        } catch (final UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported", e);
        }
    }
}
