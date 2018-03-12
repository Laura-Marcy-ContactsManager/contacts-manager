package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;

public class FileHelper {
    private String directory;
    private String filename;

//    public String getDirectory() {
//        return directory;
//    }
//
//    public void setDirectory(String directory) {
//        this.directory = directory;
//    }
//
//    public String getFilename() {
//        return filename;
//    }
//
//    public void setFilename(String filename) {
//        this.filename = filename;
//    }

    public static void main(String[] args){
        List<String> test = new ArrayList<>();
        test.add("cat");
        test.add("dog");
        test.add("you do want another");
        test.add("shark");




        System.out.println(prettySlurp("src/grades/GradesApplication.java"));
//        spit("README.md", test, true);
//        makeExciting("README.md");
//        System.out.println(makeExciting("output.txt"));
//        spit("cat.txt",test, false);
    }




    public FileHelper(String directory, String filename) {
        this.directory = directory;
        this.filename = filename;
    }




    public static List<String> slurp(String filename){
        List<String> result = null;
        try {
            result = readAllLines(Paths.get(filename));
        } catch (IOException e) {
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
            if(Files.notExists(path)){
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            }
            if(append) {
                Files.write(path, contents, StandardOpenOption.APPEND);
            }
            else {
                Files.write(path, contents);
            }
        } catch (IOException e) {
            System.err.println("Error with SPLIT");
//                e.printStackTrace();
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
