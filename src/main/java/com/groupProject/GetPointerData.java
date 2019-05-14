package com.groupProject;

import javafx.util.Pair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.Vector;
import java.util.concurrent.Callable;

public class GetPointerData implements Callable {
    private String link, cat;
    private double totalPointerKL, totalPointerNS,totalPointerPP,totalPointerPAHANG,totalPointerPTRJAYA,totalPointerPERAK,totalPointerSELANGOR,
            totalPointerJOHOR, totalPointerKEDAH, totalPointerSRW,totalPointerSB,totalPointerMLK,totalPointerKLT;
    private static Vector<Pair<Double,String>> subTotal = new Vector<>();

    public GetPointerData(String link) {
        this.link = link;
    }

    @Override
    public Vector<Pair<Double,String>> call() {
        try {
            if (getTwo(link)!=null){
                Pair<Double, String> p1 = new Pair<>(totalPointerKL,cat);
                Pair<Double, String> p2 = new Pair<>(totalPointerNS,cat);
                Pair<Double, String> p3 = new Pair<>(totalPointerPP,cat);
                Pair<Double, String> p4 = new Pair<>(totalPointerPAHANG,cat);
                Pair<Double, String> p5 = new Pair<>(totalPointerPTRJAYA,cat);
                Pair<Double, String> p6 = new Pair<>(totalPointerPERAK,cat);
                Pair<Double, String> p7 = new Pair<>(totalPointerSELANGOR,cat);
                Pair<Double, String> p8 = new Pair<>(totalPointerJOHOR,cat);
                Pair<Double, String> p9 = new Pair<>(totalPointerKEDAH,cat);
                Pair<Double, String> p10 = new Pair<>(totalPointerSRW,cat);
                Pair<Double, String> p11 = new Pair<>(totalPointerSB,cat);
                Pair<Double, String> p12 = new Pair<>(totalPointerMLK,cat);
                Pair<Double, String> p13 = new Pair<>(totalPointerKLT,cat);

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

    protected Pair[] getTwo(String url) {

        Document doc;
        try {
            doc = Jsoup.connect(url).get();

            String title = doc.title();
            int scrape = title.indexOf("9");
            cat = title.substring(scrape + 1).replace("(", "").replace(")", "");

            for (Element row : doc.select("table.CRs1 tr")) {
                final String ticker = row.select("td:nth-of-type(7)").text();
                final String point = row.select("td:nth-of-type(8)").text();
                if (ticker.equals("Pts.")) {
                    System.out.println(point.replace("Pts.", ""));
                }
                else {
                    switch (ticker) {
                        case "KUALA LUMPUR":
                            double pointerKL = Double.parseDouble(point.replace(",", "."));
                            totalPointerKL += pointerKL;
                            break;

                        case "N.SEMBILAN":
                            double pointerNS = Double.parseDouble(point.replace(",", "."));
                            totalPointerNS += pointerNS;
                            break;

                        case "PULAU PINANG":
                            double pointerPP = Double.parseDouble(point.replace(",", "."));
                            totalPointerPP += pointerPP;
                            break;

                        case "PAHANG":
                            double pointerPAHANG = Double.parseDouble(point.replace(",", "."));
                            totalPointerPAHANG += pointerPAHANG;
                            break;

                        case "PUTRAJAYA":
                            double pointerPTRJAYA = Double.parseDouble(point.replace(",", "."));
                            totalPointerPTRJAYA+= pointerPTRJAYA;
                            break;

                        case "PERAK":
                            double pointerPERAK = Double.parseDouble(point.replace(",", "."));
                            totalPointerPERAK += pointerPERAK;
                            break;

                        case "SELANGOR":
                            double pointerSELANGOR = Double.parseDouble(point.replace(",", "."));
                            totalPointerSELANGOR += pointerSELANGOR;

                        case "JOHOR":
                            double pointerJOHOR = Double.parseDouble(point.replace(",", "."));
                            totalPointerJOHOR+= pointerJOHOR;
                            break;

                        case "KEDAH":
                            double pointerKEDAH = Double.parseDouble(point.replace(",", "."));
                            totalPointerKEDAH+= pointerKEDAH;
                            break;

                        case "SARAWAK":
                            double pointerSRW = Double.parseDouble(point.replace(",", "."));
                            totalPointerSRW+= pointerSRW;
                            break;

                        case "SABAH":
                            double pointerSB = Double.parseDouble(point.replace(",", "."));
                            totalPointerSB+= pointerSB;
                            break;

                        case "MELAKA":
                            double pointerMLK = Double.parseDouble(point.replace(",", "."));
                            totalPointerMLK+= pointerMLK;
                            break;

                        case "KELANTAN":
                            double pointerKLT = Double.parseDouble(point.replace(",", "."));
                            totalPointerKLT+= pointerKLT;
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
