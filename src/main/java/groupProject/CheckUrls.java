package groupProject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.Callable;

public class CheckUrls implements Callable<String> {

    private String line, link;

    public CheckUrls(String line) {
        this.line = line;
    }

    @Override
    public String call() {
        long startTime, endTime, executeTime;
        String date = new Date().toString();
        String logFile = "myLogFile.log";
        File file = new File(logFile);

        try {
            startTime = System.currentTimeMillis();
            if (validUrl(line)) {
                System.out.println(Thread.currentThread().getName() + " --> " + line);
                endTime = System.currentTimeMillis();
                executeTime = endTime - startTime;
                System.out.println("Execution time in milliseconds: " + executeTime);
                if (executeTime > 1000) {
                    System.exit(0);
                    new FileWriter("myLogFile.log", true); //the terminated link appends to file
                }
                link = line;
            } else {
                try {
                    endTime = System.currentTimeMillis();
                    executeTime = endTime - startTime;

                    FileWriter fw = new FileWriter(file, true); //appends to file
                    BufferedWriter bw = new BufferedWriter(fw);
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

    private boolean validUrl(String link) {
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
