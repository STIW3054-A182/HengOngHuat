import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

import java.lang.String;

public class MainClass {

    public static Vector<String> existList = new Vector<String>();
    public static String [] existLinkList;
    public static Vector<Integer> total = new Vector<Integer>();
    public static Integer [] stateTotalList;


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


        System.out.printf("| %-12s | %-8s | %-6s|\n","State","Category","Total");
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
       for (int a=0;a<existList.size();a++){

            Thread1 link1 = new Thread1(existLinkList[a]);
            Future<Integer> future2= service.submit(link1);

        try {
            if (future2.get()>0) {
                int stateTotal = future2.get();
                total.add(stateTotal);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
        stateTotalList = new Integer[total.size()];
        total.copyInto(stateTotalList);
        int grandTotal=0;
        for (Integer totalOfState: stateTotalList){
            grandTotal+=totalOfState;
        }
      System.out.printf("| %-12s | %-8s | %-6d|\n","GRAND TOTAL","",grandTotal);

        //===============================================================================================================================================

        
       /* for (int a=0;a<existList.size();a++){

            //Thread1 link1 = new Thread1(existLinkList[a]);
            FutureTask<Integer> future2= new FutureTask(new Thread1(existLinkList[a]));
                    service.submit(future2);

            try {
                if (future2.get()>0) {
                    for(int v =0; v<13;v++) {

                       Integer stateTotal = future2.get();
                        total.add(stateTotal);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        stateTotalList = new Integer[total.size()];
        total.copyInto(stateTotalList);
        int totalKL=0;
        for (Integer totalOfState: stateTotalList){

            // System.out.println("total : "+totalOfState);
            totalKL+=totalOfState;
        }
        // System.out.println("|               |     TOTAL     |     "+totalKL+"     |");
        // System.out.printf("| %-8s | %-5d |\n",cat.replace("(", "").replace(")", ""),row);
        System.out.printf("| %-12s | %-8s | %-5d |\n","","TOTAL",totalKL);
        */

        //System.out.println("total : "+totalKL);

      /*     Thread thread = new Thread(new CheckURLs(line.get(a)));
                service.execute(thread);
            Thread thread2 = new Thread(new Thread1(line.get(a)));
                service.execute(thread2);
        }*/
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