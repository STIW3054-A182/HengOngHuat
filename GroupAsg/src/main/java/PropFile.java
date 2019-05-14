import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.Properties;

public class PropFile implements Runnable {

    static File propFile = new File("C:\\Users\\Tyjia\\IdeaProjects\\GroupAsg\\dataContent.properties"); //change the location
    static File validURLtable = new File("C:\\Users\\Tyjia\\Desktop\\validURLtable.txt"); //change the location

    @Override
    public void run() {
        Properties prop = new Properties();

        try {
            // If file doesn't exists, then create it
            if (!propFile.exists()) {
                propFile.createNewFile();
            }

            readContent(prop);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readContent(Properties prop) {
        String url;
        try {
            FileReader fr = new FileReader(validURLtable);
            BufferedReader br = new BufferedReader(fr);
            FileOutputStream fos = new FileOutputStream(propFile);

            while ((url = br.readLine()) != null) {
                Document doc = Jsoup.connect(url).get();
                String title = doc.title().substring(41);
                //title

                Element sub = doc.select("div.defaultDialog").get(1);
                Elements subt = sub.select("h2");
                String subtitle = subt.text();
                //subtitle

                int scrape = title.indexOf("9");
                String category = title.substring(scrape + 1).replace("(", "").replace(")", "");
                //category

                for (Element row : doc.select("table.CRs1 tr")) {
                    prop.setProperty("Title", title);
                    prop.setProperty("Subtitle",subtitle);
                    prop.setProperty("Rank", row.select("td:nth-of-type(1)").text());
                    prop.setProperty("SNo", row.select("td:nth-of-type(2)").text());
                    prop.setProperty("Name", row.select("td:nth-of-type(4)").text());
                    prop.setProperty("Rtg", row.select("td:nth-of-type(6)").text());
                    prop.setProperty("State", row.select("td:nth-of-type(7)").text());
                    prop.setProperty("Pts", row.select("td:nth-of-type(8)").text());
                    prop.setProperty("Category", category);

                    saveProperties(prop,fos);
                }
            }
            fos.close();
        } catch (Exception e) {
            System.out.println("Unable to open file ");
        }

    }

    public static void saveProperties(Properties p,FileOutputStream fos) throws IOException {
        p.store(fos, "Properties");
        System.out.println("After saving properties: " + p);
    }
}

