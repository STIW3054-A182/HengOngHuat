import java.util.Vector;

public class StatePHG implements  ResultFormat{
    int total;
    int grandTotal;
    String cat;
    String states;


    @Override
    public void displayFull(String states, String cat, int total) {
        this.states=states;
        this.cat=cat;
        this.total=total;
    }
    @Override
    public void calculateTotal(Vector<Integer> a){
        for (Integer totalOfState: a){
            grandTotal+=totalOfState;
        }
    }
    public int getTotal(){
        return grandTotal;
    }
    @Override
    public void printResult(){
        if(total>0) {
            System.out.printf("| %-12s | %-8s | %-6d|\n", states, cat, total);
        }
    }
    @Override
    public void printFinalResult(){
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotal);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
    }
}
