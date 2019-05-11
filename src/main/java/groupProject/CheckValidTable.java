package groupProject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;

public class CheckValidTable implements Callable{

    private String validTableLink;
    private String link;

    public CheckValidTable(String link) {

        this.link = link;
    }

    //@Override
    public String call() throws Exception {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        long startTime, endTime, executeTime;
        String date = new Date().toString();
        String logFile = "myLogFile.log";
        File file = new File(logFile);
        FileWriter fw;
        BufferedWriter bw;

        try {
            startTime = System.currentTimeMillis();
            if (validTable(link)) {
                validTableLink =link;
            } else{
                //System.out.println("|  Wrong   | 0     |");
                endTime = System.currentTimeMillis();
                executeTime = endTime - startTime;

                fw = new FileWriter(file, true); //appends to file
                bw = new BufferedWriter(fw);
                bw.write(date + "\t");
                bw.write(Thread.currentThread().getName() + " --> " + link + " (not exist player)");
                bw.write(System.lineSeparator());
                bw.write("Execution time in milliseconds: " + executeTime);
                bw.write(System.lineSeparator());
                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validTableLink;
    }

    public boolean validTable(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            if (doc.select("table.CRs1 tr").isEmpty())
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}

