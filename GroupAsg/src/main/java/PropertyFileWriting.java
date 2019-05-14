import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class PropertyFileWriting {
    public Properties setProperties() {
        Properties prop = new Properties();
        String filePath = "C:\\Users\\Tyjia\\IdeaProjects\\GroupAsg\\myConfig.properties"; //change your path

        try (Writer inputStream = new FileWriter(filePath)) {
            //set the properties value
            prop.setProperty("path","C:\\Users\\Tyjia\\Desktop\\"); //change your path
            prop.setProperty("txtFile","url.txt");

            //save properties to project root folder
            prop.store(inputStream,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
