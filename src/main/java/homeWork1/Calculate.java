package homeWork1;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
getResult();
    }
public static int getDivisible () {
    System.out.println("Введите делимое:");
    Scanner userDivisible = new Scanner(System.in);
    int divisible = 0;
    try {
        divisible = userDivisible.nextInt();
    } catch (Exception e) {
        throw new RuntimeException("Только целое число");
    }
    return divisible;
}

public static int getDivider () {
        System.out.println("Введите делитель:");
        Scanner userDivider = new Scanner(System.in);
    int divider = 0;
    try {
        divider = userDivider.nextInt();
    } catch (Exception e) {
        throw new RuntimeException("Только целое число");
    }
    return divider;
    }

    public static void getResult() {
        int divisible = getDivisible();
        int divider = getDivider();
        int result = 0;
        try {
            result = divisible / divider;
        } catch (ArithmeticException e) {
            throw new RuntimeException("На ноль делить нельзя :(");
        }
        System.out.println("Результат равен: " + result);
    }

}
