package com.princestrust.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public PropertyReader() {
        loadProperties();
    }

    private Properties properties = new Properties();
    private InputStream inputStream = null;

    //find a way to pass the projectName into the path above to get correct config file
    private String path = "src/test/java/com/princestrust/config/config.properties";


    private void loadProperties() {
        try {
            inputStream = new FileInputStream(path);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }

    public String getReportConfigPath(){
        String reportConfigPath = new PropertyReader().readProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

}
