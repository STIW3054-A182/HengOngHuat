import java.util.Vector;

/**
 * @author Liew Sin Hui
 * @version 1.0
 * @since 2019-04-19
 * CalculationState class uses to count the total players for each state.
 */

public class CalculationState {

    private String cat, states;
    private int total, grandTotal, sumGrandTotal;

    public CalculationState() {

    }

    /**
     * This constructs a player statistic with a specified grandTotal and sumGrandTotal
     * @param grandTotal an initial for total players for each state.
     * @param sumGrandTotal an initial for count all the players.
     */
    public CalculationState(int grandTotal, int sumGrandTotal) {
        this.grandTotal = grandTotal;
        this.sumGrandTotal = sumGrandTotal;
    }

    /**
     * catState method will get information about the player statistic with a specified states, cat and total
     * @param states name of states
     * @param cat name of category
     * @param total total players for each state by category from current validTableLink
     */
    public void catState(String states, String cat, int total) {
        this.states = states;
        this.cat = cat;
        this.total = total;
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
     * get total players for each state by category
     * @return total players for each state by category.
     */
    public int getTotal() {
        return total;
    }

    /**
     * get total players for each state.
     * @return total players for each state.
     */
    public int getGrandTotal() {
        return grandTotal;
    }

    /**
     * get total of all players
     * @return total of all players
     */
    public int getSumGrandTotal() {
        return sumGrandTotal;
    }

    /**
     * calculateTotal method is count the total players for each state
     * @param a the total players for each state by category from current validTableLink.
     */
    public void calculateTotal(Vector<Integer> a){
        for (Integer totalOfState: a){
            grandTotal += totalOfState;
        }
    }

    public void printResult(){
        // Don't let the total get displayed if total is zero
        if(total>0) {
            System.out.printf("| %-12s | %-8s | %-6d|\n", getStates(), getCat(), getTotal());
        }
    }

    public void printGrandTotal(){
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",getGrandTotal());
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
    }

    public void printFinalResult(int sumGrandTotal){
        this.sumGrandTotal = sumGrandTotal;
        System.out.printf("| %-12s | %-8s | %-6d|\n","GRAND TOTAL","",getSumGrandTotal());
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
    }
}