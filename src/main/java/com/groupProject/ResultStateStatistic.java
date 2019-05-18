package com.groupProject;

import javafx.util.Pair;

import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Create ResultStateStatistic class from ValidTableLink and implements with Runnable
 * @author Liew Sin Hui
 * @version 1.0
 * @since 2019-04-19
 */
public class ResultStateStatistic extends ValidTableLink implements Runnable {
     /**
     * Classify the data for 13 states by category.
     */

    private final String [] state={"KUALA LUMPUR", "N.SEMBILAN","PULAU PINANG","PAHANG","PUTRAJAY","PERAK","SELANGOR",
            "JOHOR","KEDAH","SARAWAK","SABAH","MELAKA","KELANTAN"};

    private Vector<Pair<Integer,String>> stateTotal = new Vector<>();
    private Vector<Integer>  stateKLTotal = new Vector<>();
    private Vector<Integer>  stateNSTotal = new Vector<>();
    private Vector<Integer>  statePPTotal = new Vector<>();
    private Vector<Integer> statePHGTotal = new Vector<>();
    private Vector<Integer> statePTRTotal = new Vector<>();
    private Vector<Integer>  statePRTotal = new Vector<>();
    private Vector<Integer> stateSLGTotal = new Vector<>();
    private Vector<Integer>  stateJHTotal = new Vector<>();
    private Vector<Integer> stateKDTotal = new Vector<>();
    private Vector<Integer>  stateSRWTotal = new Vector<>();
    private Vector<Integer> stateSBTotal = new Vector<>();
    private Vector<Integer> stateMLKTotal = new Vector<>();
    private Vector<Integer>  stateKLTTotal = new Vector<>();
    private Vector<String> catCode = new Vector<>();
    private String [] eachStateData;

    public ResultStateStatistic() {

    }
    
      /**
     * This constructs a result of player statistic with a specified existList,existLinkList,existTableList,existTableLinkList.
     * @param existList valid link
     * @param existLinkList valid link list
     * @param existTableList valid table link
     * @param existTableLinkList valid table link list
     */
    public ResultStateStatistic(Vector<String> existList, String [] existLinkList, Vector<String> existTableList, String [] existTableLinkList) {
        super(existList, existLinkList, existTableList, existTableLinkList);
    }

    @Override
    public void run() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        System.out.printf("| %-12s | %-8s | %-6s|\n", "State", "Category", "Total");
        System.out.printf("| %-12s | %-8s | %-6s|\n", "------------", "--------", "-----");

