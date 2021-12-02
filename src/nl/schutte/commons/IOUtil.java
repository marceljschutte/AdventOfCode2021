package nl.schutte.commons;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOUtil {

    public static List<String> readFileAsListOfStrings(int dag) throws IOException {

        String filePath = "./resources/inputDag"+dag+".txt";
        try(Stream<String> stream = Files.lines(Paths.get(filePath))) {
            return stream.collect(Collectors.toList());
        }
    }


    /*
    INPUT Methods
     */
    public static List<BigDecimal> readFileAsListOfBigDecimals(int dag) throws IOException {
        String filePath = "./resources/inputDag"+dag+".txt";
        try(Stream<String> stream = Files.lines(Paths.get(filePath))) {
            return stream.map(BigDecimal::new).collect(Collectors.toList());
        }
    }

    /*
     * OUTPUT Methods
     */

    public static void printAnswer(int dag, int puzzle, int result){
        System.out.println("The answer to puzzle " + puzzle + " of day " + dag + " is: " + result );
    }
}
