import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;

public class CheckValidTable {


    public void run() throws IOException {

        //save valid link
        File tablefile = new File("C:\\Users\\user\\Desktop\\validURLtable.txt");

        // If file doesn't exists, then create it
        if (!tablefile.exists()) {
            tablefile.createNewFile();
        }
        FileWriter fw = new FileWriter(tablefile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);


        File validURLfile = new File("C:\\Users\\user\\Desktop\\validURL.txt");
        FileReader fr = new FileReader(validURLfile);
        BufferedReader br = new BufferedReader(fr);
        String url;
        while ((url = br.readLine()) != null) {
            if (validTable(url)){
                bw.write(url);
                bw.newLine();
            }
        }
        bw.close();
    }

    public boolean validTable(String url) {
        try {
            Document doc = Jsoup.connect(url).get();
            if (doc.select("table.CRs1 tr").isEmpty())
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
