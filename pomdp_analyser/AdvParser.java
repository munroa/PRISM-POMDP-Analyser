package pomdp_analyser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AdvParser {

    private static AdvParser parser = new AdvParser();

    private AdvParser() {
    }

    public static AdvParser getParser() {
        return parser;
    }

    public static Strategy parse(String file) {
        Strategy strategy = new Strategy();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Execution execution = new Execution();
                execution.setStartState(Integer.parseInt(line.split(":")[0])); // start state
                execution.setEndState(Integer.parseInt(line.split(":")[1].split("> ")[1])); // end state

                // variable initial vals
                for (String s : line.split("[\\(\\)]")[1].split(",")) {
                    execution.getVariableInitialValue().add(Integer.parseInt(s));
                }

                // variable end vals
                for (String s : line.split("[\\(\\)]")[3].split(",")) {
                    execution.getVariableEndValue().add(Integer.parseInt(s));
                }

                // belief probabilities for hidden values
                for (String s : line.split("[\\[\\]]")[1].split(",")) {
                    execution.getInitialBeliefProb().add(Double.parseDouble(s));
                }

                // final belief probabilities for hidden values
                for (String s : line.split("[\\[\\]]")[3].split(",")) {
                    execution.getFinalBeliefProb().add(Double.parseDouble(s));
                }

                execution.setNonDetNumber(Integer.parseInt(line.split("[\\&\\@]")[1].split("/")[0].trim())); // non det number
                execution.setProbability(Double.parseDouble(line.split("[\\&\\@]")[1].split("/")[1])); // probability

                strategy.getExecutions().add(execution);
            }
        } catch (FileNotFoundException e) {
            System.out.println("java main <filename>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strategy;
    }

}
