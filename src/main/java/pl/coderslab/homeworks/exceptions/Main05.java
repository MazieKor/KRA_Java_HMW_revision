package pl.coderslab.homeworks.exceptions;


import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main05 {

    public static void main(String[] args) {
        int[] elements = {4, 5, 6, 7, 9, 1, 5, 3, 19};
        int value = 8;
        int result;
        try {
            result = indexOf(elements, value);
            System.out.println("liczba " + value + " ma index: " + result);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Test tablicy i błędu: " + Arrays.toString(elements));
    }

    public static int indexOf(int[] elements, int value) {
        int[] cloneElements = elements.clone();
        String intString = "";
        for (int i = 0; i < cloneElements.length; i++) {
            intString += cloneElements[i];
        }
        System.out.println("TEST metody: " + intString);
        int result = intString.indexOf(String.valueOf(value));
        if (result < 0) {
            throw new NoSuchElementException("Podany element nie występuje w tablicy");
        }
        return result;
    }

    //Test:
    public static int indexOfAfterSort(int[] elements, int value) {
        int[] cloneElements = elements.clone();
        Arrays.sort(cloneElements);
        return Arrays.binarySearch(cloneElements, value);
    }


}