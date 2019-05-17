
import java.util.Vector;

/**
 * @author Liew Sin Hui
 * @version 1.0
 * @since 2019-04-19
 * CalculationPoints class uses to count the total points for each state.
 */

public class CalculationPoints {

    private String states, cat;
    private double pointer, grandTotalPointer, sumGrandTotalPointer;

    public CalculationPoints() {

    }

    /**
     * This constructs a points statistic with a specified grandTotalPointer and sumGrandTotalPointer
     * @param grandTotalPointer  an initial for total points for each state.
     * @param sumGrandTotalPointer an initial for count all the points.
     */
    public CalculationPoints(Double grandTotalPointer, Double sumGrandTotalPointer) {
        this.grandTotalPointer = grandTotalPointer;
        this.sumGrandTotalPointer = sumGrandTotalPointer;
    }

    /**
     * catState method will get information about the points statistic with a specified states, cat and pointer
     * @param states name of states
     * @param cat name of category
     * @param pointer total points for each state by category from current validTableLink
     */
    public void catState(String states, String cat, double pointer) {
        this.states=states;
        this.cat=cat;
        this.pointer=pointer;
    }

    /**
     * get category name
     * @return category name
     */
    public String getCat() {
        return cat;
    }

    /**
     * get state name
     * @return state name
     */
    public String getStates() {
        return states;
    }

    /**
     * get total points for each state by category
     * @return total points for each state by category.
     */
    public Double getPointer() {
        return pointer;
    }

    /**
     * get total points for each state.
     * @return total points for each state.
     */
    public Double getGrandTotalPointer() {
        return grandTotalPointer;
    }

    /**
     * calculateTotalPointer method is count the total points for each state
     * @param a the total points for each state by category from current validTableLink.
     */
    public void calculateTotalPointer(Vector<Double> a) {
        for (Double totalOfStatePointer: a){
            grandTotalPointer += totalOfStatePointer;
        }
    }

    /**
     * get total of all points
     * @return total of all points
     */
    public Double getSumGrandTotalPointer() {
        return sumGrandTotalPointer;
    }

    public void printResultPointer(){
        // Don't let the points get displayed if pointer is zero
        if(pointer>0) {
            System.out.printf("| %-12s | %-8s | %-6.1f|\n",getStates(), getCat(), getPointer());
        }
    }

    public void printGrandTotalPointer(){
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","","TOTAL",getGrandTotalPointer());
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
    }

    public void printFinalResultPointer(double sumGrandTotalPointer){
        this.sumGrandTotalPointer=sumGrandTotalPointer;
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","GRAND TOTAL","",getSumGrandTotalPointer());
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
    }
}
