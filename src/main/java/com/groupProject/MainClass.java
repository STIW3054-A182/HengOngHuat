package com.groupProject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class MainClass {
    public static void main (String[] args) throws IOException {

        /*String path, fileName;
        PropertyFileWriting obj = new PropertyFileWriting();
        Properties write = obj.setProperties();
        path = write.getProperty("path");
        fileName = write.getProperty("txtFile");
        System.out.println("Path: " + path);
        System.out.println("FileName: " + fileName);*/

        System.out.println("**************************** DISPLAY VALID LINKS ****************************");
        new FileWriter("myLogFile.log", false); //overwrites file
        ValidLink validLink = new ValidLink();
        validLink.allLink();

        System.out.println("\n************************** COUNT NUMBER OF PLAYERS **************************");
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

        System.out.println("\n***************************** DISPLAY STATISTICS ****************************");
        ResultStateStatistic stateStatistic = new ResultStateStatistic();
        Thread t2 = new Thread(stateStatistic);
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n**************************** COUNT WINNING POINTS ****************************");
        ResultPointerStatistic pointsStatistic = new ResultPointerStatistic();
        Thread t4 = new Thread(pointsStatistic);
        t4.start();
        try {
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
