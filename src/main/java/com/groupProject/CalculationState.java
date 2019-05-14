package com.groupProject;

import java.util.Vector;

public class CalculationState {

    private String cat, states;
    private int total, grandTotal, sumGrandTotal;

    public CalculationState() {

    }

    public void catState(String states, String cat, int total) {
        this.states = states;
        this.cat = cat;
        this.total = total;
    }

    public String getCat() {
        return cat;
    }

    public String getStates() {
        return states;
    }

    public int getTotal() {
        return total;
    }

    public int calculateTotal(Vector<Integer> a){
        for (Integer totalOfState: a){
            grandTotal += totalOfState;
        }
        return sumGrandTotal;
    }

    public void printResult(){
        if(total>0) {
            System.out.printf("| %-12s | %-8s | %-6d|\n", getStates(), getCat(), getTotal());
        }
    }

    public void printGrandTotal(){
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
        System.out.printf("| %-12s | %-8s | %-6d|\n","","TOTAL",grandTotal);
        System.out.printf("| %-12s | %-8s | %-6s|\n","","--------","-----");
    }

    public void printFinalResult(int sumGrandTotal){
        this.sumGrandTotal = sumGrandTotal;
        //sumGrandTotal += grandTotal;
        System.out.printf("| %-12s | %-8s | %-6d|\n","GRAND TOTAL","",sumGrandTotal);
        System.out.printf("| %-12s | %-8s | %-6s|\n","------------","--------","-----");
    }
}
