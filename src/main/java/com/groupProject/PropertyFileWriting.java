package com.groupProject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class PropertyFileWriting {
    public Properties setProperties() {
        Properties prop = new Properties();
        String filePath = "src\\main\\resources\\myConfig.properties";

        try (Writer inputStream = new FileWriter(filePath)) {
            //set the properties value
            prop.setProperty("path","src\\main\\resources\\");
            prop.setProperty("txtFile","URL.txt");
            prop.setProperty("State","KEDAH");
            prop.setProperty("Top1","1");
            prop.setProperty("Top2","2");
            prop.setProperty("Top3","3");
            prop.setProperty("Name","Rosli Iman Hasif");

            //save properties to project root folder
            prop.store(inputStream,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
