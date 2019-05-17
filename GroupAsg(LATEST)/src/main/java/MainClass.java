import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class MainClass {
    public static void main (String[] args) throws IOException {

        String path, fileName;
        PropertyFileWriting obj = new PropertyFileWriting();
        Properties write = obj.setProperties();
        path = write.getProperty("path");
        fileName = write.getProperty("txtFile");
        System.out.println("Path: " + path);
        System.out.println("FileName: " + fileName);

        System.out.println("**************************** DISPLAY VALID LINKS ****************************");
        new FileWriter("myLogFile.log", false); //overwrites file
        ValidLink validLink = new ValidLink();
        validLink.allLink();

        ValidTableLink validTableLink = new ValidTableLink();
        validTableLink.existTableLink();
        System.out.println("\n************************ DISPLAY ALL TOP 3 PLAYERS FROM EACH CATEGORY ************************");
        ResultTop3Player topPlayer = new ResultTop3Player();
        Thread t4 = new Thread(topPlayer);
        t4.start();
        try {
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
