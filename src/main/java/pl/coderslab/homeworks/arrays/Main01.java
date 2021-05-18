package pl.coderslab.homeworks.arrays;


import java.util.Arrays;

public class Main01 {

    public static void main(String[] args) {

// 2 solutions:

        int[] arr = {2, 4, 6, 2, 4, 9, 19, 22, 1, 0, -4, 43, 3, -4, 4, 22, 2, 7, 19};
//        int[] uniqueArray = returnUnique(arr);
        int[] uniqueArray = returnUnique2(arr);
        System.out.println("Tablica pierwotna po wyjściu z metody: " + Arrays.toString(arr));
        System.out.println("Tablica unikalnych wartości: " + Arrays.toString(uniqueArray));
    }

    public static int[] returnUnique(int[] arr) {
        int[] uniqueValues = new int[1];
        System.out.println("Przed sortowaniem: " + Arrays.toString(arr));
//        int[] arrClone = arr.clone();
        int[] arrClone = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arrClone);
        uniqueValues[0] = arrClone[0];
        System.out.println("Sortowanie we wnętrzu metody: " + Arrays.toString(arrClone));
        for (int i = 1; i < arrClone.length; i++) {
            if (arrClone[i] != arrClone[i - 1]) {
                uniqueValues = Arrays.copyOf(uniqueValues, uniqueValues.length + 1);
                uniqueValues[uniqueValues.length - 1] = arrClone[i];
            }
        }
        return uniqueValues;
    }

    // Wersja z zachowaniem kolejności:
    public static int[] returnUnique2(int[] arr) {
        int[] uniqueValues = new int[1];
        uniqueValues[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int checkUniqueness = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    checkUniqueness = -1;
                    break;
                }
            }
            if (checkUniqueness == 0) {
                uniqueValues = Arrays.copyOf(uniqueValues, uniqueValues.length + 1);
                uniqueValues[uniqueValues.length - 1] = arr[i];
            }
        }
        return uniqueValues;
    }
}