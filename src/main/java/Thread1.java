import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.util.Pair;

import java.util.concurrent.Callable;

public class Thread1 implements Callable<Vector>{
    String link,cat;
    int kl,ns,pp,pahang,ptrjaya,perak,selangor,johor,kedah,sarawak,sabah,melaka,kelantan;
    final String [] state={"KUALA LUMPUR", "N.SEMBILAN","PULAU PINANG","PAHANG","PUTRAJAY","PERAK","SELANGOR","JOHOR","KEDAH","SARAWAK","SABAH","MELAKA","KELANTAN"};
    public static Vector<Pair<Integer,String>> subTotal = new Vector<Pair<Integer,String>>();


    public Thread1(String link){

        this.link=link;
    }

    public Vector<Pair<Integer,String>> call() throws Exception {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        try {
                if (valid2(link)) {
                    if (getTwo(link)!=null){
                        Pair p1=new Pair(kl,cat);
                        Pair p2=new Pair(ns,cat);
                        Pair p3=new Pair(pp,cat);
                        Pair p4=new Pair(pahang,cat);
                        Pair p5=new Pair(ptrjaya,cat);
                        Pair p6=new Pair(perak,cat);
                        Pair p7=new Pair(selangor,cat);
                        Pair p8=new Pair(johor,cat);
                        Pair p9=new Pair(kedah,cat);
                        Pair p10=new Pair(sarawak,cat);
                        Pair p11=new Pair(sabah,cat);
                        Pair p12=new Pair(melaka,cat);
                        Pair p13=new Pair(kelantan,cat);
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


                      /*  if (kl >0 ) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[1],cat.replace("(", "").replace(")", ""),kl);
                        }
                      if (ns >0 ) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[1],cat.replace("(", "").replace(")", ""),ns);
                             }
                        if (pp >0 ) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[2],cat.replace("(", "").replace(")", ""),pp);
                             }
                        if (pahang >0 ) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[3],cat.replace("(", "").replace(")", ""),pahang);
                            }
                        if (ptrjaya >0 ) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[4],cat.replace("(", "").replace(")", ""),ptrjaya);
                             }
                        if (perak >0) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[5],cat.replace("(", "").replace(")", ""),perak);
                            }
                        if (selangor > 0) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[6],cat.replace("(", "").replace(")", ""),selangor);
                            }
                        if (johor > 0) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[7],cat.replace("(", "").replace(")", ""),johor);
                             }
                        if (kedah > 0) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[8],cat.replace("(", "").replace(")", ""),kedah);
                             }
                        if (sarawak > 0) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[9],cat.replace("(", "").replace(")", ""),sarawak);
                            }
                        if (sabah > 0) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[10],cat.replace("(", "").replace(")", ""),sabah);
                            }
                        if (melaka > 0) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[11],cat.replace("(", "").replace(")", ""),melaka);
                            }
                        if (kelantan > 0) {
                            System.out.printf("| %-12s | %-8s | %-6d|\n",state[12],cat.replace("(", "").replace(")", ""),kelantan);
                            }
                            */



                        }

                            }


       } catch (Exception e) {

           e.printStackTrace();
       }
        return subTotal;
    }

    public boolean valid2(String url) {

        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
            if (doc.select("table.CRs1 tr").isEmpty()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Pair[] getTwo(String url) {

        Document doc = null;
            try {

                    doc = Jsoup.connect(url).get();
                    for (Element row : doc.select("table.CRs1 tr")) {
                        final String ticker = row.select("td:nth-of-type(7)").text();

                        switch (ticker) {
                            case "KUALA LUMPUR":
                                kl++;
                                if (kl > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;

                                }
                                break;

                            case "N.SEMBILAN":
                                ns++;
                                if (ns > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
                                break;

                            case "PULAU PINANG":
                                pp++;
                                if (pp > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
                                break;

                            case "PAHANG":
                                pahang++;
                                if (pahang > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
                                break;

                            case "PUTRAJAYA":
                                ptrjaya++;
                                if (ptrjaya > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
                                break;

                            case "PERAK":
                                perak++;
                                if (perak > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
                                break;

                            case "SELANGOR":
                                selangor++;
                                if (selangor > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
                                break;

                            case "JOHOR":
                                johor++;
                                if (johor > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
                                break;

                            case "KEDAH":
                                kedah++;
                                if (kedah > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
                                break;

                            case "SARAWAK":
                                sarawak++;
                                if (sarawak > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
                                break;

                            case "SABAH":
                                sabah++;
                                if (sabah > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
                                break;

                            case "MELAKA":
                                melaka++;
                                if (melaka > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
                                break;

                            case "KELANTAN":
                                kelantan++;
                                if (kelantan > 0) {
                                    String title = doc.title();
                                    int scrape = title.indexOf("9");
                                    String category = title.substring(scrape + 1);
                                    cat = category;
                                }
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
