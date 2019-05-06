import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.util.Pair;

import java.util.concurrent.Callable;

public class Thread1 implements Callable<Vector>{
    String link,cat,result;
    int kl,ns,pp,pahang,ptrjaya,perak,selangor,johor,kedah,sarawak,sabah,melaka,kelantan,i,sum;
    final String [] state={"KUALA LUMPUR", "N.SEMBILAN","PULAU PINANG","PAHANG","PUTRAJAY","PERAK","SELANGOR","JOHOR","KEDAH","SARAWAK","SABAH","MELAKA","KELANTAN"};
    int total =0;
    int totalKL =0;
    //Integer subTotal[];
    public static Vector<Integer> subTotal = new Vector<Integer>();
    public Thread1(String link){

        this.link=link;
    }

    public Vector<Integer> call() throws Exception {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        try {
                if (valid2(link)) {
                    if (getTwo(link)!=null){
                       subTotal.add(kl);
                        subTotal.add(ns);
                        subTotal.add(pp);
                        subTotal.add(pahang);
                        subTotal.add(ptrjaya);
                        subTotal.add(perak);
                        subTotal.add(selangor);
                        subTotal.add(johor);
                        subTotal.add(kedah);
                        subTotal.add(sarawak);
                        subTotal.add(sabah);
                        subTotal.add(melaka);
                        subTotal.add(kelantan);

                       if (kl >0 ) {
                           System.out.printf("| %-12s | %-8s | %-6d|\n",state[0],cat.replace("(", "").replace(")", ""),kl);
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
                total=+total+kl+ns+pp+pahang+ptrjaya+perak+selangor+johor+kedah+sarawak+sabah+melaka+kelantan;

            } catch (Exception e) {
                e.printStackTrace();
            }

            return new Pair []{new Pair<>(kl,cat),new Pair<>(ns,cat),new Pair<>(pp,cat),new Pair<>(pahang,cat),
                               new Pair<>(ptrjaya,cat),new Pair<>(perak,cat),new Pair<>(selangor,cat),new Pair<>(johor,cat),
                               new Pair<>(kedah,cat),new Pair<>(sarawak,cat),new Pair<>(sabah,cat),new Pair<>(melaka,cat),
                               new Pair<>(kelantan,cat)};
        }
}
