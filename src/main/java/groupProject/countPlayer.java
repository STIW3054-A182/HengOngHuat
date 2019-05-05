package groupProject;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class countPlayer implements Runnable{
    String link,Cat,cat;
    int row,total=0;

    public countPlayer(String link){
        this.link=link;
    }

    public countPlayer() {

    }

    public void run(){
        if(validTable(link)){
            category(link);
            validPlayer(link);
            System.out.printf("| %-8s | %-5d |\n",cat.replace("(", "").replace(")", ""),row);
            //System.out.printf("| Total    | %-5d |\n",total);
        }else{
            System.out.println("|  Wrong   | 0     |");
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

    public int validPlayer(String url){
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            Element table = doc.select("table.CRs1").get(0);
            Elements rows = table.select("tr.CRg1.MAS");
            Elements rows1 = table.select("tr.CRg2.MAS");
            Elements rows2 = table.select("tr.CRg1.KGZ");
            Elements rows3 = table.select("tr.CRg2.KGZ");
            row = rows.size()+rows1.size()+rows2.size()+rows3.size();

        }catch (Exception e) {
            e.printStackTrace();
        }
        //total += row;
        return row;

    }

    public String category(String url){
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
            Element category = doc.select("div.defaultDialog").get(0);
            Elements cate = category.select("h2");
            Cat = cate.text();
            int scrape = Cat.indexOf("9");
            cat= Cat.substring(scrape + 1);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return cat;
    }
}
