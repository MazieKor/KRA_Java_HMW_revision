package pl.coderslab.homeworks.exceptions;


public class Main01 {

    public static void main(String[] args) {
        String numberA = "34";
        String numberB = "0";

        average(numberA, numberB);

    }

    public static void average(String a, String b) {
        try {
//            double result = Integer.parseInt(a)/ Double.parseDouble(b);   //can be Infinity
            double result = Integer.parseInt(a) /Integer.parseInt(b);
            System.out.println("Wynik dzielenia to: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Nie można dzielić przez 0. Podaj prawidłową liczę");
        } catch (NumberFormatException e) {
            System.out.println("Musisz podać dwie liczby. Wprowadź dane jeszcze raz");
        } finally {
            System.out.println("Zakończenie metody");
        }

    }

}
