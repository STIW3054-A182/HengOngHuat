import java.io.*;
import java.util.Properties;

public class displayTop3 implements Runnable {

    @Override
    public void run() {
        PropFile pF = new PropFile();
        pF.run();

        try (InputStream input = new FileInputStream("C:\\Users\\Tyjia\\IdeaProjects\\GroupAsg\\top3.properties")) {
            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            String rk, sno, name, rtg, city, pts, category, subt;
            subt = prop.getProperty("Subtitle");
            rk = prop.getProperty("Rank");
            sno = prop.getProperty("SNo");
            name = prop.getProperty("Name");
            rtg = prop.getProperty("Rtg");
            city = prop.getProperty("State");
            pts = prop.getProperty("Pts");
            category = prop.getProperty("Category");

            System.out.println("");
            System.out.println("*****************************Display all TOP 3 players from each category.*****************************");
            System.out.println(subt);

            String format = "| %-5s | %-5s | %-35s| %-8s| %-12s| %-8s| %-8s|\n";
            System.out.format(format, "RK", "SNo", "Name", "Rtg", "State", "Pts", "Category");
            System.out.format(format, rk, sno, name, rtg, city, pts, category);

            System.out.println("");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


}
