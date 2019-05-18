package com.groupProject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Create CheckValidTable class implements with Callable to call the getExistLinkList.
 * CheckValidTable class uses to get validTablelinks.
 * @author Chong Mei Yong
 * @version 1.0
 * @since 2019-04-19
 */
public class CheckValidTable implements Callable {

    private String validTableLink;
    private String link;

    public CheckValidTable() {

    }

    /**
     *This constructs a check valid table with a specified link (existLink)
     * @param link an initial validLink
     */
    public CheckValidTable(String link) {
        this.link = link;
    }

     /**
     * get valid link from exist link list
     * @return validTableLink
     */
    @Override
    public String call() {
        long startTime, endTime, executeTime;
        String date = new Date().toString();
        String logFile = "myLogFile.log";
        File file = new File(logFile);
        FileWriter fw;
        BufferedWriter bw;

        try {
            startTime = System.currentTimeMillis();
            if (validTable(link)) {
                validTableLink = link;
            } else {
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

    /**
     * to test valid table link from exist link list
     * @param url is exist link
     * @return validTableLink if condition is matched.
     */
    public boolean validTable(String url) {
        Document doc;
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
