package pl.coderslab.homeworks.strings;


public class Main07 {

    public static void main(String[] args) {
        String str = "Cholernie nie lubię pieprzonych poniedziałków bez jebanej kawy lub choć herbaty";
        String[] words = {"cholera", "cholernie", "kurde", "pieprz", "pieprzonych", "jebanej", "debil"};
        String censoredString = censor(str, words);
        System.out.println("oryginał: " + str);
        System.out.println("ocenzurowany: " + censoredString);
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