package pl.coderslab.homeworks.strings;


import java.util.Arrays;
import java.util.Locale;

public class Main07 {

    public static void main(String[] args) {

//2 variants, 2 solutions

        String str = "Cholernie nie lubię pieprzonych poniedziałków bez jebanej Kawy lub choć herbaty";
        String[] words = {"cholera", "cholernie", "kurde", "pieprz", "pieprzonych", "jebanej", "debil"};
        String censoredString = censor(str, words);
        System.out.println("oryginał: " + str);
        System.out.println("ocenzurowany: " + censoredString);
        System.out.println("słowa do ocenzurowania: " + Arrays.toString(words));
    }

    public static String censor(String str, String[] words) {
        String[] strArray = str.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (strArray[i].toLowerCase().equals(words[j])) {
                    strArray[i] = "****";
                    break;
                }
            }
        }

//   2nd solution:
//        Arrays.sort(words);
//        for (int i = 0; i < strArray.length; i++) {
//            if (Arrays.binarySearch(words, strArray[i].toLowerCase()) >= 0) {
//                strArray[i] = "****";
//            }
//        }

        StringBuilder censoredString = new StringBuilder();
        for (int i = 0; i < strArray.length - 1; i++) {
            censoredString.append(strArray[i] + " ");
        }
        censoredString.append(strArray[strArray.length - 1]);  //ostatni element tablicy bez dodatkowej spacji
        return censoredString.toString();

//2nd solution:
//        return String.join(" ", strArray);
    }
}