import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.lang.String;
import java.util.concurrent.ExecutionException;

public class MainClass {
    public static String validLink;
    public static void main (String[] args) throws IOException {

        /*  DisplayStatistic kl = new DisplayStatistic();
        Future<Integer> future = executorService.submit(kl);

        try {
            bilPerak[i]=future.get();
            System.out.println("|     Perak     |                  |       " + bilPerak[i]+"       |");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        Path path = Paths.get("C:\\Users\\Asus\\Documents\\sem 4\\REAL TIME\\STIW3054-Project\\URL.txt");
        List<String> line = null;
        line = Files.readAllLines(path);
        System.out.println("**************************** DISPLAY VALID LINKS ****************************");
        for (int a = 0; a < line.size(); a++) {
            CheckURLs link1 =new CheckURLs(line.get(a));
            Future<String> future = service.submit(link1);
            try {
                if (future.get()!=null) {
                    validLink=future.get();
                    Thread thread2 = new Thread(new Thread1(validLink));
                    service.execute(thread2);
                   // System.out.println("Valid link: "+future.get());
                }
            }catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

           /* Thread thread = new Thread(new CheckURLs(line.get(a)));
                service.execute(thread);


            Thread thread2 = new Thread(new Thread1(line.get(a)));
                service.execute(thread2);*/
        }


        service.shutdown();
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