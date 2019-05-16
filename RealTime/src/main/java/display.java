import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class display  {
    public void run()  {
        try (InputStream input = new FileInputStream("data.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);
            String rk,sno,name,rtg,city,pts,category;
            // get the property value and print it out
            rk = prop.getProperty("Rank");
            sno = prop.getProperty("SNo");
            name = prop.getProperty("Name");
            rtg = prop.getProperty("Rtg");
            city = prop.getProperty("State");
            pts = prop.getProperty("Pts");
            category =prop.getProperty("Category");

            System.out.println("");
            System.out.println("*****************************Read from the properties*****************************");

            /*System.out.println("|RK  |SNo  |Name                            |Rtg   |State       |Pts  |Category  |");
            System.out.println("|----|-----|--------------------------------|------|------------|-----|----------|");
            System.out.println("|" + rk + "   |" + sno + "    |" + name + "                     |" + rtg + "  |" + city + "|" + pts + "  |" + category + "        |");*/

            String format = "| %-5s | %-5s | %-35s| %-8s| %-12s| %-8s| %-8s|\n";
            System.out.format(format, "RK", "SNo", "Name", "Rtg", "State", "Pts", "Category");
            System.out.format(format, rk, sno, name, rtg, city, pts, category);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}