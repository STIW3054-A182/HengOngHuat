import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.Vector;
import javafx.util.Pair;
import java.util.concurrent.Callable;

public class GetPointerData implements Callable{
    String link,cat;
    double pointerKL, pointerNS, pointerPP, pointerPAHANG, pointerPTRJAYA, pointerPERAK, pointerSELANGOR, pointerJOHOR,
            pointerKEDAH, pointerSRW, pointerSB, pointerMLK, pointerKLT;
    double totalPointerKL, totalPointerNS,totalPointerPP,totalPointerPAHANG,totalPointerPTRJAYA,totalPointerPERAK,totalPointerSELANGOR,
            totalPointerJOHOR, totalPointerKEDAH, totalPointerSRW,totalPointerSB,totalPointerMLK,totalPointerKLT;
    public static Vector<Pair<Double,String>> subTotal = new Vector<Pair<Double,String>>();


    public GetPointerData(String link){

        this.link=link;
    }

    public Vector<Pair<Double,String>> call() throws Exception {
        try {
                if (getTwo(link)!=null){
                    Pair p1=new Pair(totalPointerKL,cat);
                    Pair p2=new Pair(totalPointerNS,cat);
                    Pair p3=new Pair(totalPointerPP,cat);
                    Pair p4=new Pair(totalPointerPAHANG,cat);
                    Pair p5=new Pair(totalPointerPTRJAYA,cat);
                    Pair p6=new Pair(totalPointerPERAK,cat);
                    Pair p7=new Pair(totalPointerSELANGOR,cat);
                    Pair p8=new Pair(totalPointerJOHOR,cat);
                    Pair p9=new Pair(totalPointerKEDAH,cat);
                    Pair p10=new Pair(totalPointerSRW,cat);
                    Pair p11=new Pair(totalPointerSB,cat);
                    Pair p12=new Pair(totalPointerMLK,cat);
                    Pair p13=new Pair(totalPointerKLT,cat);

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
                final String point = row.select("td:nth-of-type(8)").text();
                if (ticker.equals("Pts.")) {
                    System.out.println(point.replace("Pts.", ""));
                }
                else {
                    switch (ticker) {
                        case "KUALA LUMPUR":
                            pointerKL = Double.parseDouble(point.replace(",", "."));
                            totalPointerKL += pointerKL;
                            break;

                        case "N.SEMBILAN":
                            pointerNS = Double.parseDouble(point.replace(",", "."));
                            totalPointerNS += pointerNS;
                            break;

                        case "PULAU PINANG":
                            pointerPP = Double.parseDouble(point.replace(",", "."));
                            totalPointerPP += pointerPP;
                            break;

                        case "PAHANG":
                            pointerPAHANG = Double.parseDouble(point.replace(",", "."));
                            totalPointerPAHANG += pointerPAHANG;
                            break;

                        case "PUTRAJAYA":
                            pointerPTRJAYA = Double.parseDouble(point.replace(",", "."));
                            totalPointerPTRJAYA+= pointerPTRJAYA;
                            break;

                        case "PERAK":
                            pointerPERAK= Double.parseDouble(point.replace(",", "."));
                            totalPointerPERAK += pointerPERAK;
                            break;

                        case "SELANGOR":
                            pointerSELANGOR = Double.parseDouble(point.replace(",", "."));
                            totalPointerSELANGOR += pointerSELANGOR;

                        case "JOHOR":
                            pointerJOHOR = Double.parseDouble(point.replace(",", "."));
                            totalPointerJOHOR+=pointerJOHOR;
                            break;

                        case "KEDAH":
                            pointerKEDAH = Double.parseDouble(point.replace(",", "."));
                            totalPointerKEDAH+=pointerKEDAH;
                            break;

                        case "SARAWAK":
                            pointerSRW = Double.parseDouble(point.replace(",", "."));
                            totalPointerSRW+=pointerSRW;
                            break;

                        case "SABAH":
                            pointerSB = Double.parseDouble(point.replace(",", "."));
                            totalPointerSB+=pointerSB;
                            break;

                        case "MELAKA":
                            pointerMLK = Double.parseDouble(point.replace(",", "."));
                            totalPointerMLK+=pointerMLK;
                            break;

                        case "KELANTAN":
                            pointerKLT = Double.parseDouble(point.replace(",", "."));
                            totalPointerKLT+=pointerKLT ;
                            break;

                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Pair []{new Pair<>(totalPointerKL,cat),new Pair<>(totalPointerNS,cat), new Pair<>(totalPointerPP,cat),new Pair<>(totalPointerPAHANG,cat),
                new Pair<>(totalPointerPTRJAYA,cat),new Pair<>(totalPointerPERAK,cat),new Pair<>(totalPointerSELANGOR,cat),new Pair<>(totalPointerJOHOR,cat),
                new Pair<>(totalPointerKEDAH,cat),new Pair<>(totalPointerSRW,cat),new Pair<>(totalPointerSB,cat),new Pair<>(totalPointerMLK,cat),
                new Pair<>(totalPointerKLT,cat)};
    }
}
