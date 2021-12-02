package nl.schutte.adventofcode2021;

import nl.schutte.commons.IOUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Dag02 {

    private static List<String> input;
    private static final int dagnummer = 2;


    public static void main(String[] args) throws IOException {
        input = IOUtil.readFileAsListOfStrings(2);

        solvePuzzle1();
        solvePuzzle2();
    }

    private static void solvePuzzle1() {
        int result = 0;

        int startHorizontal = 0;
        int startDepth = 0;

        for(int i = 0; i < input.size(); i++ ){
            String[] instructie = input.get(i).split(" ");
            if (instructie[0].startsWith("forward")){
                startHorizontal+= Integer.parseInt(instructie[1]);
            } else if (instructie[0].startsWith("down")) {
                startDepth+= Integer.parseInt(instructie[1]);
            } else if (instructie[0].startsWith("up")) {
                startDepth -= Integer.parseInt(instructie[1]);
            }


        }

        result = startDepth * startHorizontal;

        IOUtil.printAnswer(dagnummer, 1, result);
    }

    private static void solvePuzzle2() {
        int result = 0;

        int startHorizontal = 0;
        int startAim = 0;

        int startDepth=0;

        for(int i = 0; i < input.size(); i++ ){
            String[] instructie = input.get(i).split(" ");
            if (instructie[0].startsWith("forward")){
                startHorizontal+= Integer.parseInt(instructie[1]);
                startDepth = startDepth + (Integer.parseInt(instructie[1]) * startAim);
            } else if (instructie[0].startsWith("down")) {
                startAim+= Integer.parseInt(instructie[1]);
            } else if (instructie[0].startsWith("up")) {
                startAim -= Integer.parseInt(instructie[1]);
            }
        }
        result = startDepth * startHorizontal;
        IOUtil.printAnswer(dagnummer, 2, result);
    }
}
