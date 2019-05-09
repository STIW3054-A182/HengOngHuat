import javafx.util.Pair;

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

    public static void main (String[] args) throws IOException {

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        Path path = Paths.get("C:\\Users\\Asus\\Documents\\sem 4\\REAL TIME\\STIW3054-Project\\URL.txt");
        List<String> line = null;
        line = Files.readAllLines(path);
        System.out.println("**************************** DISPLAY VALID LINKS ****************************");

        for (int a=0; a<line.size();a++) {

            CheckURLs link1 = new CheckURLs(line.get(a));
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
        for (String link2: existLinkList){
            System.out.println("Valid Link: "+link2);
        }

     // ==============================================================================================================================

        ResultStateStatistic statisticState=new ResultStateStatistic();
        Thread thread1 = new Thread(statisticState);
        thread1.start();
        try {
            thread1.join();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }


        ResultPointerStatistic statisticPointer=new ResultPointerStatistic();
        Thread thread2 = new Thread(statisticPointer);
        thread2.start();
        try {
            thread2.join();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }


        //===============================================================================================================================================


      /*  try {
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
        }*/

    }


}