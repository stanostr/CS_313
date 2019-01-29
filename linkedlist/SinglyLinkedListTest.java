package linkedlist;

public class SinglyLinkedListTest {
    //using our SinglyLinkedList class
    public static void main(String[] args)
    {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        System.out.println(linkedList.isEmpty()); //prints true

        linkedList.addFirst(23);
        linkedList.addFirst(42);
        linkedList.addFirst(12);
        linkedList.addLast(59);

        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.first());
        System.out.println(linkedList.removeFirst());
        
        //if we had to implement round-robin scheduling using a singly linked list,
        //how would we do it?
    }
}
