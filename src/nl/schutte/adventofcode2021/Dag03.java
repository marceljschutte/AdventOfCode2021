package nl.schutte.adventofcode2021;

import nl.schutte.commons.IOUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dag03 {

    private static List<String> input;
    private static final int dagnummer = 3;

    private static final String BIT0 = "0";
    private static final String BIT1 = "1";

    public static void main(String[] args) throws IOException {
        input = IOUtil.readFileAsListOfStrings(dagnummer);
        solvePuzzle1();
        solvePuzzle2();
    }

    private static void solvePuzzle1() {
        int result = 0;
        String gammaRate = "";
        String epsilonRate = "";

        int[] totalOne = new int[input.get(0).length()];


        for(int i = 0; i < input.size(); i++) {
            String tempString = input.get(i);
            for(int j = 0; j < tempString.length(); j++) {
                if (tempString.substring(j,j+1).equals("1")){
                    totalOne[j] = totalOne[j] + 1;
                }
            }


        }
        for (int k = 0; k < totalOne.length; k++){
            if (totalOne[k] > (input.size()/2)) {
                gammaRate = gammaRate + "1";
                epsilonRate = epsilonRate + "0";
            } else {
                gammaRate = gammaRate + "0";
                epsilonRate = epsilonRate + "1";
            }
        }

        int gamma = Integer.parseInt(gammaRate, 2);
        int epsilon = Integer.parseInt(epsilonRate,2);

        result = gamma * epsilon;

        IOUtil.printAnswer(dagnummer, 1, result);
    }

    private static void solvePuzzle2() throws IOException {
        int result = 0;
        String oxygenRating = "";
        String co2ScrubberRating = "";

        for (int i = 0; i < input.get(0).length(); i++){
            if (input.size()> 1) {
                if (zoekMeestVoorkomendeBitOpIndex(input, i).equals(BIT0)){
                    input = verwijderMetingBitOpIndex(input, i, BIT1);
                } else {
                    input = verwijderMetingBitOpIndex(input, i, BIT0);
                }
            }
        }
        oxygenRating = input.get(0);

        input = IOUtil.readFileAsListOfStrings(dagnummer);

        for (int i = 0; i < input.get(0).length(); i++){
            if (input.size()> 1) {
                if (zoekMinstVoorkomendeBitOpIndex(input, i).equals(BIT0)){
                    input = verwijderMetingBitOpIndex(input, i, BIT1);
                } else {
                    input = verwijderMetingBitOpIndex(input, i, BIT0);
                }
            }
        }
         co2ScrubberRating = input.get(0);
        IOUtil.printAnswer(dagnummer, 2, Integer.parseInt(oxygenRating,2) * Integer.parseInt(co2ScrubberRating,2));
    }

    private static List<String> verwijderMetingBitOpIndex(List<String> input, int index, String waarde) {
        List<String> output = new ArrayList<>();
        for (String meting: input) {
            if(!meting.substring(index,index+1).equals(waarde)){
                output.add(meting);
            }
        }
        return output;
    }

    private static String zoekMeestVoorkomendeBitOpIndex(List<String> input, int index) {
        int aantal0 = 0;
        int aantal1 = 0;

        for (String s: input) {
            if(s.substring(index, index+1).equals("0")) {
                aantal0 += 1;
            } else {
                aantal1 += 1;
            }
        }
        return aantal1 >= aantal0 ? BIT1 : BIT0;
    }

    private static String zoekMinstVoorkomendeBitOpIndex(List<String> input, int index) {
        int aantal0 = 0;
        int aantal1 = 0;

        for (String s: input) {
            if(s.substring(index, index+1).equals("0")) {
                aantal0 += 1;
            } else {
                aantal1 += 1;
            }
        }
        return aantal0 <= aantal1 ? BIT0 : BIT1;
    }
}
