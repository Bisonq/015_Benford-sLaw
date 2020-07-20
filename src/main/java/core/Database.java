package core;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Database {

    // 1 - 9
    private int[] arrayOfNumbers = new int[9];

    public Database() throws IOException{
        String filename="src/main/resources/cities_with_a_population_bigger_than_15000.txt";
        Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_16)
                .stream()
                .map(e -> {
                    //NAME	POPULATION	TIMEZONE
                    String[] elements = e.split("\\t");
                    return elements[1];
                }).forEach(e -> {
                    String firstDigit = e.substring(0, 1);
                    int first = Integer.parseInt(firstDigit);
                    if(first != 0) {
                        arrayOfNumbers[first - 1]++;
                    }
        });
    }

    public int[] getArrayOfNumbers() {
        return arrayOfNumbers;
    }
}
