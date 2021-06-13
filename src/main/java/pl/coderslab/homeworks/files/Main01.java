package pl.coderslab.homeworks.files;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main01 {
//2 Solutions

    public static void main(String[] args) {
        String fileDirectory = "src/main/java/pl/coderslab/homeworks/files/task2.txt";
        int numberOfSignsInFile = count(fileDirectory);
        if(numberOfSignsInFile >= 0){
            System.out.println("liczba znaków w pliku to: " + numberOfSignsInFile);
        } else if (numberOfSignsInFile < 0)
            System.out.println("plik jest pusty " + numberOfSignsInFile );


    }

    public static int count(String fileName){
        File file = new File(fileName);
        int numberOfSignsInFile = 0;
        int counter = 0;
        try(Scanner scan = new Scanner(file)){
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                numberOfSignsInFile += line.length();
                counter++;
            }
        } catch (FileNotFoundException e){
            System.out.println("Podany plik nie został znaleziony");
        }

        if(counter > 0)
            return numberOfSignsInFile;
        return -5;                          //NEW: mimo błędu wykonało się to co poniżej catcha - return jest tu konieczny
    }

//2 Solution:
//    public static int count2(String fileName){
//        Path path = Paths.get(fileName);
//        try {
//            List<String> linesInFile = Files.readAllLines(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

}