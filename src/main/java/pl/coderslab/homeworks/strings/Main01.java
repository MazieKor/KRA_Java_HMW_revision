package pl.coderslab.homeworks.strings;


public class Main01 {

    public static void main(String[] args) {

//2 solutions:
        String string = "za każdym razem zamienię małe a na Duże A";
        char forReplace = 'a';
        char replacement = 'A';
        System.out.println("wynik: " + replaceChar(string, forReplace, replacement));
        System.out.println("wynik 2: " + replaceChar2(string, forReplace, replacement));
        System.out.println("bez uzycia stworzonej metody: " + string.replaceAll(String.valueOf(forReplace), String.valueOf(replacement)));
        string.replaceAll(String.valueOf(forReplace), String.valueOf(replacement));
        System.out.println("oryginał: " + string);
    }

    public static String replaceChar(String str, char forReplace, char replacement) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == forReplace)
                charArray[i] = replacement;
        }
        return String.valueOf(charArray);
    }

//2nd solution:
    public static String replaceChar2(String str, char forReplace, char replacement) {
        return str.replaceAll(String.valueOf(forReplace), String.valueOf(replacement));

    }

}