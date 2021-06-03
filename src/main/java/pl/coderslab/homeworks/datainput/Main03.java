package pl.coderslab.homeworks.datainput;


import java.util.Arrays;
import java.util.Scanner;

public class Main03 {

    public static void main(String[] args) {
        String[] retirementArray = retirement();
        if (retirementArray.length > 0) {
            System.out.println("Osoby, które mogą przejść na emeryturę: " + Arrays.toString(retirementArray));
        } else {
            System.out.println("Nie ma osób, które mogą przejść na emeryturę");
        }
    }

    public static String[] retirement(){
        System.out.println("Podaj swoje: imię, nazwisko, rok urodzenia, płeć (K/M). Aby wyjść z programu wpisz \"quit\"");
        Scanner scan = new Scanner(System.in);
        String[][] dataArray = new String[0][];
        retirementLoop:
        while (true) {
            String dataInput = scan.nextLine().trim();
            if (dataInput.equals("quit"))
                break;
            String[] scanArray = dataInput.split("\\s");
            System.out.println("Test tablicy z wprowadzonego Stringa: " + Arrays.toString(scanArray));
            String dataInputAfterTrim = "";
            for (int i = 0; i < scanArray.length - 1; i++) {
                if (scanArray[i].isEmpty())
                    continue;
                dataInputAfterTrim += scanArray[i].trim() + " ";
            }
            dataInputAfterTrim += scanArray[scanArray.length-1].trim();  //last word without " "
            scanArray = dataInputAfterTrim.split(" ");
            System.out.println("Test tablicy ze Stringa po trimowaniu: " + Arrays.toString(scanArray));
            if (scanArray.length != 4) {
                System.out.println("wprowadz dokładnie 4 dane: imię, nazwisko, rok urodzenia, płeć (K/M)");
                continue;
            }
            while (!scanArray[3].toUpperCase().equals("K") && !scanArray[3].toUpperCase().equals("M")) {  //NEW
                System.out.println("Podaj poprawnie płeć (K/M). Aby wyjść wpisz quit");
                scanArray[3] = scan.nextLine().trim();
                if(scanArray[3].equalsIgnoreCase("quit")) {
                    System.out.println("Podaj swoje: imię, nazwisko, rok urodzenia, płeć (K/M). Aby wyjść z programu wpisz \"quit\"");
                    continue retirementLoop;
                }
            }
            boolean check = true;
            while(check) {
                try {
                    int test = Integer.parseInt(scanArray[2]);
                    if (test > 2100 || test < 1890) {
                        System.out.println("Podałeś zbyt wczesną lub zbyt późną datę urodzin. Podaj odpowiednią datę urodzin (YYYY). Aby wyjść wpisz quit");
                        scanArray[2] = scan.nextLine().trim();
                        if (scanArray[2].equalsIgnoreCase("quit")){
                            System.out.println("Podaj swoje: imię, nazwisko, rok urodzenia, płeć (K/M). Aby wyjść z programu wpisz \"quit\"");
                            continue retirementLoop;
                        }
                        continue;
                    }
                    check = false;
                } catch (NumberFormatException e) {
                    System.out.println("Podaj odpowiednią datę urodzin (YYYY). Aby wyjść wpisz quit");
                    scanArray[2] = scan.nextLine().trim();
                    if (scanArray[2].equalsIgnoreCase("quit")){
                        System.out.println("Podaj swoje: imię, nazwisko, rok urodzenia, płeć (K/M). Aby wyjść z programu wpisz \"quit\"");
                        continue retirementLoop;   //NEW
                    }
                }
            }
            dataArray = Arrays.copyOf(dataArray, dataArray.length + 1);
            dataArray[dataArray.length - 1] = scanArray;  // NEW moge wprowadzić tablice na index tabl. 2-wymiar
            System.out.println("TEST tablicy 2-wymiarowej: " + Arrays.deepToString(dataArray));
            System.out.println("Podaj swoje: imię, nazwisko, rok urodzenia, płeć (K/M). Aby wyjść z programu wpisz \"quit\"");
        }
        String [] retirementArray = new String[0];
        for (int i = 0; i < dataArray.length; i++) {
            if(Integer.parseInt(dataArray[i][2]) <= 1961 && dataArray[i][3].equalsIgnoreCase("K") || // NEW method
                    Integer.parseInt(dataArray[i][2]) <= 1956 && dataArray[i][3].equalsIgnoreCase("M") ) {
                retirementArray = Arrays.copyOf(retirementArray, retirementArray.length+1);
                retirementArray[retirementArray.length-1] = dataArray[i][0] + " " + dataArray[i][1]; // NEW - takie przypisanie
            }
        }
        return retirementArray;
    }
}
