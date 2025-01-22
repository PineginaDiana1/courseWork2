package lesson1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyReader {
    public static void main(String[] args) {
        String fileName = readUserFileName();
        readAndPrint(fileName);

    }
    public static String readUserFileName() {
        System.out.println("Имя файла:");
        Scanner userInputScanner = new Scanner(System.in);
        String fileName = userInputScanner.nextLine();
        if (fileName.isEmpty()) {
            throw new RuntimeException("Имя файла не может быть пустым");
        }
        return fileName;

    }


    public static void readAndPrint (String fileName) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (fileScanner.hasNext()) {
            System.out.println(fileScanner.nextLine());
        }
    }

}
