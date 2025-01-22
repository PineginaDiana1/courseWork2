package lesson2;

import java.io.IOException;

public class CarDataPool {
    public static String getCarTypeId(String id) {
        throw new RuntimeException();
    }

    public static String getCarDetails(String carType) {
        throw new IllegalArgumentException();
    }

    public static String getCarTypeById() {
        try {
            throw new IOException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
