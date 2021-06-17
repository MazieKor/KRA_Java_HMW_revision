package pl.coderslab.homeworks.files;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main04 {
//2 Solutions
    public static void main(String[] args) {
        rewrite2();
    }

//1st Solution:
    public static void rewrite() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wpisz ścieżkę do pliku");
        String fileDirectory = scan.nextLine();
        File file = new File(fileDirectory);
        if (!file.isFile()) {
            System.out.println("Podany plik nie istnieje. Podaj ścieżkę jeszcze raz");
        } else {
            try {
                createNewFile(fileDirectory, file);
            } catch (IOException e) {
                System.out.println("Problem ze stworzeniem lub zapisem pliku - spróbuj jeszcze raz");
            }
        }
    }

    private static void createNewFile(String fileDirectory, File file) throws IOException {
        String fileDirectory_2 = new String();
        if (fileDirectory.contains(".")) {
            fileDirectory_2 = fileDirectory.replace(".", "_2.");
        } else {
            fileDirectory_2 = fileDirectory + "_2";
        }
        File file_2 = new File(fileDirectory_2);
        if (!file_2.createNewFile()) {
            System.out.println("plik " + fileDirectory_2 + " już istnieje. Nowy plik nie został stworzony");
        } else {
            StringBuilder contentOfOriginalFile = new StringBuilder();
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (scan.hasNextLine())
                    contentOfOriginalFile.append(line).append("\n");
                else
                    contentOfOriginalFile.append(line);   //If there is no line more, I don't put new line (\n)
            }
            scan.close();
            FileWriter fileWriter = new FileWriter(fileDirectory_2);
            fileWriter.append(contentOfOriginalFile).append("\n");
            fileWriter.append(contentOfOriginalFile);          // According to the task save in the new file double content of the original file
            fileWriter.close();                                //I have to close fileWriter to successfully write in the new file
            System.out.println("Nowy plik został stworzony i zapisany");
        }
    }


//2nd Solution:
    public static void rewrite2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj ścieżkę do pliku, który chcesz zapisać");
        Path path = Paths.get(scan.nextLine());
        if (!Files.isRegularFile(path)) {
            System.out.println("Podana ścieżka lub plik nie istnieje. Podaj jeszcze raz");
            return;
        }
        String fileName = String.valueOf(path.getFileName());
        String fileName_2;
        if (!fileName.contains("."))
            fileName_2 = fileName + "_2";
        else {
            int indexOfLastDot = fileName.lastIndexOf(".");
            String firstFileName = fileName.substring(0, indexOfLastDot);
            String secondFileName = fileName.substring(indexOfLastDot);
            fileName_2 = firstFileName + "_2" + secondFileName;
        }
        Path path_2 = Path.of(path.subpath(0, path.getNameCount() - 1) + "/" + fileName_2);
        if (Files.isRegularFile(path_2)) {
            System.out.println("Plik, który ma zostać utworzony: " + path_2 + " już istnieje. Zmień nazwę pliku oryginalnego");
            return;
        }

        try {
            List<String> contentOfFile = Files.readAllLines(path);
            List<String> contentOfFile_2 = new ArrayList<>();
            contentOfFile_2.addAll(contentOfFile);
//            contentOfFile_2.addAll(contentOfFile);
            for (String line :contentOfFile) {
                contentOfFile_2.add(line);
            }
            Files.write(path_2, contentOfFile_2);
            System.out.println("Plik został utworzony");
        } catch (IOException e) {
            System.out.println("Problem z odczytaniem pliku. Podaj jeszcze raz ścieżkę");
            e.printStackTrace();
        }
    }

}