package pl.coderslab.homeworks.methods;


public class Main01 {

    public static void main(String[] args) {
        double dogAge = -9;
        double humanAge = dogAge(dogAge);
        if (humanAge >= 0) {
            System.out.print("wiek człowieka to: " + humanAge);
        } else {
            System.out.print("wprowadź liczbę większą od 0");
        }
//        System.out.print("wiek człowieka to: " + humanAge);
    }

    public static double dogAge(double dogAge) {
        double humanAge;
        if (dogAge < 0) {
            humanAge = -1;
        } else if (dogAge <= 2) {
            humanAge = dogAge * 10.5;
        } else
            humanAge = 2 * 10.5 + (dogAge - 2) * 4;
        return humanAge;
    }
}
