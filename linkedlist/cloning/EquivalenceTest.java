package linkedlist.cloning;

public class EquivalenceTest {
    public static void main(String[] args)
    {
        SinglyLinkedList<String> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        CircularLinkedList<String> list3 = new CircularLinkedList<>();
        list1.addFirst("Hi");
        list2.addFirst("Hi");
        list3.addFirst("Hi");
        System.out.println(list1.equals(list2)); //line 1
        System.out.println(list1.equals(list3)); //line 2
    }
}
