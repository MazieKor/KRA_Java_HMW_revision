package pl.coderslab.homeworks.multiarrays;


public class Main03 {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 5, 1}, {4, 5, 6, 2}, {4, 5, 6, 2}};
        int[] arrResult = lessMore(arr);
        System.out.println("liczba mniejszych wartości od średniej to: "+arrResult[0]+", a większych: "+arrResult[1]);

    }

    public static int[] lessMore(int[][] arr) {
        int sum = 0;
        int counter = 0;
        for (int[] row : arr) {
            for (int value : row) {
                sum += value;
                counter++;
            }
        }
        double avg = (double) sum / counter;

        int counterLess = 0;
        int counterMore = 0;
        for (int[] row : arr) {
            for (int value :row) {
                if(value>avg)
                    counterMore++;
                else if(value<avg)
                    counterLess++;
            }
        }
        System.out.println("Srednia to: " + avg);
        return new int[] {counterLess, counterMore};
    }

}