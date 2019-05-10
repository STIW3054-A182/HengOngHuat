package groupProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {

    //static Vector<String> existList = new Vector<String>();
    //static String [] existLinkList;
    public static void main(String[] args) throws IOException {

        String path, fileName, state;

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);


        PropertyFileWriting obj = new PropertyFileWriting();
        Properties write = obj.setProperties();
        path = write.getProperty("path");
        fileName = write.getProperty("txtFile");
        state = write.getProperty("state");
        System.out.println("Path: " + path);
        System.out.println("FileName: " + fileName);
        System.out.println("State: " + state);

        Path path1 = Paths.get("C:\\Users\\HP\\Downloads\\url.txt"); //change your path
        List<String> line = null;
        line = Files.readAllLines(path1);

        System.out.println("******************* Players from Kedah **********************");
        String format = "| %-5s | %-5s | %-35s| %-8s| %-8s| %-8s| %-8s|\n";
        System.out.format(format, "RK", "SNo", "Name", "Rtg", "State", "Pts", "Category");


        for (int i = 0; i < line.size(); i++) {
            Thread myThread = new Thread(new KedahPlayers(line.get(i)));
            service.execute(myThread);
        }
        service.shutdown();
        /*System.out.println("**************************** DISPLAY VALID LINKS ****************************");
        //new FileWriter("myLogFile.log", false); //overwrites file

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
        for (String link2: existLinkList) {
            System.out.println("Valid Link: " + link2);
            Thread t1 = (new Thread(new KedahPlayers(link2)));
            t1.start();
        }*/

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