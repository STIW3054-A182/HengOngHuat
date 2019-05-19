package com.groupProject;

import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Lim Xin Yi
 * @version 1.0
 * @since 2019-04-25
 * Create ResultKedahPlayer class from ValidTableLink and implements with Runnable
 * ResultKedahPlayer uses to get result of players from Kedah
 */

public class ResultKedahPlayer extends ValidTableLink implements Runnable {
    public  ResultKedahPlayer(){}

    /**
     * This constructs a result of kedah player with a specified existList,existLinkList,existTableList,existTableLinkList.
     * @param existList valid link
     * @param existLinkList valid link list
     * @param existTableList valid table link
     * @param existTableLinkList valid table link list
     */

    public ResultKedahPlayer(Vector<String> existList, String [] existLinkList, Vector<String> existTableList, String [] existTableLinkList) {
        super(existList, existLinkList, existTableList, existTableLinkList);
    }


    @Override
    public void run() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        String format = "| %-5s | %-5s | %-35s| %-8s| %-8s| %-8s| %-8s|\n";
        System.out.format(format, "RK", "SNo", "Name", "Rtg", "State", "Pts", "Category");
        String format2 = "| %-5s | %-5s | %-35s| %-8s| %-8s| %-8s| %-8s|\n";
        System.out.format(format2, "-----", "-----", "-----------------------------------",
                "--------", "--------", "--------", "--------");

        for (int z = 0; z < getExistTableList().size(); z++) {
            String [] tableLink2 = getExistTableLinkList();
            KedahPlayers kp = new KedahPlayers(tableLink2[z]);
            FutureTask<String> future;
            future = (FutureTask<String>) service.submit(kp);
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}
