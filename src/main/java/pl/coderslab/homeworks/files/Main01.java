package pl.coderslab.homeworks.files;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {


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
        return -1;
    }

//2 Solution:
    public static int count(String fileName){
        Path path = Paths.get(fileName);

    }

}