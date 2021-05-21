package pl.coderslab.homeworks.strings;


public class Main03 {

    public static void main(String[] args) {
//2 solutions:
        String str = "sprawdzenie metody podnoszącej wybrany index     i wielokrotności podzielne 123456";
        int index = 3;
        System.out.println("oryginał: "+str);
        System.out.println("1.sposób: "+upperCase(str, index));
        System.out.println("2.sposób: "+upperCase2(str, index));

    }

//1st solution:
    public static String upperCase(String str, int index){
        char[] charArray = str.toCharArray();
        int i = index;
        while(i< charArray.length){
           charArray[i] = Character.toUpperCase(charArray[i]);
            i = i+index;
        }
        return String.valueOf(charArray);
    }

//2nd solution:
    public static String upperCase2(String str, int index){
        char[] charArray = str.toCharArray();
        for (int i = index; i < charArray.length ; i += index) {
            charArray[i] = Character.toUpperCase(charArray[i]);
        }
        return String.valueOf(charArray);
    }
}
