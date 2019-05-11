package groupProject;

import java.util.Vector;
import java.util.concurrent.*;

public class ResultCountPlayer extends MainClass implements Runnable {

    Vector<Integer> totalPlayer = new Vector< >();

    public void run() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        State displayResult = new State();
        displayResult.printTotalPlayerTitle();

        for (int b = 0; b < existTableList.size(); b++) {
           countPlayer link1 = new countPlayer(existTableLinkList[b]);
            FutureTask<Vector> future3;
            future3 = (FutureTask<Vector>) service.submit(link1);
            try {
                totalPlayer = future3.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        int resultTotal=0;
        for (Integer totalPlayer:totalPlayer ){
            resultTotal+=totalPlayer;
        }
        System.out.printf("| %-8s | %-5d |\n","Total",resultTotal);
    }
}
