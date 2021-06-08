package pl.coderslab.homeworks.files;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {


    }

    public static int count(String fileName){
        File file = new File(fileName);
        try(Scanner scan = new Scanner(file)){

        } catch (FileNotFoundException e){
            System.out.println("Podany plik nie został znaleziony");
        }

    }

}
