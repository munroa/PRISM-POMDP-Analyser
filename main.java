import pomdp_analyser.AdvParser;
import pomdp_analyser.Strategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public class main {

    public static void main (String[] args) {
        if (args.length > 0) {
            for (String arg : args) {

                String file = new File("").getAbsolutePath() + "/" + args[0];
                Strategy s = AdvParser.parse(file);

                if (arg.equals("-g")) {
                    System.out.println(s.getGraph());

                    try (PrintWriter graph = new PrintWriter("graph.dot")) {
                        graph.println(s.getGraph());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        Runtime.getRuntime().exec("dot -Tpdf graph.dot -o graph.pdf");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }




                } else if (arg.equals("-t")) {
                    System.out.println(s.toString());
                } else if (arg.equals("-h") || arg.equals("-help")) {
                    System.out.println("java main.java <file.adv>");
                    System.out.println("-g returns graph");
                    System.out.println("-t returns text");
                } else if (arg.equals("-e")) {
                    System.out.println(s.toEnglish());
                }

            }
        } else {
            System.out.println("java main <filename>");
        }
    }
}
