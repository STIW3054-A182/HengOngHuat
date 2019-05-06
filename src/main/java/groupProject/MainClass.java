package groupProject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;

public class MainClass {

    public static void main (String[] args) throws IOException {

        String path, fileName;

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        PropertyFileWriting obj = new PropertyFileWriting();
        Properties write = obj.setProperties();
        path = write.getProperty("path");
        fileName = write.getProperty("txtFile");
        System.out.println("Path: " + path);
        System.out.println("FileName: " + fileName);

        Path path1 = Paths.get("C:\\Users\\user\\Desktop\\URL.txt"); //change your path
        List<String> line = null;
        line = Files.readAllLines(path1);

        System.out.println("**************************** DISPLAY VALID LINKS ****************************");
        new FileWriter("myLogFile.log", false); //overwrites file
        for (int a = 0; a < line.size(); a++) {
            CheckUrls link1 = new CheckUrls(line.get(a));
            Future<String> future = service.submit(link1);
            try {
                if (future.get() != null) {
                    //validLink = future.get();
                    Thread thread = new Thread();
                    service.execute(thread);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
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
