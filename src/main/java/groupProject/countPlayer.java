package groupProject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class countPlayer implements Runnable{
    int row;
    String link,Cat,cat;
    public static Vector<Integer> subTotal = new Vector<Integer>();
    private Integer sumTotal;
    private Integer[] a;

    public countPlayer(String link){
        this.link=link;
    }

    public countPlayer() {

    }

    public void run(){
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        long startTime, endTime, executeTime;
        String date = new Date().toString();
        String logFile = "myLogFile.log";
        File file = new File(logFile);
        FileWriter fw;
        BufferedWriter bw;

        try{
            startTime = System.currentTimeMillis();
            if(validTable(link)){
               category(link);
               validPlayer(link);
               subTotal.add(row);

               System.out.printf("| %-8s | %-5d |\n",cat.replace("(", "").replace(")", ""),row);
            }else{
               //System.out.println("|  Wrong   | 0     |");
                endTime = System.currentTimeMillis();
                executeTime = endTime - startTime;

                fw = new FileWriter(file, true); //appends to file
                bw = new BufferedWriter(fw);
                bw.write(date + "\t");
                bw.write(Thread.currentThread().getName() + " --> " + link + " (not exist player)");
                bw.write(System.lineSeparator());
                bw.write("Execution time in milliseconds: " + executeTime);
                bw.write(System.lineSeparator());
                bw.close();
            }
        }catch(Exception e){
            e.printStackTrace();
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