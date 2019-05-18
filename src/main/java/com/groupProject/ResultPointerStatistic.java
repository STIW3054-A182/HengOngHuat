package com.groupProject;

import javafx.util.Pair;

import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Create ResultPointerStatistic class from ValidTableLink and implements with Runnable
 * @author Liew Sin Hui
 * @version 1.0
 * @since 2019-04-19
 */
public class ResultPointerStatistic extends ValidTableLink implements Runnable {
    /**
     * Classify the data for 13 states by category.
     */
    
    private final String [] state={"KUALA LUMPUR", "N.SEMBILAN","PULAU PINANG","PAHANG","PUTRAJAYA","PERAK","SELANGOR",
            "JOHOR","KEDAH","SARAWAK","SABAH","MELAKA","KELANTAN"};

    private Vector<Pair<Double, String>> stateTotalPoint = new Vector<Pair<Double, String>>();
    private Vector<Double> stateKLTotalPointer = new Vector<>();
    private Vector<Double> stateNSTotalPointer = new Vector<>();
    private Vector<Double> statePPTotalPointer = new Vector<>();
    private Vector<Double> statePHGTotalPointer = new Vector<>();
    private Vector<Double> statePTRTotalPointer = new Vector<>();
    private Vector<Double> statePRTotalPointer = new Vector<>();
    private Vector<Double> stateSLGTotalPointer = new Vector<>();
    private Vector<Double> stateJHTotalPointer = new Vector<>();
    private Vector<Double> stateKDTotalPointer = new Vector<>();
    private Vector<Double> stateSRWTotalPointer = new Vector<>();
    private Vector<Double> stateSBTotalPointer = new Vector<>();
    private Vector<Double> stateMLKTotalPointer = new Vector<>();
    private Vector<Double> stateKLTTotalPointer = new Vector<>();
    private Vector<String> catCodePointer = new Vector<>();
    private String [] eachStatePoints;

    public ResultPointerStatistic() {

    }
    
    /**
     * This constructs a result of points statistic with a specified existList,existLinkList,existTableList,existTableLinkList.
     * @param existList valid link
     * @param existLinkList valid link list
     * @param existTableList valid table link
     * @param existTableLinkList valid table link list
     */
    public ResultPointerStatistic(Vector<String> existList, String [] existLinkList, Vector<String> existTableList, String [] existTableLinkList) {
        super(existList, existLinkList, existTableList, existTableLinkList);
    }

    @Override
    public void run() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        System.out.printf("| %-12s | %-8s | %-6s|\n", "State", "Category", "Total");
        System.out.printf("| %-12s | %-8s | %-6s|\n", "------------", "--------", "-----");

