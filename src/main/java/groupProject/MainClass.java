package groupProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

public class MainClass {
    static Vector<String> validList = new Vector<String>();
    static String [] validLinkList;
    static String validLink;

    public static void main (String[] args) throws IOException {

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        Path path = Paths.get("C:\\Users\\asus\\IdeaProjects\\HengOngHuat-Repo-252823\\URL.txt");
        List<String> line = null;
        line = Files.readAllLines(path);
        //System.out.println("**************************** DISPLAY VALID LINKS ****************************");
        System.out.println("| Category | Total | ");
        for (int a = 0; a < line.size(); a++) {
            CheckUrls link = new CheckUrls(line.get(a));
            Future<String> future = service.submit(link);

            try{
                if(future.get()!=null){
                    validLink = future.get();
                    Thread thread1 = new Thread((Runnable) new countPlayer(validLink));
                    service.execute(thread1);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }catch(ExecutionException e){
                e.printStackTrace();
            }
            //validLinkList = new String[validList.size()];
            //validList.copyInto(validLinkList);
        }
        service.shutdown();
        countPlayer count = new countPlayer();
        //System.out.printf("| Total    | %-5s |\n",count.getTotal());

        try {
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