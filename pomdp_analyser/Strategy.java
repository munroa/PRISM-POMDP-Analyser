package pomdp_analyser;

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
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {");
        for (Execution e : executions) {
            sb.append(e.getStartState() + " -> " + e.getEndState() + "\n");
        }
        sb.append("}");
        return sb.toString();
    }
}