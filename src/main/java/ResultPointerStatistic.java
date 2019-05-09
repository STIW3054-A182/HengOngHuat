import javafx.util.Pair;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ResultPointerStatistic extends MainClass implements Runnable {
    int coreCount = Runtime.getRuntime().availableProcessors();
    ExecutorService service = Executors.newFixedThreadPool(coreCount);
    static Vector<Pair<Double, String>> stateTotalPoint = new Vector<Pair<Double, String>>();
    static Vector<Double> stateKLTotalPointer = new Vector<>();
    static Vector<Double> stateNSTotalPointer = new Vector<>();
    static Vector<Double> statePPTotalPointer = new Vector<>();
    static Vector<Double> statePHGTotalPointer = new Vector<>();
    static Vector<Double> statePTRTotalPointer = new Vector<>();
    static Vector<Double> statePRTotalPointer = new Vector<>();
    static Vector<Double> stateSLGTotalPointer = new Vector<>();
    static Vector<Double> stateJHTotalPointer = new Vector<>();
    static Vector<Double> stateKDTotalPointer = new Vector<>();
    static Vector<Double> stateSRWTotalPointer = new Vector<>();
    static Vector<Double> stateSBTotalPointer = new Vector<>();
    static Vector<Double> stateMLKTotalPointer = new Vector<>();
    static Vector<Double> stateKLTTotalPointer = new Vector<>();
    static Vector<String> catCodePointer = new Vector<String>();

    public void run() {
        System.out.printf("| %-12s | %-8s | %-6s|\n", "State", "Category", "Total");
        System.out.printf("| %-12s | %-8s | %-6s|\n", "------------", "--------", "-----");
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
    }
}
       /* for (int getTotal=0;getTotal<stateTotalPoint.size();getTotal++) {
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

        double grandTotalKLPointer=0;
        for (Double totalOfStateKLPointer: stateKLTotalPointer){
            grandTotalKLPointer+=totalOfStateKLPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateKLTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[0], catCodePointer.get(getTotal), stateKLTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalKLPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");


       double grandTotalNSPointer=0;
        for (Double totalOfStateNSPointer: stateNSTotalPointer){
            grandTotalNSPointer+=totalOfStateNSPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateNSTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[1], catCodePointer.get(getTotal), stateNSTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalNSPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");


      double grandTotalPPPointer=0;
        for (Double totalOfStatePPPointer: statePPTotalPointer){
            grandTotalPPPointer+=totalOfStatePPPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (statePPTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[2], catCodePointer.get(getTotal), statePPTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalPPPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");


        double grandTotalPHGPointer=0;
        for (Double totalOfStatePHGPointer: statePHGTotalPointer){
            grandTotalPHGPointer+=totalOfStatePHGPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (statePHGTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[3], catCodePointer.get(getTotal), statePHGTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalPHGPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");

        double grandTotalPTRPointer=0;
        for (Double totalOfStatePTRPointer: statePTRTotalPointer){
            grandTotalPTRPointer+=totalOfStatePTRPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (statePTRTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[4], catCodePointer.get(getTotal), statePTRTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalPTRPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");

        double grandTotalPRPointer=0;
        for (Double totalOfStatePRPointer: statePRTotalPointer){
            grandTotalPRPointer+=totalOfStatePRPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (statePRTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[5], catCodePointer.get(getTotal), statePRTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalPRPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");

        double grandTotalSLGPointer=0;
        for (Double totalOfStateSLGPointer: stateSLGTotalPointer){
            grandTotalSLGPointer+=totalOfStateSLGPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateSLGTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[6], catCodePointer.get(getTotal), stateSLGTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalSLGPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");

        double grandTotalJHPointer=0;
        for (Double totalOfStateJHPointer: stateJHTotalPointer){
            grandTotalJHPointer+=totalOfStateJHPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateJHTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[7], catCodePointer.get(getTotal), stateJHTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalJHPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");

        double grandTotalKDPointer=0;
        for (Double totalOfStateKDPointer: stateKDTotalPointer){
            grandTotalKDPointer+=totalOfStateKDPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateKDTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[8], catCodePointer.get(getTotal), stateKDTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalKDPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");

        double grandTotalSRWPointer=0;
        for (Double totalOfStateSRWPointer: stateSRWTotalPointer){
            grandTotalSRWPointer+=totalOfStateSRWPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateSRWTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[9], catCodePointer.get(getTotal), stateSRWTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalSRWPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");

        double grandTotalSBPointer=0;
        for (Double totalOfStateSBPointer: stateSBTotalPointer){
            grandTotalSBPointer+=totalOfStateSBPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateSBTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[10], catCodePointer.get(getTotal), stateSBTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalSBPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");

        double grandTotalMLKPointer=0;

        for (Double totalOfStateMLKPointer: stateMLKTotalPointer){
            grandTotalMLKPointer+=totalOfStateMLKPointer;
        }

        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateMLKTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[11], catCodePointer.get(getTotal), stateMLKTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalMLKPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");

        double grandTotalKLTPointer=0;
        for (Double totalOfStateKLTPointer: stateKLTTotalPointer){
            grandTotalKLTPointer+=totalOfStateKLTPointer;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateKLTTotalPointer.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6.1f|\n", state[12], catCodePointer.get(getTotal), stateKLTTotalPointer.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalKLTPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

        double grandTotalPointer=0;
        grandTotalPointer+=grandTotalKLPointer+grandTotalNSPointer+grandTotalPPPointer+
                            grandTotalPHGPointer+grandTotalPTRPointer+grandTotalPRPointer+
                            grandTotalSLGPointer+grandTotalJHPointer+grandTotalKDPointer+
                            grandTotalSRWPointer+grandTotalSBPointer+grandTotalMLKPointer+grandTotalKLTPointer;
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","GRAND TOTAL","",grandTotalPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

*/
