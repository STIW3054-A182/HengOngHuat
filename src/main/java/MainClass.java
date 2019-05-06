import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

import java.lang.String;

public class MainClass {

    public static Vector<String> existList = new Vector<String>();
    public static String [] existLinkList;
    public static Vector<Integer> total = new Vector<Integer>();
    public static Vector<Integer> stateTotal = new Vector<Integer>();
    public static Vector<Integer> stateKLTotal = new Vector<Integer>();
    public static Vector<Integer> stateNSTotal = new Vector<Integer>();
    public static Vector<Integer> statePPTotal = new Vector<Integer>();
    public static Vector<Integer> statePHGTotal = new Vector<Integer>();
    public static Vector<Integer> statePTRTotal = new Vector<Integer>();
    public static Vector<Integer> statePRTotal = new Vector<Integer>();
    public static Vector<Integer> stateSLGTotal = new Vector<Integer>();
    public static Vector<Integer> stateJHTotal = new Vector<Integer>();
    public static Vector<Integer> stateKDTotal = new Vector<Integer>();
    public static Vector<Integer> stateSRWTotal = new Vector<Integer>();
    public static Vector<Integer> stateSBTotal = new Vector<Integer>();
    public static Vector<Integer> stateMLKTotal = new Vector<Integer>();
    public static Vector<Integer> stateKLTTotal = new Vector<Integer>();



    public static void main (String[] args) throws IOException {

        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        Path path = Paths.get("C:\\Users\\Asus\\Documents\\sem 4\\REAL TIME\\STIW3054-Project\\URL.txt");
        List<String> line = null;
        line = Files.readAllLines(path);
        System.out.println("**************************** DISPLAY VALID LINKS ****************************");

        for (int a=0; a<line.size();a++) {

            CheckURLs link1 = new CheckURLs(line.get(a));
            Future<String> future = service.submit(link1);
            try {
                if (future.get() != null) {
                    String existLink = future.get();
                    existList.add(existLink);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        existLinkList = new String[existList.size()];
        existList.copyInto(existLinkList);
        for (String link2: existLinkList){
            System.out.println("Valid Link: "+link2);
        }
     // ==============================================================================================================================


        System.out.printf("| %-12s | %-8s | %-6s|\n","State","Category","Total");
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
       for (int a=0;a<existList.size();a++){

            Thread1 link1 = new Thread1(existLinkList[a]);
            FutureTask<Vector> future2;
           future2 = (FutureTask<Vector>) service.submit(link1);

           try {
            if (future2.get()!=null) {
                stateTotal = future2.get();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


        for (int getkl=0;getkl<120;getkl++) {
            stateKLTotal.add(stateTotal.get(getkl));
            stateNSTotal.add(stateTotal.get(getkl+1));
            statePPTotal.add(stateTotal.get(getkl+2));
            statePHGTotal.add(stateTotal.get(getkl+3));
            statePTRTotal.add(stateTotal.get(getkl+4));
            statePRTotal.add(stateTotal.get(getkl+5));
            stateSLGTotal.add(stateTotal.get(getkl+6));
            stateJHTotal.add(stateTotal.get(getkl+7));
            stateKDTotal.add(stateTotal.get(getkl+8));
            stateSRWTotal.add(stateTotal.get(getkl+9));
            stateSBTotal.add(stateTotal.get(getkl+10));
            stateMLKTotal.add(stateTotal.get(getkl+11));
            stateKLTTotal.add(stateTotal.get(getkl+12));
            getkl+=12;
        }

        int grandTotalKL=0;
        for (Integer totalOfStateNS: stateKLTotal){
            grandTotalKL+=totalOfStateNS;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalKL);

        int grandTotalNS=0;
        for (Integer totalOfStateNS: stateNSTotal){
            grandTotalNS+=totalOfStateNS;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalNS);
        int grandTotalPP=0;
        for (Integer totalOfStatePP: statePPTotal){
            grandTotalPP+=totalOfStatePP;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalPP);

        int grandTotalPHG=0;
        for (Integer totalOfStatePHG: statePHGTotal){
            grandTotalPHG+=totalOfStatePHG;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalPHG);

        int grandTotalPTR=0;
        for (Integer totalOfStatePTR: statePTRTotal){
            grandTotalPTR+=totalOfStatePTR;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalPTR);

        int grandTotalPR=0;
        for (Integer totalOfStatePR: statePRTotal){
            grandTotalPR+=totalOfStatePR;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalPR);

        int grandTotalSLG=0;
        for (Integer totalOfStateSLG: stateSLGTotal){
            grandTotalSLG+=totalOfStateSLG;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalSLG);

        int grandTotalJH=0;
        for (Integer totalOfStateJH: stateJHTotal){
            grandTotalJH+=totalOfStateJH;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalJH);

        int grandTotalKD=0;
        for (Integer totalOfStateKD: stateKDTotal){
            grandTotalKD+=totalOfStateKD;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalKD);

        int grandTotalSRW=0;
        for (Integer totalOfStateSRW: stateSRWTotal){
            grandTotalSRW+=totalOfStateSRW;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalSRW);

        int grandTotalSB=0;
        for (Integer totalOfStateSB: stateSBTotal){
            grandTotalSB+=totalOfStateSB;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalSB);

        int grandTotalMLK=0;
        for (Integer totalOfStateMLK: stateMLKTotal){
            grandTotalMLK+=totalOfStateMLK;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalMLK);

        int grandTotalKLT=0;
        for (Integer totalOfStateKLT: stateKLTTotal){
            grandTotalKLT+=totalOfStateKLT;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalKLT);


        int grandTotal=0;
        for (Integer totalOfState: stateTotal){
            grandTotal+=totalOfState;
        }
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotal);


        //===============================================================================================================================================

        try {
        service.shutdown();
            if (!service.awaitTermination(60, TimeUnit.SECONDS)) { //wait for existing tasks to terminate
                service.shutdownNow(); //cancel currently executing task
                if (!service.awaitTermination(60, TimeUnit.SECONDS)) { //wait for tasks to respond to being cancelled
                    System.err.println("Service didn't terminate!");
                }
            }
        } catch (InterruptedException e) {
            service.shutdownNow(); //re-cancel if current thread also interrupted
            Thread.currentThread().interrupt(); //preserve interrupt status
        }

    }



}