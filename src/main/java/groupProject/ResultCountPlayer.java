package groupProject;

import java.util.Vector;
import java.util.concurrent.*;

public class ResultCountPlayer extends ValidTableLink implements Runnable {

    private Vector<Integer> totalPlayer = new Vector<>();
    private Future<Vector> future3;;
    private int resultTotal = 0;

    public ResultCountPlayer() {

    }

    public ResultCountPlayer(Vector<String> existList, String [] existLinkList, Vector<String> existTableList, String [] existTableLinkList) {
        super(existList, existLinkList, existTableList, existTableLinkList);
    }

    @Override
    public void run() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        System.out.printf("| %-8s | %-6s|\n", "Category", "Total");
        System.out.printf("| %-8s | %-6s|\n", "--------", "-----");

        for (int c = 0; c < getExistTableList().size(); c++) {
            String [] tableLink = getExistTableLinkList();
            CountPlayer countPlayer = new CountPlayer(tableLink[c]);
            future3 = service.submit(countPlayer);
            try {
                totalPlayer = future3.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        for (Integer totalPlayer:totalPlayer) {
            resultTotal += totalPlayer;
        }
        System.out.printf("| %-8s | %-5d |\n","Total",resultTotal);
        service.shutdown();
    }
}
