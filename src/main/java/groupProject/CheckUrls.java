package groupProject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.Callable;

public class CheckUrls implements Callable<String> {

    private String line, link, date;
    private long startTime, endTime, executeTime;
    private File file;
    private FileWriter fw;
    private BufferedWriter bw;

    public CheckUrls(String line) {
        this.line = line;
    }

    @Override
    public String call() {
        String logFile = "myLogFile.log";
        file = new File(logFile);
        date = new Date().toString();

        try {
            startTime = System.currentTimeMillis();
            if (ValidUrl(line)) {
                System.out.println(Thread.currentThread().getName() + " --> " + line);
                endTime = System.currentTimeMillis();
                executeTime = endTime - startTime;
                System.out.println("Execution time in milliseconds: " + executeTime);
                if (executeTime > 60000) {
                    fw = new FileWriter(file, true); //the terminated link appends to file
                    bw = new BufferedWriter(fw);
                    bw.write(date + "\t");
                    bw.write(Thread.currentThread().getName() + " --> " + line + " (not exist)");
                    bw.write(System.lineSeparator());
                    bw.write("Execution time in milliseconds: " + executeTime);
                    bw.write(System.lineSeparator());
                    bw.close();
                    System.exit(0);
                }
                link = line;
            } else {
                try {
                    endTime = System.currentTimeMillis();
                    executeTime = endTime - startTime;

                    fw = new FileWriter(file, true); //appends to file
                    bw = new BufferedWriter(fw);
                    bw.write(date + "\t");
                    bw.write(Thread.currentThread().getName() + " --> " + line + " (not exist)");
                    bw.write(System.lineSeparator());
                    bw.write("Execution time in milliseconds: " + executeTime);
                    bw.write(System.lineSeparator());
                    bw.close();
                } catch (SecurityException | IOException se) {
                    se.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return link;
    }

    private boolean ValidUrl(String link) {
        try {
            HttpURLConnection.setFollowRedirects(true);
            HttpURLConnection checkUrl = (HttpURLConnection) new URL(link).openConnection();
            checkUrl.getResponseCode();
            return (checkUrl.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            return false;
        }
    }
}
