package groupProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;
import java.lang.String;

public class MainClass {

    static Vector<String> existList = new Vector<String>();
    static String [] existLinkList;
    static Vector<String> existTableList = new Vector<String>();
    static String [] existTableLinkList;

    public static void main (String[] args) throws IOException {

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        Path path = Paths.get("C:\\Users\\asus\\IdeaProjects\\HengOngHuat-Repo-252823\\URL.txt");
        List<String> line = null;
        line = Files.readAllLines(path);
        System.out.println("**************************** DISPLAY VALID LINKS ****************************");

        for (int a=0; a<line.size();a++) {
            CheckUrls link1 = new CheckUrls(line.get(a));
            Future<String> future = service.submit(link1);
            try {
                if (future.get() != null) {
                    String existLink = future.get();
                    existList.add(existLink);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        existLinkList = new String[existList.size()];
        existList.copyInto(existLinkList);

        //===============================

        for (int b = 0; b < existList.size(); b++) {
            CheckValidTable link1 = new CheckValidTable(existLinkList[b]);
            Future<String> future = service.submit(link1);
            try {
                if (future.get() != null) {
                    String existTableLink = future.get();
                    existTableList.add(existTableLink);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        existTableLinkList = new String[existTableList.size()];
        existTableList.copyInto(existTableLinkList);
        System.out.println("============================================================================== ");
        for (int a =0; a<existTableLinkList.length;a++) {
            System.out.println("Valid Link(Table) "+(a+1)+" : "+existTableLinkList[a]);
        }

        //===============================

        ResultCountPlayer totalPlayer=new ResultCountPlayer();
        Thread thread1 = new Thread(totalPlayer);
        thread1.start();
        try {
            thread1.join();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

        try {
            service.shutdown();
            if (!service.awaitTermination(60, TimeUnit.SECONDS)) { //wait for existing tasks to terminate
                service.shutdownNow(); //cancel currently executing task
                if (!service.awaitTermination(60, TimeUnit.SECONDS)) { //wait for tasks to respond to being cancelled
                    System.err.println("Service didn't terminate!");
                }
            }
        } catch (InterruptedException e) {
            service.shutdownNow(); //re-cancel if current thread also interrupted
            Thread.currentThread().interrupt(); //preserve interrupt status
        }
    }
}