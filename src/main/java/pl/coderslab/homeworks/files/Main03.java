package pl.coderslab.homeworks.files;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main03 {

    public static void main(String[] args) {
        if (checkFileExist()){
            System.out.println("co więcej - jest plikiem");
        } else
            System.out.println("NIE JEST plikiem");

        if (checkFileExist2()){
            System.out.println("Podana ścieżka jest plikiem");
        } else
            System.out.println("Podana ścieżka NIE JEST plikiem");

    }

    public static boolean checkFileExist(){
        Scanner scan = new Scanner(System.in);
        System.out.println("podaj nazwę pliku wraz ze ścieżką");
        String directoryName = scan.nextLine();
        File file = new File(directoryName);

        if (file.exists()) {
            System.out.print("Podana ścieżka istnieje, ");
        } else {
            System.out.print("Podana ścieżka nie istnieje, ");
        }

        return file.isFile();
    }

//2nd Solution:
    public static boolean checkFileExist2(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n" + "Solution 2: Podaj nazwę pliku wraz ze ścieżką");
        String directory = scan.nextLine().trim();
        Path path = Paths.get(directory);
        return Files.isRegularFile(path);
    }
}
