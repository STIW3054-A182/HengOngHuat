import java.util.Vector;

public class StateNS implements  ResultFormat{
    String cat;
    String states;
    int total;
    int grandTotal;
    double pointer;
    double grandTotalPointer;

    @Override
    public void displayFull(String states, String cat, int total) {
        this.states=states;
        this.cat=cat;
        this.total=total;
    }

    public void displayFull(String states, String cat, double pointer) {
        this.states=states;
        this.cat=cat;
        this.pointer=pointer;
    }
    @Override
    public void calculateTotal(Vector<Integer> a){
        for (Integer totalOfState: a){
            grandTotal+=totalOfState;
        }
    }
    public void calculateTotalPointer(Vector<Double> a){
        for (Double totalOfStatePointer: a){
            grandTotalPointer+=totalOfStatePointer;
        }
    }
    public int getTotal(){

        return grandTotal;
    }

    public double getGrandTotalPointer(){

        return grandTotalPointer;
    }
    @Override
    public void printResult(){
        if(total>0) {
            System.out.printf("| %-12s | %-8s | %-6d|\n", states, cat, total);
        }
    }
    public void printResultPointer(){
        if(pointer>0) {
            System.out.printf("| %-12s | %-8s | %-6.1f|\n",states, cat, pointer);
        }
    }
    @Override
    public void printFinalResult(){
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotal);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
    }
    public void printFinalResultPointer(){
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
    }
}