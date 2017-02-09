package pomdp_analyser;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Strategy {

    private ArrayList<Execution> executions = new ArrayList<>();


    public ArrayList<Execution> getExecutions() {
        return executions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Execution e : executions) {
            sb.append("Start: " + e.getStartState() + " End: " + e.getEndState() + "\n");
            sb.append("Variable Initial Values: ");

            for (Integer f : e.getVariableInitialValue()) {
                sb.append(f + ",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\nVariable End Values: ");

            for (Integer f : e.getVariableEndValue()) {
                sb.append(f + ",");
            }
            sb.deleteCharAt(sb.length() - 1);

            sb.append("\nInitial Belief Probabilities: ");

            for (Double f : e.getInitialBeliefProb()) {
                sb.append(f + ",");
            }
            sb.deleteCharAt(sb.length() - 1);

            sb.append("\nFinal Belief Probabilities: ");

            for (Double f : e.getFinalBeliefProb()) {
                sb.append(f + ",");
            }
            sb.deleteCharAt(sb.length() - 1);

            sb.append("\nProbability: " + e.getNonDetNumber() + "/" + e.getProbability());
            sb.append("\n\n");
        }
        return sb.toString();
    }

    public void setExecutions(ArrayList<Execution> executions) {
        this.executions = executions;
    }

    public Strategy() {
    }

    public String getGraph() {
        DecimalFormat df = new DecimalFormat("#.00");
        StringBuilder sb = new StringBuilder();
        StringBuilder labels = new StringBuilder();

        sb.append("digraph G {");
        for (Execution e : executions) {
            StringBuilder initialVars  = new StringBuilder();
            StringBuilder initialBeliefs  = new StringBuilder();

            // build inital vars string for label
            for (int a : e.getVariableInitialValue()) {
                initialVars.append(a + ",");
            }
            initialVars.deleteCharAt(initialVars.length() - 1);

            // build belifs string for label
            for (double a : e.getInitialBeliefProb()) {
                initialBeliefs.append(Math.round(a * 100.0) / 100.0 + ",");
            }
            initialBeliefs.deleteCharAt(initialBeliefs.length() - 1);

            sb.append(e.getStartState() + " -> " + e.getEndState() + "[label=\"" + e.getProbability() + "\"];\n");
            labels.append(e.getStartState() + " [label=\"" + e.getStartState() + "\\n(" + initialVars +")\n[" + initialBeliefs + "]\"];\n");
        }
        sb.append(labels);
        sb.append("}");
        return sb.toString();
    }


    public String toEnglish() {

        for (Execution e : executions) {
            System.out.println(e.getStartState());
        }



        return "yer da";
    }
}