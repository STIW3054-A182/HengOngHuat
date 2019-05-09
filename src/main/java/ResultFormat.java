import java.util.Vector;

public interface ResultFormat {

    void displayFull(String states,String cat, int total);
    void calculateTotal(Vector<Integer>a);
    void printResult();
    void printFinalResult();

}
