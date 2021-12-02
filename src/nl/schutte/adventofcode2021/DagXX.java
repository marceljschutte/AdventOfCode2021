package nl.schutte.adventofcode2021;

import nl.schutte.commons.IOUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class DagXX {

    private static List<BigDecimal> input;
    private static final int dagnummer = 123456789;

    public static void main(String[] args) throws IOException {
        input = IOUtil.readFileAsListOfBigDecimals(dagnummer);
        solvePuzzle1();
        solvePuzzle2();
    }

    private static void solvePuzzle1() {
        int result = 0;
        /*
                Uitwerking moet hier
         */
        IOUtil.printAnswer(dagnummer, 1, result);
    }

    private static void solvePuzzle2() {
        int result = 0;
        /*
                Uitwerking moet hier
         */
        IOUtil.printAnswer(dagnummer, 2, result);
    }
}
