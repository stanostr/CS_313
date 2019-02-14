package linkedlist;

public class CircularLinkedListTest {
    public static void main(String[] args)
    {
        //what does each System.out.println print?
        CircularLinkedList<String> linkedList = new CircularLinkedList<>();
        linkedList.addFirst("Sven");
        linkedList.addFirst("Olaf");
        linkedList.addFirst("Helga");
        linkedList.addLast("Elsa");
        linkedList.addLast("Bjorn");

        System.out.println(linkedList.first()); //line 1
        linkedList.rotate();
        System.out.println(linkedList.removeFirst()); //line 2
        System.out.println(linkedList.last()); //line 3
        linkedList.rotate();
        System.out.println(linkedList.last()); //line 4
    }
}
