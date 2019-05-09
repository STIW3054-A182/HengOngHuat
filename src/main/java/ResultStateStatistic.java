import javafx.util.Pair;

import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ResultStateStatistic extends MainClass implements Runnable {

    final String [] state={"KUALA LUMPUR", "N.SEMBILAN","PULAU PINANG","PAHANG","PUTRAJAY","PERAK","SELANGOR",
                                    "JOHOR","KEDAH","SARAWAK","SABAH","MELAKA","KELANTAN"};

    Vector<Pair<Integer,String>> stateTotal = new Vector<Pair<Integer,String>>();
    Vector<Integer>  stateKLTotal = new Vector<Integer> ();
    Vector<Integer>  stateNSTotal = new Vector<Integer> ();
    Vector<Integer>  statePPTotal = new Vector<Integer>();
    Vector<Integer> statePHGTotal = new Vector<Integer> ();
    Vector<Integer> statePTRTotal = new Vector<Integer> ();
    Vector<Integer>  statePRTotal = new Vector<Integer> ();
    Vector<Integer> stateSLGTotal = new Vector<Integer> ();
    Vector<Integer>  stateJHTotal = new Vector<Integer> ();
    Vector<Integer> stateKDTotal = new Vector<Integer>();
    Vector<Integer>  stateSRWTotal = new Vector<Integer> ();
    Vector<Integer> stateSBTotal = new Vector<Integer> ();
    Vector<Integer> stateMLKTotal = new Vector<Integer>();
    Vector<Integer>  stateKLTTotal = new Vector<Integer> ();
    Vector<String> catCode = new Vector<String> ();

    public void run() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);
        System.out.printf("| %-12s | %-8s | %-6s|\n", "State", "Category", "Total");
        System.out.printf("| %-12s | %-8s | %-6s|\n", "------------", "--------", "-----");

        for (int a = 0; a < existList.size(); a++) {
            GetStateData link1 = new GetStateData(existLinkList[a]);
            FutureTask<Vector> future2;
            future2 = (FutureTask<Vector>) service.submit(link1);
            try {
                stateTotal = future2.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
             for (int a=0;a<stateTotal.size();a++) {
                 stateKLTotal.add(stateTotal.get((a)).getKey());
                 stateNSTotal.add(stateTotal.get((a+1)).getKey());
                statePPTotal.add(stateTotal.get((a+2)).getKey());
                statePHGTotal.add(stateTotal.get((a+3)).getKey());
                statePTRTotal.add(stateTotal.get((a+4)).getKey());
                statePRTotal.add(stateTotal.get((a+5)).getKey());
                stateSLGTotal.add(stateTotal.get((a+6)).getKey());
                stateJHTotal.add(stateTotal.get((a+7)).getKey());
                stateKDTotal.add(stateTotal.get((a+8)).getKey());
                stateSRWTotal.add(stateTotal.get((a+9)).getKey());
                stateSBTotal.add(stateTotal.get((a+10)).getKey());
                stateMLKTotal.add(stateTotal.get((a+11)).getKey());
                stateKLTTotal.add(stateTotal.get((a+12)).getKey());
                catCode.add(stateTotal.get((a)).getValue());
                a+=12;
             }

                 StateKL stateKL = new StateKL();
                 stateKL.calculateTotal(stateKLTotal);
                   for (int a=0;a<10;a++) {
                       stateKL.displayFull(state[0],catCode.get(a),stateKLTotal.get(a));
                        stateKL.printResult();
                    }
                        stateKL.printFinalResult();

                  StateNS stateNS = new StateNS();
                   stateNS.calculateTotal(stateNSTotal);
                   for (int a=0;a<10;a++) {
                       stateNS.displayFull(state[1],catCode.get(a),stateNSTotal.get(a));
                        stateNS.printResult();
                    }
                        stateNS.printFinalResult();

                   StatePP statePP = new StatePP();
                    statePP.calculateTotal(statePPTotal);
                    for (int a=0;a<10;a++) {
                        statePP.displayFull(state[2],catCode.get(a),statePPTotal.get(a));
                        statePP.printResult();
                    }
                    statePP.printFinalResult();


                   StatePHG statePHG = new StatePHG();
                    statePHG.calculateTotal(statePHGTotal);
                    for (int a=0;a<10;a++) {
                        statePHG.displayFull(state[3],catCode.get(a),statePHGTotal.get(a));
                        statePHG.printResult();
                    }
                    statePHG.printFinalResult();

                     StatePTR statePTR= new StatePTR();
                    statePTR.calculateTotal(statePTRTotal);
                    for (int a=0;a<10;a++) {
                        statePTR.displayFull(state[4],catCode.get(a),statePTRTotal.get(a));
                        statePTR.printResult();
                    }
                    statePTR.printFinalResult();

                    StatePR statePR= new StatePR();
                    statePR.calculateTotal(statePRTotal);
                    for (int a=0;a<10;a++) {
                        statePR.displayFull(state[5],catCode.get(a),statePRTotal.get(a));
                        statePR.printResult();
                    }
                    statePR.printFinalResult();

                    StateSLG stateSLG= new StateSLG();
                    stateSLG.calculateTotal(stateSLGTotal);
                    for (int a=0;a<10;a++) {
                        stateSLG.displayFull(state[6],catCode.get(a),stateSLGTotal.get(a));
                        stateSLG.printResult();
                    }
                    stateSLG.printFinalResult();


                     StateJH stateJH= new StateJH();
                    stateJH.calculateTotal(stateJHTotal);
                    for (int a=0;a<10;a++) {
                        stateJH.displayFull(state[7],catCode.get(a),stateJHTotal.get(a));
                        stateJH.printResult();
                    }
                    stateJH.printFinalResult();

                    StateKD stateKD= new StateKD();
                    stateKD.calculateTotal(stateKDTotal);
                    for (int a=0;a<10;a++) {
                        stateKD.displayFull(state[8],catCode.get(a),stateKDTotal.get(a));
                        stateKD.printResult();
                    }
                    stateKD.printFinalResult();

                  StateSRW stateSRW= new StateSRW();
                    stateSRW.calculateTotal(stateSRWTotal);
                    for (int a=0;a<10;a++) {
                        stateSRW.displayFull(state[9],catCode.get(a),stateSRWTotal.get(a));
                        stateSRW.printResult();
                    }
                    stateSRW.printFinalResult();

                       StateSB stateSB= new StateSB();
                    stateSB.calculateTotal(stateSBTotal);
                    for (int a=0;a<10;a++) {
                        stateSB.displayFull(state[10],catCode.get(a),stateSBTotal.get(a));
                        stateSB.printResult();
                    }
                    stateSB.printFinalResult();

                    StateMLK stateMLK= new StateMLK();
                    stateMLK.calculateTotal(stateMLKTotal);
                    for (int a=0;a<10;a++) {
                        stateMLK.displayFull(state[11],catCode.get(a),stateMLKTotal.get(a));
                        stateMLK.printResult();
                    }
                    stateMLK.printFinalResult();

                    StateKLT stateKLT= new StateKLT();
                    stateKLT.calculateTotal(stateKLTTotal);
                    for (int a=0;a<10;a++) {
                        stateKLT.displayFull(state[12],catCode.get(a),stateKLTTotal.get(a));
                        stateKLT.printResult();
                    }
                    stateKLT.printFinalResult();

                    int grandTotal=0;
                    grandTotal=stateKL.getTotal()+stateNS.getTotal()+statePP.getTotal()+statePHG.getTotal()+statePTR.getTotal()+statePR.getTotal()+
                                stateSLG.getTotal()+stateJH.getTotal()+stateKD.getTotal()+stateSRW.getTotal()+stateSB.getTotal()+stateMLK.getTotal()+
                                stateKLT.getTotal();
                    System.out.printf("| %-12s | %-8s | %-6d|\n","GRAND TOTAL","",grandTotal);
                    System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

    }

}


