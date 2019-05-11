
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.Vector;
import javafx.util.Pair;
import java.util.concurrent.Callable;

public class GetStateData implements Callable{
    String link,cat;
    int kl,ns,pp,pahang,ptrjaya,perak,selangor,johor,kedah,sarawak,sabah,melaka,kelantan;
    public static Vector<Pair<Integer,String>> subTotal = new Vector<Pair<Integer,String>>();


   public GetStateData(String link){

        this.link=link;
   }

    public Vector<Pair<Integer,String>> call() throws Exception {

        try {
                if (getTwo(link)!=null) {
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

    public Pair[] getTwo(String url) {

        Document doc = null;
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
