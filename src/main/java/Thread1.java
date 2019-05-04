import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.util.Pair;

import java.util.concurrent.Callable;

public class Thread1 implements Runnable{
    String link,cat;
    int kl,ns,pp,pahang,ptrjaya,perak,selangor,johor,kedah,sarawak,sabah,melaka,kelantan,i, total,sum;
    String result;
    final String [] state={"KUALA LUMPUR", "N.SEMBILAN","PULAU PINANG","PAHANG","PUTRAJAY","PERAK","SELANGOR","JOHOR","KEDAH","SARAWAK","SABAH","MELAKA","KELANTAN"};
    int KL,NS,PP,PHG,PTJ,PR,SLG,JH,KD,SRW,SB,MLK,KLT;
    int [] totalKL = {0,0,0,0,0,0,0,0,0,0};
    int [] totalPERAK = {0,0,0,0,0,0,0,0,0,0};

    public Thread1(String link){
        this.link=link;
    }

    public void run(){
            ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            //if(valid(link)) {
                if (valid2(link)) {
                    if (getTwo(link)!=null){
                        Pair p1 = new Pair(kl, cat);
                        Pair p2 = new Pair(ns, cat);
                        Pair p3 = new Pair(pp, cat);
                        Pair p4 = new Pair(pahang, cat);
                        Pair p5 = new Pair(ptrjaya, cat);
                        Pair p6 = new Pair(perak, cat);
                        Pair p7 = new Pair(selangor, cat);
                        Pair p8 = new Pair(johor, cat);
                        Pair p9 = new Pair(kedah, cat);
                        Pair p10 = new Pair(sarawak, cat);
                        Pair p11 = new Pair(sabah, cat);
                        Pair p12 = new Pair(melaka, cat);
                        Pair p13 = new Pair(kelantan, cat);
                        if (kl >0 ) {
                                System.out.println("|  KUALA LUMPUR |     " + p1.getValue() + "     |       " + p1.getKey() + "       |");
                             }
                      /**/  if (ns >0 ) {
                                System.out.println("|  N.SEMBILAN   |     " + p2.getValue() + "     |       " + p2.getKey() + "       |");
                             }
                        if (pp >0 ) {
                                System.out.println("|  PULAU PINANG |     " + p3.getValue() + "     |       " + p3.getKey() + "       |");
                             }
                        if (pahang >0 ) {
                                System.out.println("|     PAHANG    |     " + p4.getValue() + "     |       " + p4.getKey() + "       |");
                            }
                        if (ptrjaya >0 ) {
                                System.out.println("|   PUTRAJAYA   |     " + p5.getValue() + "     |       " + p5.getKey() + "       |");
                             }
                        if (perak >0) {
                                System.out.println("|     PERAK     |     " + p6.getValue() + "     |       " + p6.getKey() + "       |");
                            }
                        if (selangor > 0) {
                                System.out.println("|    SELANGOR   |     " + p7.getValue() + "     |       " + p7.getKey() + "       |");
                            }
                        if (johor > 0) {
                                System.out.println("|     JOHOR     |     " + p8.getValue() + "     |       " + p8.getKey() + "       |");
                             }
                        if (kedah > 0) {
                                System.out.println("|     KEDAH     |     " + p9.getValue() + "     |       " + p9.getKey() + "       |");
                             }
                        if (sarawak > 0) {
                                System.out.println("|    SAEAWAK    |     " + p10.getValue() + "     |       " + p10.getKey() + "     |");
                            }
                        if (sabah > 0) {
                                System.out.println("|     SABAH     |     " + p11.getValue() + "     |       " + p11.getKey() + "     |");
                            }
                        if (melaka > 0) {
                                System.out.println("|     MELAKA    |     " + p12.getValue() + "     |       " + p12.getKey() + "     |");
                            }
                        if (kelantan > 0) {
                                System.out.println("|    KELANTAN   |     " + p13.getValue() + "     |       " + p13.getKey() + "     |");
                            }
                        }
                        //total=kl;
                       // System.out.println(kl);
                        /*TotalStatistic task1 = new TotalStatistic(total);
                        Future<Integer> future = executorService.submit(task1);

                        try{
                            //System.out.println("Total kl= "+future.get());
                            System.out.println("|  KUALA LUMPUR |                  |       " + future.get()+"       |");
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }catch (ExecutionException e){
                            e.printStackTrace();
                        }*/

                            }
                       // }

      //  } catch (MalformedURLException e) {

           // e.printStackTrace();

       } catch (Exception e) {

           e.printStackTrace();
       }

    }

   /* public boolean valid(String url) throws MalformedURLException, IOException {

        try {
            HttpURLConnection.setFollowRedirects(true);
            HttpURLConnection checkURL= (HttpURLConnection) new URL(url).openConnection();
            checkURL.setRequestMethod("HEAD");
            checkURL.connect();
            return (checkURL.getResponseCode() == HttpURLConnection.HTTP_OK);
        } catch (Exception e) {
            return false;
        }
    }*/
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

    public Pair[] getTwo(String url) {//<Integer,String>

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

               //result ="KL   "+kl+cat;//+"\n Perak   "+totalPERAK[3]+cat;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return new Pair []{new Pair<>(kl,cat),new Pair<>(ns,cat),new Pair<>(pp,cat),new Pair<>(pahang,cat),
                               new Pair<>(ptrjaya,cat),new Pair<>(perak,cat),new Pair<>(selangor,cat),new Pair<>(johor,cat),
                               new Pair<>(kedah,cat),new Pair<>(sarawak,cat),new Pair<>(sabah,cat),new Pair<>(melaka,cat),
                               new Pair<>(kelantan,cat)};
        }




}

      /* if (ticker.equals(state[i])) {
                            kl++;

                        }*/

               /*if (kl > 0) {
                    String title = doc.title();
                    int scrape = title.indexOf("9");
                    String category = title.substring(scrape + 1);
                   result = "|    " + state[i] + "    |     " + category + "     |     " + kl + "     |     ";

                }*/
//total +=kl;