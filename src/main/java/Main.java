public static void main(String[] args) {
String dish = "Варенье";

printFormattedString(dish);
}
public static void printFormattedString(String originalString) {
    String formattedString = String.format("-[%s]-", originalString);
    printString(formattedString);
}

public static void printString(String s) {
    System.out.println(s);
    throw new RuntimeException("Просто так");

}