package linkedlist;

public class DoublyLinkedListTest {
    public static void main(String[] args)
    {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list.removeFirst()); //line 1
        System.out.println(list.removeLast()); //line 2
    }
}

