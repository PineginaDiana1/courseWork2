package lesson1;

public class Stack {

    String[] storage = new String[10];
    int count = 0; //индекс текущего свободного элемента

    //добавить
public void push(String newElement) {
    storage[count] = newElement;
    count++;
}

//получить
public String pop() {
   return storage[--count];
}

}
