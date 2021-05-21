package pl.coderslab.homeworks.multiarrays;


public class Main01 {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 5, 1}, {4, 5, 6, 2}, {4, 5, 6, 2}};
        System.out.println("suma nieparzystych indeksów: " + oddSum(arr));

    }

    public static int oddSum(int[][] arr) {
        int sum = 0;
        for (int[] row : arr) {
            int counter = 0;
            for (int value : row) {
                if (counter % 2 > 0) {
                    sum += value;
                }
                counter++;
            }
        }
        return sum;
    }
}
