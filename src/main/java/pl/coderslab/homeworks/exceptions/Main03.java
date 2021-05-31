package pl.coderslab.homeworks.exceptions;


public class Main03 {

    public static void main(String[] args) {
//3 Solutions
        String str = null;  //" napis do testowania ";
//        System.out.print("Długość podanego napisu to: " + getLength2(str));

//3rd Solution:
        try {
            int stringLength = getLength3(str);
            System.out.println("Długość napisu to: " + stringLength);
        } catch (NullPointerException e) {
            System.out.println("Odnosisz się do nulla. Podaj napis jeszcze raz");
        }

    }

    public static int getLength(String str) {
        try {
            int stringLength = str.length();
            return stringLength;
        } catch (NullPointerException e) {
            System.out.println("Odnosisz się do nulla. Podaj napis jeszcze raz");
            return 0;
        }
    }

    //2nd Solution:
    public static String getLength2(String str) {
        try {
            return String.valueOf(str.length());
        } catch (NullPointerException e) {
            return "Odnosisz się do nulla. Podaj napis jeszcze raz";
        }
    }

    //3rd Solution:
    public static int getLength3(String str) {
        int stringLength = str.length();
        return stringLength;
    }
}