        for (int x = 0; x < getExistTableList().size(); x++) {
            eachStateData = getExistTableLinkList();
            GetStateData link = new GetStateData(eachStateData[x]);
            FutureTask<Vector<Pair<Integer, String>>> future;
            future = (FutureTask<Vector<Pair<Integer, String>>>) service.submit(link);
            try {
                stateTotal = future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        int a;
        for (a = 0; a < stateTotal.size(); a++) {
            stateKLTotal.add(stateTotal.get((a)).getKey());
            stateNSTotal.add(stateTotal.get((a +1)).getKey());
            statePPTotal.add(stateTotal.get((a +2)).getKey());
            statePHGTotal.add(stateTotal.get((a +3)).getKey());
            statePTRTotal.add(stateTotal.get((a +4)).getKey());
            statePRTotal.add(stateTotal.get((a +5)).getKey());
            stateSLGTotal.add(stateTotal.get((a +6)).getKey());
            stateJHTotal.add(stateTotal.get((a +7)).getKey());
            stateKDTotal.add(stateTotal.get((a +8)).getKey());
            stateSRWTotal.add(stateTotal.get((a +9)).getKey());
            stateSBTotal.add(stateTotal.get((a +10)).getKey());
            stateMLKTotal.add(stateTotal.get((a +11)).getKey());
            stateKLTTotal.add(stateTotal.get((a +12)).getKey());
            catCode.add(stateTotal.get((a)).getValue());
            a +=12;
        }

        CalculationState stateKL = new CalculationState();
        stateKL.calculateTotal(stateKLTotal);
        for (a = 0; a < eachStateData.length; a++) {
            stateKL.catState(state[0],catCode.get(a),stateKLTotal.get(a));
            stateKL.printResult();
        }
        stateKL.printGrandTotal();

        CalculationState stateNS = new CalculationState();
        stateNS.calculateTotal(stateNSTotal);
        for (a = 0; a < eachStateData.length; a++) {
            stateNS.catState(state[1],catCode.get(a),stateNSTotal.get(a));
            stateNS.printResult();
        }
        stateNS.printGrandTotal();

        CalculationState statePP = new CalculationState();
        statePP.calculateTotal(statePPTotal);
        for (a = 0; a < eachStateData.length; a++) {
            statePP.catState(state[2],catCode.get(a),statePPTotal.get(a));
            statePP.printResult();
        }
        statePP.printGrandTotal();

        CalculationState statePHG = new CalculationState();
        statePHG.calculateTotal(statePHGTotal);
        for (a = 0; a < eachStateData.length; a++) {
            statePHG.catState(state[3],catCode.get(a),statePHGTotal.get(a));
            statePHG.printResult();
        }
        statePHG.printGrandTotal();

        CalculationState statePTR = new CalculationState();
        statePTR.calculateTotal(statePTRTotal);
        for (a = 0; a < eachStateData.length; a++) {
            statePTR.catState(state[4],catCode.get(a),statePTRTotal.get(a));
            statePTR.printResult();
        }
        statePTR.printGrandTotal();

        CalculationState statePR = new CalculationState();
        statePR.calculateTotal(statePRTotal);
        for (a = 0; a < eachStateData.length; a++) {
            statePR.catState(state[5],catCode.get(a),statePRTotal.get(a));
            statePR.printResult();
        }
        statePR.printGrandTotal();

        CalculationState stateSLG = new CalculationState();
        stateSLG.calculateTotal(stateSLGTotal);
        for (a = 0; a < eachStateData.length; a++) {
            stateSLG.catState(state[6],catCode.get(a),stateSLGTotal.get(a));
            stateSLG.printResult();
        }
        stateSLG.printGrandTotal();

        CalculationState stateJH = new CalculationState();
        stateJH.calculateTotal(stateJHTotal);
        for (a = 0; a < eachStateData.length; a++) {
            stateJH.catState(state[7],catCode.get(a),stateJHTotal.get(a));
            stateJH.printResult();
        }
        stateJH.printGrandTotal();

        CalculationState stateKD = new CalculationState();
        stateKD.calculateTotal(stateKDTotal);
        for (a = 0; a < eachStateData.length; a++) {
            stateKD.catState(state[8],catCode.get(a),stateKDTotal.get(a));
            stateKD.printResult();
        }
        stateKD.printGrandTotal();

        CalculationState stateSRW = new CalculationState();
        stateSRW.calculateTotal(stateSRWTotal);
        for (a = 0; a < eachStateData.length; a++) {
            stateSRW.catState(state[9],catCode.get(a),stateSRWTotal.get(a));
            stateSRW.printResult();
        }
        stateSRW.printGrandTotal();

        CalculationState stateSB = new CalculationState();
        stateSB.calculateTotal(stateSBTotal);
        for (a = 0; a < eachStateData.length; a++) {
            stateSB.catState(state[10],catCode.get(a),stateSBTotal.get(a));
            stateSB.printResult();
        }
        stateSB.printGrandTotal();

        CalculationState stateMLK = new CalculationState();
        stateMLK.calculateTotal(stateMLKTotal);
        for (a = 0; a < eachStateData.length; a++) {
            stateMLK.catState(state[11],catCode.get(a),stateMLKTotal.get(a));
            stateMLK.printResult();
        }
        stateMLK.printGrandTotal();

        CalculationState stateKLT = new CalculationState();
        stateKLT.calculateTotal(stateKLTTotal);
        for (a = 0; a < eachStateData.length; a++) {
            stateKLT.catState(state[12],catCode.get(a),stateKLTTotal.get(a));
            stateKLT.printResult();
        }
        stateKLT.printGrandTotal();

        CalculationState eachState = new CalculationState();
          //get total players for each state by category from CalculationState class and count all the players
        int grandTotal = stateKL.getGrandTotal() + stateNS.getGrandTotal() + statePP.getGrandTotal() +
                            statePHG.getGrandTotal() + statePTR.getGrandTotal() + statePR.getGrandTotal() +
                            stateSLG.getGrandTotal() + stateJH.getGrandTotal() + stateKD.getGrandTotal() +
                            stateSRW.getGrandTotal() + stateSB.getGrandTotal() + stateMLK.getGrandTotal() +
                            stateKLT.getGrandTotal();
        eachState.printFinalResult(grandTotal);

        service.shutdown();
    }
}
