package com.groupProject;

import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ResultKedahPlayer extends ValidTableLink implements Runnable {

    public ResultKedahPlayer() {

    }

    public ResultKedahPlayer(Vector<String> existList, String [] existLinkList, Vector<String> existTableList, String [] existTableLinkList) {
        super(existList, existLinkList, existTableList, existTableLinkList);
    }

    @Override
    public void run() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        String format = "| %-5s | %-5s | %-35s| %-8s| %-8s| %-8s| %-8s|\n";
        System.out.format(format, "RK", "SNo", "Name", "Rtg", "State", "Pts", "Category");

        for (int z = 0; z < getExistTableList().size(); z++) {
            String [] tableLink2 = getExistTableLinkList();
            KedahPlayers kedahPlayer = new KedahPlayers(tableLink2[z]);
            FutureTask<String> future;
            future = (FutureTask<String>) service.submit(kedahPlayer);
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}
