package com.groupProject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Properties;


public class NamePlayer extends CheckValidTable implements Runnable {

    private String link2;

    public NamePlayer() {

    }

    public NamePlayer(String link) {
        super(link);
        link2 = link;
    }

    @Override
    public void run() {
        PropertyFileWriting obj = new PropertyFileWriting();
        Properties write = obj.setProperties();
        String prop = write.getProperty("Name");

        if (validTable(link2)) {
            Document doc;
            try {
                doc = Jsoup.connect(link2).get();

                String title = doc.title();
                int scrape = title.indexOf("9");
                String category = title.substring(scrape + 1).replace("(", "").replace(")", "");

                for (Element row : doc.select("table.CRs1 tr")) {
                    final String rk = row.select("td:nth-of-type(1)").text();
                    final String sno = row.select("td:nth-of-type(2)").text();
                    final String name = row.select("td:nth-of-type(4)").text();
                    final String rtg = row.select("td:nth-of-type(6)").text();
                    final String state = row.select("td:nth-of-type(7)").text();
                    final String pointer = row.select("td:nth-of-type(8)").text();

                    if (pointer.equals(","))
                        System.out.println(Double.parseDouble(pointer.replace(",", ".")));

                    if (name.equals(prop)) {
                        String format = "| %-5s | %-5s | %-35s| %-8s| %-8s| %-8s| %-8s|\n";
                        System.out.format(format, rk, sno, name, rtg, state, pointer, category);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
