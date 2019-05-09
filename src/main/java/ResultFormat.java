import java.util.Vector;

public interface ResultFormat {

    void displayFull(String states,String cat, int total);
    void displayFull(String states, String cat, double pointer);
    void calculateTotal(Vector<Integer>a);
    void calculateTotalPointer(Vector<Double>a);
    void printResult();
    void printResultPointer();
    void printFinalResult();
    void printFinalResultPointer();

}
