package linkedlist;

public class LinkedListEquivalenceTest {
    public static void main(String[] args)
    {
        DoublyLinkedList<String> myList = new DoublyLinkedList<>();
        myList.addFirst("a string");
        DoublyLinkedList<String> myList2 = myList;
        DoublyLinkedList<String> myList3 = new DoublyLinkedList<>();
        myList3.addFirst("a string");

        System.out.println(myList==myList2); //line 1
        System.out.println(myList.equals(myList)); //line 2
        System.out.println(myList==myList3); //line 3
        System.out.println(myList.equals(myList3)); //line 4
    }
}
