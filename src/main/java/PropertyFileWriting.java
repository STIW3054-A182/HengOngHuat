import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class PropertyFileWriting {
    public Properties setProperties() {
        Properties prop = new Properties();
        String filePath = "C:\\Users\\user\\IdeaProjects\\url_reader\\myConfig.properties"; //change your path

        try (Writer inputStream = new FileWriter(filePath)) {
            //set the properties value
            prop.setProperty("path","C:\\Users\\user\\Desktop\\"); //change your path
            prop.setProperty("txtFile","URL.txt");

            //save properties to project root folder
            prop.store(inputStream,null);
            prop.put("STATE","KEDAH");
            prop.put("STATE","JOHOR");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}