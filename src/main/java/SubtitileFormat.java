public class SubtitileFormat {
    int grandTotal;
    double grandTotalPointer;

    public void printTitle(){
        System.out.printf("| %-12s | %-8s | %-6s|\n", "State", "Category", "Total");
        System.out.printf("| %-12s | %-8s | %-6s|\n", "------------", "--------", "-----");
    }
    public void printGrandTotal(int grandTotal){
        System.out.printf("| %-12s | %-8s | %-6d|\n","GRAND TOTAL","",grandTotal);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
    }
    public void printGrandTotalPointer(double grandTotalPointer){
        System.out.printf("| %-12s | %-8s | %-6.1f|\n","GRAND TOTAL","",grandTotalPointer);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
    }
}
