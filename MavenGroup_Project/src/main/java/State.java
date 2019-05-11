import java.util.Vector;

public class State {
    String cat;
    String states;
    int total;
    int grandTotal;
    int sumGrandTotal;
    double pointer;
    double grandTotalPointer;
    double sumGrandTotalPointer;


    public void displayFull(String states, String cat, int total) {
        this.states=states;
        this.cat=cat;
        this.total=total;
    }

    public void printTitle(){
        System.out.printf("| %-12s | %-8s | %-6s|\n", "State", "Category", "Total");
        System.out.printf("| %-12s | %-8s | %-6s|\n", "------------", "--------", "-----");
    }

    public void displayFull(String states, String cat, double pointer) {
        this.states=states;
        this.cat=cat;
        this.pointer=pointer;
    }

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

    public void printGrandTotal(){
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotal);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
    }
    public void printGrandTotalPointer(){
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",grandTotalPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
    }

    public void printFinalResult(int sumGrandTotal){
        this.sumGrandTotal=sumGrandTotal;
        System.out.printf("| %-12s | %-8s | %-6d|\n","GRAND TOTAL","",sumGrandTotal);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
    }
    public void printFinalResultPointer(double sumGrandTotalPointer){
        this.sumGrandTotalPointer=sumGrandTotalPointer;
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","GRAND TOTAL","",sumGrandTotalPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
    }
}