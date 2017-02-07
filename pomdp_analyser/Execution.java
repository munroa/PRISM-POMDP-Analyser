package pomdp_analyser;

import java.util.ArrayList;

public class Execution {
    private int startState;
    private int endState;
    private ArrayList<Integer> variableInitialValue = new ArrayList<>();
    private ArrayList<Integer> variableEndValue = new ArrayList<>();
    private ArrayList<Double> initialBeliefProb = new ArrayList<>();
    private ArrayList<Double> finalBeliefProb = new ArrayList<>();
    private int nonDetNumber;
    private double probability;

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public int getNonDetNumber() {

        return nonDetNumber;
    }

    public void setNonDetNumber(int nonDetNumber) {
        this.nonDetNumber = nonDetNumber;
    }

    public ArrayList<Integer> getVariableEndValue() {
        return variableEndValue;
    }

    public void setVariableEndValue(ArrayList<Integer> variableEndValue) {
        this.variableEndValue = variableEndValue;
    }

    public ArrayList<Double> getFinalBeliefProb() {
        return finalBeliefProb;
    }

    public void setFinalBeliefProb(ArrayList<Double> finalBeliefProb) {
        this.finalBeliefProb = finalBeliefProb;
    }

    public ArrayList<Double> getInitialBeliefProb() {
        return initialBeliefProb;
    }

    public void setInitialBeliefProb(ArrayList<Double> initialBeliefProb) {
        this.initialBeliefProb = initialBeliefProb;
    }

    public ArrayList<Integer> getVariableInitialValue() {
        return variableInitialValue;
    }

    public void setVariableInitialValue(ArrayList<Integer> variableInitialValue) {
        this.variableInitialValue = variableInitialValue;
    }


    public int getEndState() {
        return endState;
    }

    public void setEndState(int endState) {
        this.endState = endState;
    }

    public int getStartState() {
        return startState;
    }

    public void setStartState(int startState) {
        this.startState = startState;
    }
}
