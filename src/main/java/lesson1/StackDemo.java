package lesson1;

public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push("клубничный");
        stack.push("вишневый");
        stack.push("земляничный");
        stack.push("яблочный");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
