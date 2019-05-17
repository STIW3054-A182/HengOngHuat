package com.groupProject;

import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ResultTop3Player extends ValidTableLink implements Runnable {

    public ResultTop3Player() {

    }

    public ResultTop3Player(Vector<String> existList, String [] existLinkList, Vector<String> existTableList, String [] existTableLinkList) {
        super(existList, existLinkList, existTableList, existTableLinkList);
    }

    @Override
    public void run() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        for (int z = 0; z < getExistTableList().size(); z++) {
            String [] tableLink4 = getExistTableLinkList();
            Top3Players tp = new Top3Players(tableLink4[z]);
            FutureTask<String> future;
            future = (FutureTask<String>) service.submit(tp);
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
        service.shutdown();
    }
}
