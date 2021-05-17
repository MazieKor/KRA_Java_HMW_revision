package pl.coderslab.homeworks.arrays;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main03 {

    public static void main(String[] args) {
        int[] arr = new int[10];
        randomArrGen(arr);
        System.out.println("Generated Array: "+ Arrays.toString(arr));
        int element = 8;
        System.out.println("Is in the Array the element present: " + contains(arr, element));
    }

    public static boolean contains(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return true;
            }
        }
        return false;
    }

    public static void randomArrGen(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Random r = new Random();
            int random = r.nextInt(20) + 1;
            arr[i] = random;
        }
    }

}
