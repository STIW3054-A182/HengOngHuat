package groupProject;

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

            //save properties to project root folder
            prop.store(inputStream,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
