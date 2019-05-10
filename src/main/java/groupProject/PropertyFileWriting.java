package groupProject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class PropertyFileWriting {
    public Properties setProperties() {
        Properties prop = new Properties();
        String filePath = "C:\\Users\\HP\\Downloads\\HengOngHuat-Repo-252823\\myConfig.properties"; //change your path

        try (Writer inputStream = new FileWriter(filePath)) {
            //set the properties value
            prop.setProperty("path","C:\\Users\\HP\\Downloads\\"); //change your path
            prop.setProperty("txtFile","URL.txt");
            prop.setProperty("state", "KEDAH");
            //save properties to project root folder
            prop.store(inputStream,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
