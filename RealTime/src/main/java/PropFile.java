import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class PropFile implements Runnable {

    static File propFile = new File("C:\\Users\\user\\IdeaProjects\\RealTime\\data.properties"); //change the location
    static File validURLtable = new File("C:\\Users\\user\\Desktop\\validURLtable.txt"); //change the location

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
        String chose=null;

            try {
                FileReader fr = new FileReader(validURLtable);
                BufferedReader br = new BufferedReader(fr);
                FileOutputStream fos = new FileOutputStream(propFile);
                Scanner scan = new Scanner(System.in);
                System.out.print("Please enter a name: ");
                String n = scan.nextLine();


                while ((url = br.readLine()) != null) {
                    Document doc = Jsoup.connect(url).get();
                    String title = doc.title().substring(41);
                    //title


                    int scrape = title.indexOf("9");
                    String category = title.substring(scrape + 1).replace("(", "").replace(")", "");
                    //category

                    for (Element row : doc.select("table.CRs1 tr")) {
                        if (row.select("td:nth-child(4)").text().equals(n)) {
                            prop.setProperty("Rank", row.select("td:nth-child(1)").text());
                            prop.setProperty("SNo", row.select("td:nth-child(2)").text());
                            prop.setProperty("Name", row.select("td:nth-child(4)").text());
                            prop.setProperty("Rtg", row.select("td:nth-child(6)").text());
                            prop.setProperty("State", row.select("td:nth-child(7)").text());
                            prop.setProperty("Pts", row.select("td:nth-child(8)").text());
                            prop.setProperty("Category", category);

                        }
                    }
                }
                saveProperties(prop, fos);
                fos.close();
            } catch (Exception e) {
                System.out.println("Unable to open file ");
            }


    }

    public static void saveProperties(Properties p,FileOutputStream fos) throws IOException {

        String choose;
        Scanner scan=new Scanner(System.in);
        p.store(fos, "Properties");

        if(p.getProperty("Name") !=null){
            System.out.println("After saving properties: " + p);
        }

        else {
            System.out.println("Not Found!!!");
            System.out.println("You want enter name again?(Y/N)");
            choose=scan.nextLine();

            if(choose.equals("Y")||choose.equals("y")){
                readContent(p);
            }
        }

    }
}