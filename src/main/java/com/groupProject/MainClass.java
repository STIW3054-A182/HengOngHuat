package com.groupProject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class MainClass {
    public static void main (String[] args) throws IOException {

        String path, fileName, filePath;
        PropertyFileWriting obj = new PropertyFileWriting();
        Properties write = obj.setProperties();
        path = write.getProperty("path");
        fileName = write.getProperty("txtFile");
        filePath = path + fileName;
        System.out.println("Path: " + filePath);

        System.out.println("**************************** DISPLAY VALID LINKS ****************************");
        new FileWriter("myLogFile.log", false); //overwrites file
        ValidLink validLink = new ValidLink();
        validLink.allLink();

        System.out.println("\n\n************************** COUNT NUMBER OF PLAYERS **************************");
        ValidTableLink validTableLink = new ValidTableLink(); //check the link which the category has more than 1 and store it by array
        validTableLink.existTableLink();
        ResultCountPlayer resultCountPlayer = new ResultCountPlayer();
        Thread t1 = new Thread(resultCountPlayer);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n***************************** DISPLAY STATISTICS ****************************");
        ResultStateStatistic stateStatistic = new ResultStateStatistic();
        Thread t2 = new Thread(stateStatistic);
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n********************************** DISPLAY ALL PLAYERS FROM KEDAH *********************************");
        ResultKedahPlayer kedahPlayers = new ResultKedahPlayer();
        Thread t3 = new Thread(kedahPlayers);
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n***************************** DISPLAY ALL TOP 3 PLAYERS FROM EACH CATEGORY *****************************");
        ResultTop3Player topPlayer = new ResultTop3Player();
        Thread t4 = new Thread(topPlayer);
        t4.start();
        try {
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n******************************* COUNT WINNING POINTS ******************************");
        ResultPointerStatistic pointsStatistic = new ResultPointerStatistic();
        Thread t5 = new Thread(pointsStatistic);
        t5.start();
        try {
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n************************************* DISPLAY A PLAYER RESULT *************************************");
        ResultNamePlayer namePlayer = new ResultNamePlayer();
        Thread t6 = new Thread(namePlayer);
        t6.start();
        try {
            t6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
