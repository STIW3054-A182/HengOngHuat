package groupProject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class KedahPlayers implements Runnable {
    String link;


    public KedahPlayers (String link) {
        this.link = link;
    }

    @Override
    public void run(){
        if (validTable(link)) {
            Document doc = null;

            try {
                doc = Jsoup.connect(link).get();

                //get category
                String title = doc.title();
                int scrape = title.indexOf("9");
                String category = title.substring(scrape + 1).replace("(","").replace(")","");

                for (Element row : doc.select("table.CRs1 tr")) {
                    final String rk=row.select("td:nth-of-type(1)").text();
                    final String sno=row.select("td:nth-of-type(2)").text();
                    final String name=row.select("td:nth-of-type(4)").text();
                    final String rtg=row.select("td:nth-of-type(6)").text();
                    final String state=row.select("td:nth-of-type(7)").text();
                    final String pointer=row.select("td:nth-of-type(8)").text();


                    if (state.equals("KEDAH")) {
                        String format ="| %-5s | %-5s | %-35s| %-8s| %-8s| %-8s| %-8s|\n";
                        System.out.format(format, rk, sno, name, rtg, state, pointer, category);

                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public boolean validTable(String url) {

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            if (doc.select("table.CRs1 tr").isEmpty())
                return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}

