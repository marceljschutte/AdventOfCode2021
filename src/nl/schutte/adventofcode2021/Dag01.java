package nl.schutte.adventofcode2021;

import nl.schutte.commons.IOUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dag01 {

    private static List<BigDecimal> input;
    private static final int dagnummer = 1;

    public static void main(String[] args) throws IOException {
        input = IOUtil.readFileAsListOfBigDecimals(1);

        solvePuzzle1();
        solvePuzzle2();
    }

    private static void solvePuzzle1() throws IOException {

        int result = 0;
        for(int i = 1; i < input.size(); i++ ){
            if (input.get(i).intValue() - input.get(i-1).intValue() > 0){
                result += 1;
            }
        }
        IOUtil.printAnswer(dagnummer, 1, result);
    }

    private static void solvePuzzle2(){
        List<Integer> tussenresultaat = new ArrayList<Integer>();
        for(int i = 0; i < (input.size()-2); i++){
            tussenresultaat.add(input.get(i).intValue() + input.get(i+1).intValue() + input.get(i+2).intValue());
        }

        int result = 0;
        for(int i = 1; i < tussenresultaat.size(); i++ ){
            if (tussenresultaat.get(i) - tussenresultaat.get(i-1) > 0){
                result += 1;
            }
        }
        IOUtil.printAnswer(dagnummer, 1, result);
    }
}
