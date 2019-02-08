package linkedlist.exercises;

public class Test {
    public static void main(String[] args)
    {
        CircularDoublyLinkedList<String> list = new CircularDoublyLinkedList<>();
        list.addFirst("Hello");
        System.out.println(list.last()); //should print hello
        list.addLast("GoodBye");
        list.addFirst("Hi");
        System.out.println(list.size()); //prints 3
        System.out.println(list.first()); //hi
        list.removeFirst();
        System.out.println(list.removeFirst()); //hello
        System.out.println(list.last());//goodbye
    }
}
