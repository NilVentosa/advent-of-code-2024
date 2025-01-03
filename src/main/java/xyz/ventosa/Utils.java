package xyz.ventosa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static List<String> getInput(String inputFile) {
        inputFile = "src/main/resources/" + inputFile;
        List<String> input = new ArrayList<>();
        try {
            File myObj = new File(inputFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                input.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException ignore) {
            throw new RuntimeException("file not found");
        }
        return input;
    }

    public static List<List<String>> getListOfList(List<String> input) {
        List<List<String>> split = new ArrayList<>();
        for (String s: input) {
            split.add(Arrays.asList(s.split("")));
        }
        return split;
    }
}
