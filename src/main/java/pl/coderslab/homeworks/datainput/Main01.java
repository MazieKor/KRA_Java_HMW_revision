package pl.coderslab.homeworks.datainput;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
// 3 Solutions

        printTriangle2();

//3rd Solution:
//        int length = -1;
//        try {
//            length = printTriangle3();
//        } catch (InputMismatchException e) {
//            System.out.println("Podana wartość nie jest liczbą całkowitą. Włącz program jeszcze raz jeszcze raz");
//        }
//        if (length >= 0) {
//            String output = "";
//            for (int i = 0; i < length; i++) {
//                output += "x ";
//                System.out.println(output);
//            }
//        }

    }

    //1st Solution:
    public static void printTriangle() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj wartość - długość przyprostokątnych");
        while (!scan.hasNextInt()) {
            System.out.println("Podana wartość nie jest liczbą, spróbuj jeszcze raz");
            scan.next();
        }
        int input = scan.nextInt();
        String output = "x ";

        for (int i = 0; i < input; i++) {
            System.out.println(output);
            output += "x ";
        }
    }

    //2nd Solution:
    public static void printTriangle2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wartość - długość przyprostokątnych");
        try {
            int input = Integer.parseInt(scan.next());
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < input; i++) {
                output.append("x ");
                System.out.println(output);
            }

        } catch (NumberFormatException e) {
            System.out.println("Podana wartość nie jest liczbą całkowitą. Włącz program jeszcze raz jeszcze raz");
        }
    }

    //3rd Solution
    public static int printTriangle3() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wartość - długość przyprostokątnych");
        int input = scan.nextInt();
        return input;
    }

}
