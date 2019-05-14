package com.groupProject;

import java.util.Vector;

public class CalculationPoints {

    private String states, cat;
    private double pointer, grandTotalPointer, sumGrandTotalPointer;

    public CalculationPoints() {

    }

    public CalculationPoints(Double grandTotalPointer, Double sumGrandTotalPointer) {
        this.grandTotalPointer = grandTotalPointer;
        this.sumGrandTotalPointer = sumGrandTotalPointer;
    }

    public void catState(String states, String cat, double pointer) {
        this.states=states;
        this.cat=cat;
        this.pointer=pointer;
    }

    public String getCat() {
        return cat;
    }

    public String getStates() {
        return states;
    }

    public Double getPointer() {
        return pointer;
    }

    public Double getGrandTotalPointer() {
        return grandTotalPointer;
    }

    public Double calculateTotalPointer(Vector<Double> a) {
        for (Double totalOfStatePointer: a){
            grandTotalPointer += totalOfStatePointer;
        }
        return grandTotalPointer;
    }

    public Double getSumGrandTotalPointer() {
        return sumGrandTotalPointer;
    }

    public void printResultPointer(){
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
