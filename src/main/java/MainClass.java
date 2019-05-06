import javafx.util.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

import java.lang.String;

public class MainClass {

   static final String [] state={"KUALA LUMPUR", "N.SEMBILAN","PULAU PINANG","PAHANG","PUTRAJAY","PERAK","SELANGOR","JOHOR","KEDAH","SARAWAK","SABAH","MELAKA","KELANTAN"};
   static Vector<String> existList = new Vector<String>();
   static String [] existLinkList;
   static Vector<Integer> total = new Vector<Integer>();
   static Vector<Pair<Integer,String>> stateTotal = new Vector<Pair<Integer,String>>();
   static Vector<Integer>  stateKLTotal = new Vector<Integer>();
   static Vector<Integer>  stateNSTotal = new Vector<Integer> ();
   static Vector<Integer>  statePPTotal = new Vector<Integer>();
   static Vector<Integer> statePHGTotal = new Vector<Integer> ();
   static Vector<Integer> statePTRTotal = new Vector<Integer> ();
   static Vector<Integer>  statePRTotal = new Vector<Integer> ();
   static Vector<Integer> stateSLGTotal = new Vector<Integer> ();
   static Vector<Integer>  stateJHTotal = new Vector<Integer> ();
   static Vector<Integer> stateKDTotal = new Vector<Integer>();
   static Vector<Integer>  stateSRWTotal = new Vector<Integer> ();
   static Vector<Integer> stateSBTotal = new Vector<Integer> ();
   static Vector<Integer> stateMLKTotal = new Vector<Integer>();
   static Vector<Integer>  stateKLTTotal = new Vector<Integer> ();
   static Vector<Integer>  grandTotalState = new Vector<Integer> ();
   static Vector<String> catCode = new Vector<String> ();




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
                stateTotal = future2.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


         for (int getTotal=0;getTotal<120;getTotal++) {
             stateKLTotal.add(stateTotal.get((getTotal)).getKey());
            stateNSTotal.add(stateTotal.get((getTotal+1)).getKey());
            statePPTotal.add(stateTotal.get((getTotal+2)).getKey());
            statePHGTotal.add(stateTotal.get((getTotal+3)).getKey());
            statePTRTotal.add(stateTotal.get((getTotal+4)).getKey());
            statePRTotal.add(stateTotal.get((getTotal+5)).getKey());
            stateSLGTotal.add(stateTotal.get((getTotal+6)).getKey());
            stateJHTotal.add(stateTotal.get((getTotal+7)).getKey());
            stateKDTotal.add(stateTotal.get((getTotal+8)).getKey());
            stateSRWTotal.add(stateTotal.get((getTotal+9)).getKey());
            stateSBTotal.add(stateTotal.get((getTotal+10)).getKey());
            stateMLKTotal.add(stateTotal.get((getTotal+11)).getKey());
            stateKLTTotal.add(stateTotal.get((getTotal+12)).getKey());
             catCode.add(stateTotal.get((getTotal)).getValue());


            getTotal+=12;
        }


        int grandTotalKL=0;
        for (Integer totalOfStateKL: stateKLTotal){
            grandTotalKL+=totalOfStateKL;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateKLTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[0], catCode.get(getTotal), stateKLTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalKL);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");


       int grandTotalNS=0;
        for (Integer totalOfStateNS: stateNSTotal){
            grandTotalNS+=totalOfStateNS;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateNSTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[1], catCode.get(getTotal), stateNSTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalNS);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");


        int grandTotalPP=0;
        for (Integer totalOfStatePP: statePPTotal){
            grandTotalPP+=totalOfStatePP;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (statePPTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[2], catCode.get(getTotal), statePPTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalPP);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");


        int grandTotalPHG=0;
        for (Integer totalOfStatePHG: statePHGTotal){
            grandTotalPHG+=totalOfStatePHG;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (statePHGTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[3], catCode.get(getTotal), statePHGTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalPHG);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

        int grandTotalPTR=0;
        for (Integer totalOfStatePTR: statePTRTotal){
            grandTotalPTR+=totalOfStatePTR;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (statePTRTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[4], catCode.get(getTotal), statePTRTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalPTR);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

        int grandTotalPR=0;
        for (Integer totalOfStatePR: statePRTotal){
            grandTotalPR+=totalOfStatePR;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (statePRTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[5], catCode.get(getTotal), statePRTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalPR);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

        int grandTotalSLG=0;
        for (Integer totalOfStateSLG: stateSLGTotal){
            grandTotalSLG+=totalOfStateSLG;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateSLGTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[6], catCode.get(getTotal), stateSLGTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalSLG);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

        int grandTotalJH=0;
        for (Integer totalOfStateJH: stateJHTotal){
            grandTotalJH+=totalOfStateJH;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateJHTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[7], catCode.get(getTotal), stateJHTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalJH);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

        int grandTotalKD=0;
        for (Integer totalOfStateKD: stateKDTotal){
            grandTotalKD+=totalOfStateKD;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateKDTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[8], catCode.get(getTotal), stateKDTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalKD);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

        int grandTotalSRW=0;
        for (Integer totalOfStateSRW: stateSRWTotal){
            grandTotalSRW+=totalOfStateSRW;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateSRWTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[9], catCode.get(getTotal), stateSRWTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalSRW);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

        int grandTotalSB=0;
        for (Integer totalOfStateSB: stateSBTotal){
            grandTotalSB+=totalOfStateSB;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateSBTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[10], catCode.get(getTotal), stateSBTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalSB);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

        int grandTotalMLK=0;
        for (Integer totalOfStateMLK: stateMLKTotal){
            grandTotalMLK+=totalOfStateMLK;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateMLKTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[11], catCode.get(getTotal), stateMLKTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalMLK);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

        int grandTotalKLT=0;
        for (Integer totalOfStateKLT: stateKLTTotal){
            grandTotalKLT+=totalOfStateKLT;
        }
        for (int getTotal=0;getTotal<10;getTotal++) {
            if (stateKLTTotal.get(getTotal)>0) {
                System.out.printf("| %-12s | %-8s | %-6d|\n", state[12], catCode.get(getTotal), stateKLTTotal.get(getTotal));
            }
        }
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotalKLT);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");

        int grandTotal=0;
        grandTotal+=grandTotalKL+grandTotalNS+grandTotalPP+grandTotalPHG+grandTotalPTR+grandTotalPR+grandTotalSLG+grandTotalJH+grandTotalKD+grandTotalSRW+grandTotalSB+
        grandTotalMLK+grandTotalKLT;
        System.out.printf("| %-12s | %-8s | %-6d|\n","GRAND TOTAL","",grandTotal);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");


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