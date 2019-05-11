import javafx.util.Pair;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ResultPointerStatistic extends MainClass implements Runnable {
    final String [] state={"KUALA LUMPUR", "N.SEMBILAN","PULAU PINANG","PAHANG","PUTRAJAY","PERAK","SELANGOR",
            "JOHOR","KEDAH","SARAWAK","SABAH","MELAKA","KELANTAN"};

    Vector<Pair<Double, String>> stateTotalPoint = new Vector<Pair<Double, String>>();
    Vector<Double> stateKLTotalPointer = new Vector<>();
    Vector<Double> stateNSTotalPointer = new Vector<>();
    Vector<Double> statePPTotalPointer = new Vector<>();
    Vector<Double> statePHGTotalPointer = new Vector<>();
    Vector<Double> statePTRTotalPointer = new Vector<>();
    Vector<Double> statePRTotalPointer = new Vector<>();
    Vector<Double> stateSLGTotalPointer = new Vector<>();
    Vector<Double> stateJHTotalPointer = new Vector<>();
    Vector<Double> stateKDTotalPointer = new Vector<>();
    Vector<Double> stateSRWTotalPointer = new Vector<>();
    Vector<Double> stateSBTotalPointer = new Vector<>();
    Vector<Double> stateMLKTotalPointer = new Vector<>();
    Vector<Double> stateKLTTotalPointer = new Vector<>();
    Vector<String> catCodePointer = new Vector<String>();

    public void run() {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        State displayResult = new State();
        displayResult.printTitle();

        for (int a = 0; a < existList.size(); a++) {
            GetPointerData link1 = new GetPointerData(existLinkList[a]);
            FutureTask<Vector> future3;
            future3 = (FutureTask<Vector>) service.submit(link1);

            try {
                stateTotalPoint = future3.get();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
                for (int getTotal=0;getTotal<stateTotalPoint.size();getTotal++) {
                    stateKLTotalPointer.add(stateTotalPoint.get((getTotal)).getKey());
                    stateNSTotalPointer.add(stateTotalPoint.get((getTotal+1)).getKey());
                    statePPTotalPointer.add(stateTotalPoint.get((getTotal+2)).getKey());
                    statePHGTotalPointer.add(stateTotalPoint.get((getTotal+3)).getKey());
                    statePTRTotalPointer.add(stateTotalPoint.get((getTotal+4)).getKey());
                    statePRTotalPointer.add(stateTotalPoint.get((getTotal+5)).getKey());
                    stateSLGTotalPointer.add(stateTotalPoint.get((getTotal+6)).getKey());
                    stateJHTotalPointer.add(stateTotalPoint.get((getTotal+7)).getKey());
                    stateKDTotalPointer.add(stateTotalPoint.get((getTotal+8)).getKey());
                    stateSRWTotalPointer.add(stateTotalPoint.get((getTotal+9)).getKey());
                    stateSBTotalPointer.add(stateTotalPoint.get((getTotal+10)).getKey());
                    stateMLKTotalPointer.add(stateTotalPoint.get((getTotal+11)).getKey());
                    stateKLTTotalPointer.add(stateTotalPoint.get((getTotal+12)).getKey());
                    catCodePointer.add(stateTotalPoint.get((getTotal)).getValue());
                    getTotal+=12;
                }

        State stateKL = new State();
        stateKL.calculateTotalPointer(stateKLTotalPointer);
        for (int a=0;a<10;a++) {
            stateKL.displayFull(state[0],catCodePointer.get(a),stateKLTotalPointer.get(a));
            stateKL.printResultPointer();
        }
        stateKL.printGrandTotalPointer();

        State stateNS = new State();
        stateNS.calculateTotalPointer(stateNSTotalPointer);
        for (int a=0;a<10;a++) {
            stateNS.displayFull(state[1],catCodePointer.get(a),stateNSTotalPointer.get(a));
            stateNS.printResultPointer();
        }
        stateNS.printGrandTotalPointer();

        State statePP = new State();
        statePP.calculateTotalPointer(statePPTotalPointer);
        for (int a=0;a<10;a++) {
            statePP.displayFull(state[2],catCodePointer.get(a),statePPTotalPointer.get(a));
            statePP.printResultPointer();
        }
        statePP.printGrandTotalPointer();


        State statePHG = new State();
        statePHG.calculateTotalPointer(statePHGTotalPointer);
        for (int a=0;a<10;a++) {
            statePHG.displayFull(state[3],catCodePointer.get(a),statePHGTotalPointer.get(a));
            statePHG.printResultPointer();
        }
        statePHG.printGrandTotalPointer();

        State statePTR= new State();
        statePTR.calculateTotalPointer(statePTRTotalPointer);
        for (int a=0;a<10;a++) {
            statePTR.displayFull(state[4],catCodePointer.get(a),statePTRTotalPointer.get(a));
            statePTR.printResultPointer();
        }
        statePTR.printGrandTotalPointer();

        State statePR= new State();
        statePR.calculateTotalPointer(statePRTotalPointer);
        for (int a=0;a<10;a++) {
            statePR.displayFull(state[5],catCodePointer.get(a),statePRTotalPointer.get(a));
            statePR.printResultPointer();
        }
        statePR.printGrandTotalPointer();

        State stateSLG= new State();
        stateSLG.calculateTotalPointer(stateSLGTotalPointer);
        for (int a=0;a<10;a++) {
            stateSLG.displayFull(state[6],catCodePointer.get(a),stateSLGTotalPointer.get(a));
            stateSLG.printResultPointer();
        }
        stateSLG.printGrandTotalPointer();


        State stateJH= new State();
        stateJH.calculateTotalPointer(stateJHTotalPointer);
        for (int a=0;a<10;a++) {
            stateJH.displayFull(state[7],catCodePointer.get(a),stateJHTotalPointer.get(a));
            stateJH.printResultPointer();
        }
        stateJH.printGrandTotalPointer();

        State stateKD= new State();
        stateKD.calculateTotalPointer(stateKDTotalPointer);
        for (int a=0;a<10;a++) {
            stateKD.displayFull(state[8],catCodePointer.get(a),stateKDTotalPointer.get(a));
            stateKD.printResultPointer();
        }
        stateKD.printGrandTotalPointer();

        State stateSRW= new State();
        stateSRW.calculateTotalPointer(stateSRWTotalPointer);
        for (int a=0;a<10;a++) {
            stateSRW.displayFull(state[9],catCodePointer.get(a),stateSRWTotalPointer.get(a));
            stateSRW.printResultPointer();
        }
        stateSRW.printGrandTotalPointer();

        State stateSB= new State();
        stateSB.calculateTotalPointer(stateSBTotalPointer);
        for (int a=0;a<10;a++) {
            stateSB.displayFull(state[10],catCodePointer.get(a),stateSBTotalPointer.get(a));
            stateSB.printResultPointer();
        }
        stateSB.printGrandTotalPointer();

        State stateMLK= new State();
        stateMLK.calculateTotalPointer(stateMLKTotalPointer);
        for (int a=0;a<10;a++) {
            stateMLK.displayFull(state[11],catCodePointer.get(a),stateMLKTotalPointer.get(a));
            stateMLK.printResultPointer();
        }
        stateMLK.printGrandTotalPointer();

        State stateKLT= new State();
        stateKLT.calculateTotalPointer(stateKLTTotalPointer);
        for (int a=0;a<10;a++) {
            stateKLT.displayFull(state[12],catCodePointer.get(a),stateKLTTotalPointer.get(a));
            stateKLT.printResultPointer();
        }
        stateKLT.printGrandTotalPointer();

        double grandTotalPointer=0;
        grandTotalPointer=stateKL.getGrandTotalPointer()+stateNS.getGrandTotalPointer()+statePP.getGrandTotalPointer()+statePHG.getGrandTotalPointer()+
                            statePTR.getGrandTotalPointer()+statePR.getGrandTotalPointer()+ stateSLG.getGrandTotalPointer()+stateJH.getGrandTotalPointer()+
                            stateKD.getGrandTotalPointer()+stateSRW.getGrandTotalPointer()+ stateSB.getGrandTotalPointer()+stateMLK.getGrandTotalPointer()+
                            stateKLT.getGrandTotalPointer();
        displayResult.printFinalResultPointer(grandTotalPointer);
    }
}
