import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import java.util.concurrent.Callable;

public class CheckURLs implements Callable<String>{

    private String validLink;
    private String line;
    //if a Logger with that name already exists, then that Logger is returned; otherwise, a new Logger is created
    Logger logger = Logger.getLogger("MyLog");

    public CheckURLs(String line) {

        this.line = line;
    }

    //@Override
    public String call() throws Exception {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        try {
            if (validUrl(line)) {
                validLink =line;
            } else {
                try {
                    //this block configure the logger with handler and formatter
                    FileHandler fh = new FileHandler("myLogFile.log");
                   logger.addHandler(fh);

                    SimpleFormatter formatter = new SimpleFormatter();
                    fh.setFormatter(formatter);

                    //used to log the invalid url existLink
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