        for (int x = 0; x < getExistTableList().size(); x++) {
            eachStatePoints = getExistTableLinkList();
            GetPointerData link = new GetPointerData(eachStatePoints[x]);
            FutureTask<Vector<Pair<Double, String>>> future;
            future = (FutureTask<Vector<Pair<Double, String>>>) service.submit(link);
            try {
                stateTotalPoint = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        int a;
        for (a = 0; a < stateTotalPoint.size(); a++) {
            stateKLTotalPointer.add(stateTotalPoint.get((a)).getKey());
            stateNSTotalPointer.add(stateTotalPoint.get((a+1)).getKey());
            statePPTotalPointer.add(stateTotalPoint.get((a+2)).getKey());
            statePHGTotalPointer.add(stateTotalPoint.get((a+3)).getKey());
            statePTRTotalPointer.add(stateTotalPoint.get((a+4)).getKey());
            statePRTotalPointer.add(stateTotalPoint.get((a+5)).getKey());
            stateSLGTotalPointer.add(stateTotalPoint.get((a+6)).getKey());
            stateJHTotalPointer.add(stateTotalPoint.get((a+7)).getKey());
            stateKDTotalPointer.add(stateTotalPoint.get((a+8)).getKey());
            stateSRWTotalPointer.add(stateTotalPoint.get((a+9)).getKey());
            stateSBTotalPointer.add(stateTotalPoint.get((a+10)).getKey());
            stateMLKTotalPointer.add(stateTotalPoint.get((a+11)).getKey());
            stateKLTTotalPointer.add(stateTotalPoint.get((a+12)).getKey());
            catCodePointer.add(stateTotalPoint.get((a)).getValue());
            a+=12;
        }

        CalculationPoints stateKL = new CalculationPoints();
        stateKL.calculateTotalPointer(stateKLTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            stateKL.catState(state[0],catCodePointer.get(a),stateKLTotalPointer.get(a));
            stateKL.printResultPointer();
        }
        stateKL.printGrandTotalPointer();

        CalculationPoints stateNS = new CalculationPoints();
        stateNS.calculateTotalPointer(stateNSTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            stateNS.catState(state[1],catCodePointer.get(a),stateNSTotalPointer.get(a));
            stateNS.printResultPointer();
        }
        stateNS.printGrandTotalPointer();

        CalculationPoints statePP = new CalculationPoints();
        statePP.calculateTotalPointer(statePPTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            statePP.catState(state[2],catCodePointer.get(a),statePPTotalPointer.get(a));
            statePP.printResultPointer();
        }
        statePP.printGrandTotalPointer();

        CalculationPoints statePHG = new CalculationPoints();
        statePHG.calculateTotalPointer(statePHGTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            statePHG.catState(state[3],catCodePointer.get(a),statePHGTotalPointer.get(a));
            statePHG.printResultPointer();
        }
        statePHG.printGrandTotalPointer();

        CalculationPoints statePTR = new CalculationPoints();
        statePTR.calculateTotalPointer(statePTRTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            statePTR.catState(state[4],catCodePointer.get(a),statePTRTotalPointer.get(a));
            statePTR.printResultPointer();
        }
        statePTR.printGrandTotalPointer();

        CalculationPoints statePR = new CalculationPoints();
        statePR.calculateTotalPointer(statePRTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            statePR.catState(state[5],catCodePointer.get(a),statePRTotalPointer.get(a));
            statePR.printResultPointer();
        }
        statePR.printGrandTotalPointer();

        CalculationPoints stateSLG = new CalculationPoints();
        stateSLG.calculateTotalPointer(stateSLGTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            stateSLG.catState(state[6],catCodePointer.get(a),stateSLGTotalPointer.get(a));
            stateSLG.printResultPointer();
        }
        stateSLG.printGrandTotalPointer();

        CalculationPoints stateJH = new CalculationPoints();
        stateJH.calculateTotalPointer(stateJHTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            stateJH.catState(state[7],catCodePointer.get(a),stateJHTotalPointer.get(a));
            stateJH.printResultPointer();
        }
        stateJH.printGrandTotalPointer();

        CalculationPoints stateKD = new CalculationPoints();
        stateKD.calculateTotalPointer(stateKDTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            stateKD.catState(state[8],catCodePointer.get(a),stateKDTotalPointer.get(a));
            stateKD.printResultPointer();
        }
        stateKD.printGrandTotalPointer();

        CalculationPoints stateSRW = new CalculationPoints();
        stateSRW.calculateTotalPointer(stateSRWTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            stateSRW.catState(state[9],catCodePointer.get(a),stateSRWTotalPointer.get(a));
            stateSRW.printResultPointer();
        }
        stateSRW.printGrandTotalPointer();

        CalculationPoints stateSB = new CalculationPoints();
        stateSB.calculateTotalPointer(stateSBTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            stateSB.catState(state[10],catCodePointer.get(a),stateSBTotalPointer.get(a));
            stateSB.printResultPointer();
        }
        stateSB.printGrandTotalPointer();

        CalculationPoints stateMLK = new CalculationPoints();
        stateMLK.calculateTotalPointer(stateMLKTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            stateMLK.catState(state[11],catCodePointer.get(a),stateMLKTotalPointer.get(a));
            stateMLK.printResultPointer();
        }
        stateMLK.printGrandTotalPointer();

        CalculationPoints stateKLT = new CalculationPoints();
        stateKLT.calculateTotalPointer(stateKLTTotalPointer);
        for (a = 0; a < eachStatePoints.length; a++) {
            stateKLT.catState(state[12],catCodePointer.get(a),stateKLTTotalPointer.get(a));
            stateKLT.printResultPointer();
        }
        stateKLT.printGrandTotalPointer();

        CalculationPoints points = new CalculationPoints();
        //get total points for each state by category from CalculationPoints class and count all the points
        double grandTotalPointer = stateKL.getGrandTotalPointer() + stateNS.getGrandTotalPointer() + statePP.getGrandTotalPointer() +
                                    statePHG.getGrandTotalPointer() + statePTR.getGrandTotalPointer() + statePR.getGrandTotalPointer() +
                                    stateSLG.getGrandTotalPointer() + stateJH.getGrandTotalPointer() + stateKD.getGrandTotalPointer() +
                                    stateSRW.getGrandTotalPointer() + stateSB.getGrandTotalPointer() + stateMLK.getGrandTotalPointer() +
                                    stateKLT.getGrandTotalPointer();
        points.printFinalResultPointer(grandTotalPointer);

        service.shutdown();
    }
}
