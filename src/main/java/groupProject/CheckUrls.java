package groupProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CheckUrls implements Callable<String> {

    private String line, validLink;
    //if a Logger with that name already exists, then that Logger is returned; otherwise, a new Logger is created
    Logger logger = Logger.getLogger("MyLog");

    public CheckUrls(String line) {
        this.line = line;
    }

    @Override
    public String call() throws Exception {
        try {
            if (validUrl(line)) {
                validLink = line;
                //System.out.println(Thread.currentThread().getName() + " --> " + line);
            } else {
                try {
                    //this block configure the logger with handler and formatter
                    FileHandler fh = new FileHandler("myLogFile.log");
                    logger.addHandler(fh);
                    SimpleFormatter formatter = new SimpleFormatter();
                    fh.setFormatter(formatter);

                    //used to log the invalid url link
                    //logger.info(Thread.currentThread().getName() + " --> " + line + " (not exist)");
                } catch (SecurityException se) {
                    se.printStackTrace();
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validLink;
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