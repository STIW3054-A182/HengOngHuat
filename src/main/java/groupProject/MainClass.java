package groupProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {
    public static void main (String[] args) throws IOException {

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        Path path = Paths.get("C:\\Users\\user\\Desktop\\URL.txt");
        List<String> line = null;
        line = Files.readAllLines(path);
        System.out.println("**************************** DISPLAY VALID LINKS ****************************");
        for (int a = 0; a < line.size(); a++) {
            Thread thread = new Thread(new CheckUrls(line.get(a)));
            service.execute(thread);
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
