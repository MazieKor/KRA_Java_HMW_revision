package pl.coderslab.homeworks.strings;


public class Main05 {

    public static void main(String[] args) {
        String str = "Walać io4. I uwaga na PS34!";
        System.out.println("oryginał: " + str);
        System.out.println("wynik: " + encode(str));

    }

    public static String encode(String str) {
        String alphabet = "aąbcćdeęfghijklłmnoópqrstuvwxyzźżaąb";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isLetter(charArray[i]))
                continue;
            if (Character.isUpperCase(charArray[i])) {
                charArray[i] = Character.toLowerCase(charArray[i]);
                int alphabetIndex = alphabet.indexOf(charArray[i]);
                char changedChar = alphabet.charAt(alphabetIndex + 3);
                charArray[i] = Character.toUpperCase(changedChar);
            } else {
                int alphabetIndex = alphabet.indexOf(charArray[i]);
                char changedChar = alphabet.charAt(alphabetIndex + 3);
                charArray[i] = changedChar;
            }
        }
        return String.valueOf(charArray);
    }

}