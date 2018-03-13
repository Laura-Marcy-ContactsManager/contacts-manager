package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class FileHelper {

    public static List<String> slurp(String filename){
        List<String> result = null;
        try {
            result = readAllLines(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.printf("Error with SLURP %s: %s\n", filename, e.getMessage());
            System.exit(1);
        }
        return result;
    }

    public static List<String> prettySlurp(String filepath) {
        List<String> files = null;
        try {
            files = readAllLines(Paths.get(filepath));
        } catch (IOException e) {
            System.out.println("ERROR 404 - FILE NOT FOUND");
            System.exit(1);
        }
        for (int i = 0; i < files.size(); ++i) {
            String line = files.get(i);
            System.out.printf("%s: %s\n", i + 1, line);
        }
        return files;
    }


    public static void spit(String filename, List<String> contents, boolean append){
        Path path = Paths.get(filename);
        try {
            if(append) {
                Files.write(path, contents, StandardOpenOption.APPEND);
            }
            else {
                Files.write(path, contents);
            }
        } catch (IOException e) {
            System.err.println("Error with SPIT");
                e.printStackTrace();
        }
    }

    public static void spit(String filename, List<String> contents){
        spit(filename, contents, false);
    }



    public static void makeExciting(String filename){
        List<String> contents = slurp(filename);
        for (String content : contents){
            String capitalizeContent = (content.toUpperCase() + "!");
            System.out.println(capitalizeContent);
        }
        try {
            Files.write(Paths.get(filename), contents);
        } catch (IOException e) {
            System.err.println("Error with MakeExciting");
//            e.printStackTrace();
        }
    }


}
