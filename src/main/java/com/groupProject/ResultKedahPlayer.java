package com.groupProject;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        String format2 = "| %-5s | %-5s | %-35s| %-8s| %-8s| %-8s| %-8s|\n";
        System.out.format(format2, "-----", "-----", "-----------------------------------",
                "--------", "--------", "--------", "--------");

        for (int z = 0; z < getExistTableList().size(); z++) {
            String [] tableLink2 = getExistTableLinkList();
            Thread myThread = new Thread(new KedahPlayers(tableLink2[z]));
            service.execute(myThread);
        }
        service.shutdown();
    }
}
