package com.groupProject;

import javafx.util.Pair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Vector;
import java.util.concurrent.Callable;

/**
 * @author Liew Sin Hui
 * @version 1.0
 * @since 2019-04-19
 * Create GetStateData class implements with Callable to call the getExistTableLinkList from ResultStateStatistic class
 * GetStateData class uses to get total players for each state by category from current validTableLink.
 */
public class GetStateData implements Callable {

    private String link,cat;
    private int kl,ns,pp,pahang,ptrjaya,perak,selangor,johor,kedah,sarawak,sabah,melaka,kelantan;
    private static Vector<Pair<Integer,String>> subTotal = new Vector<>();

      /**
     * This constructs a get state data with a specified link (validTableLink)
     * @param link an initial validTableLink
     */
    public GetStateData(String link){
        this.link=link;
    }
    
    /**
     * get total players for each state by category from getTwo method
     * @return subTotal with call() method
     * for return the whole value to ResultStateStatistic class.
     */
    @Override
    public Vector<Pair<Integer,String>> call() {
        try {
            if (getTwo(link)!=null) {
                Pair<Integer, String> p1 = new Pair<>(kl, cat);
                Pair<Integer, String> p2 = new Pair<>(ns, cat);
                Pair<Integer, String> p3 = new Pair<>(pp, cat);
                Pair<Integer, String> p4 = new Pair<>(pahang, cat);
                Pair<Integer, String> p5 = new Pair<>(ptrjaya, cat);
                Pair<Integer, String> p6 = new Pair<>(perak, cat);
                Pair<Integer, String> p7 = new Pair<>(selangor, cat);
                Pair<Integer, String> p8 = new Pair<>(johor, cat);
                Pair<Integer, String> p9 = new Pair<>(kedah, cat);
                Pair<Integer, String> p10 = new Pair<>(sarawak, cat);
                Pair<Integer, String> p11 = new Pair<>(sabah, cat);
                Pair<Integer, String> p12 = new Pair<>(melaka, cat);
                Pair<Integer, String> p13 = new Pair<>(kelantan, cat);
                subTotal.add(p1);
                subTotal.add(p2);
                subTotal.add(p3);
                subTotal.add(p4);
                subTotal.add(p5);
                subTotal.add(p6);
                subTotal.add(p7);
                subTotal.add(p8);
                subTotal.add(p9);
                subTotal.add(p10);
                subTotal.add(p11);
                subTotal.add(p12);
                subTotal.add(p13);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subTotal;
    }

      /**
     * get total points for each state by category from current validTableLink
     * @param url is validTableLink
     * @return current total points for each state and category in Pair format.
     */
    protected Pair[] getTwo(String url) {

        Document doc;
        try {
            doc = Jsoup.connect(url).get();

            String title = doc.title();
            int scrape = title.indexOf("9");
            String category = title.substring(scrape + 1).replace("(", "").replace(")", "");
            cat = category;

            for (Element row : doc.select("table.CRs1 tr")) {
                final String ticker = row.select("td:nth-of-type(7)").text();

                switch (ticker) {
                    case "KUALA LUMPUR":
                        kl++;
                        break;

                    case "N.SEMBILAN":
                        ns++;
                        break;

                    case "PULAU PINANG":
                        pp++;
                        break;

                    case "PAHANG":
                        pahang++;
                        break;

                    case "PUTRAJAYA":
                        ptrjaya++;
                        break;

                    case "PERAK":
                        perak++;
                        break;

                    case "SELANGOR":
                        selangor++;
                        break;

                    case "JOHOR":
                        johor++;
                        break;

                    case "KEDAH":
                        kedah++;
                        break;

                    case "SARAWAK":
                        sarawak++;
                        break;

                    case "SABAH":
                        sabah++;
                        break;

                    case "MELAKA":
                        melaka++;
                        break;

                    case "KELANTAN":
                        kelantan++;
                        break;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Pair []{new Pair<>(kl,cat),new Pair<>(ns,cat),new Pair<>(pp,cat),new Pair<>(pahang,cat),
                new Pair<>(ptrjaya,cat),new Pair<>(perak,cat),new Pair<>(selangor,cat),new Pair<>(johor,cat),
                new Pair<>(kedah,cat),new Pair<>(sarawak,cat),new Pair<>(sabah,cat),new Pair<>(melaka,cat),
                new Pair<>(kelantan,cat)};
    }
}
