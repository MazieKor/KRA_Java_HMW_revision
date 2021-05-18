package pl.coderslab.homeworks.arrays;


import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main03 {

    public static void main(String[] args) {
// 2 solutions:

        int[] arr = new int[10];
        randomArrGen(arr);
        System.out.println("Generated Array: " + Arrays.toString(arr));
        String genArrayInString = Arrays.toString(arr);
        System.out.println("Generated Array in String (check): " + genArrayInString);
        int element = 1;
        System.out.println("Is in the Array the element present: " + contains(arr, element));

        int check = Arrays.binarySearch(arr, element);
        if (check >= 0) {
            System.out.println("2nd solution: Is in the Array the element present: true");
        } else {
            System.out.println("2nd solution: Is in the Array the element present: false");
        }

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