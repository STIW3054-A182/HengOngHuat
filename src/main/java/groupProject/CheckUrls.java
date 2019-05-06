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
        String date = new Date().toString();
        String logFile = "myLogFile.log";
        File file = new File(logFile);

        try {
            if (validUrl(line)) {
                System.out.println(Thread.currentThread().getName() + " --> " + line);
                link = line;
            } else {
                try {
                    if (!file.exists()) {
                        System.out.println("We had to make a new log file.");
                        file.createNewFile();
                    }

                    FileWriter fw = new FileWriter(file, true); //appends to file
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(date + "\t");
                    bw.append(Thread.currentThread().getName() + " --> " + line + " (not exist)");
                    bw.append(System.lineSeparator());
                    bw.close();
                } catch (SecurityException se) {
                    se.printStackTrace();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return link;
    }

    public boolean validUrl(String link) {
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
