package com.groupProject;

import java.util.Vector;
import java.util.concurrent.*;

/**
 * Create ResultCountPlayer class from ValidTableLink implements with Runnable
 * @author Chong Mei Yong
 * @version 1.0
 * @since 2019-04-19
 */

public class ResultCountPlayer extends ValidTableLink implements Runnable {

    private Vector<Integer> totalPlayer = new Vector<>();
    private int resultTotal = 0;

    public ResultCountPlayer() {

    }

    /**
     * This constructs a result of total player with a specified existList,existLinkList,existTableList,existTableLinkList.
     * @param existList valid link
     * @param existLinkList valid link list
     * @param existTableList valid table link
     * @param existTableLinkList valid table link list
     */
    
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
            FutureTask<Vector<Integer>> future;
            future = (FutureTask<Vector<Integer>>) service.submit(countPlayer);
            try {
                totalPlayer = future.get();
            } catch (InterruptedException | ExecutionException e) {
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
