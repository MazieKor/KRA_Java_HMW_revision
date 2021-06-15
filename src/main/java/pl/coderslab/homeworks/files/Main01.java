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
        String fileDirectory = "src/main/java/pl/coderslab/homeworks/files/task1.txt";
        int numberOfSignsInFile = count(fileDirectory);
        if (numberOfSignsInFile >= 0) {
            System.out.println("liczba znaków w pliku to: " + numberOfSignsInFile);
        } else if (numberOfSignsInFile == -1)
            System.out.println("plik jest pusty");

//2nd Solution:
        String fileDirectory2 = "src/main/java/pl/coderslab/homeworks/files/task1.txt";
        try {
            int numberOfSignsInFile2 = count2(fileDirectory2);
            System.out.println("Solution 2: liczba znaków w pliku: " + numberOfSignsInFile2);
        } catch (IOException e) {
            System.out.println("Solution 2: pliku nie znaleziono");
        }

    }

    public static int count(String fileName) {
        File file = new File(fileName);
        int numberOfSignsInFile = 0;
        int counter = 0;
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                numberOfSignsInFile += line.length();
                counter++;
            }
            if (counter > 0)
                return numberOfSignsInFile;
            return -1;
        } catch (FileNotFoundException e) {
            System.out.println("Podany plik nie został znaleziony");
            return -2;
        }
                                                                    //NEW: mimo błędu wykonało się to co poniżej catcha - return jest tu konieczny
    }

    //2nd Solution:
    public static int count2(String fileName) throws IOException {
        StringBuilder lineInFile = new StringBuilder();  //NEW inicjalizować mogę też nullem (było już?)
        Path path = Paths.get(fileName);
        List<String> linesInFile = Files.readAllLines(path);
        for (String row : linesInFile) {
            lineInFile.append(row);
        }
        return lineInFile.length();
    }
}