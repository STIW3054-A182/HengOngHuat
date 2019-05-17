package com.groupProject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Vector;
import java.util.concurrent.Callable;

public class CountPlayer implements Callable {

    private int row;
    private String link,Cat,cat;
    private static Vector<Integer> subTotal = new Vector<Integer>();

    public CountPlayer(String link){
        this.link=link;
    }

    public Vector<Integer> call(){

        try{
            if (validPlayer(link) >0 && category(link)!=null) {
                subTotal.add(row);
                System.out.printf("| %-8s | %-5d |\n", cat, row);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return subTotal;
    }

    public int validPlayer (String url){
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Element table = doc.select("table.CRs1").get(0);
            Elements rows = table.select("tr.CRg1.MAS");
            Elements rows1 = table.select("tr.CRg2.MAS");
            Elements rows2 = table.select("tr.CRg1.KGZ");
            Elements rows3 = table.select("tr.CRg2.KGZ");
            row = rows.size() + rows1.size() + rows2.size() + rows3.size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public String category (String url){
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            Element category = doc.select("div.defaultDialog").get(0);
            Elements cate = category.select("h2");
            Cat = cate.text();
            int scrape = Cat.indexOf("9");
            cat = Cat.substring(scrape + 1).replace("(", "").replace(")", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cat;
    }
}
