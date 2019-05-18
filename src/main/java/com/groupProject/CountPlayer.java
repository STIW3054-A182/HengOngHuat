package com.groupProject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Vector;
import java.util.concurrent.Callable;

/**
 * Create CountPlayer class implements with Callable to call the getExistTableLinkList.
 * CountPlayer class uses to count the total players for each category.
 * @author Chong Mei Yong
 * @version 1.0
 * @since 2019-04-19
 */
public class CountPlayer implements Callable {

    private int row;
    private String link,Cat,cat;
    private static Vector<Integer> subTotal = new Vector<Integer>();

    /**
     * This constructs a to count the total players for each category.
     * @param link an initial validTableLink
     */
    public CountPlayer(String link){
        this.link=link;
    }

    /**
     * to get the total players for each category from validPlayer method and display the result
     * @return subtotal with call() method
     * for return the whole value to ResultCountPlayer class.
     */
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

    /**
     * to count the total players for each category
     * @param url is validTableLink
     * @return total players for each category
     */
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

    /**
     * to get the category
     * @param url is validTableLink
     * @return category
     */
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
