package homeWork1;

import java.util.Scanner;

public class GetCode {
    public static void main(String[] args) {

getPinCode();

    }

    public static void getPinCode() {
        String[] pinCodes = new String[]{"1111", "2222", "3333", "4444"};
        System.out.println("Введите номер карты:");
        Scanner userInput = new Scanner(System.in);
           int index = userInput.nextInt();
        try {
            System.out.println(pinCodes[index-1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Карта не найдена");
        }
    }
}
