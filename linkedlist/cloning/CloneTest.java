package linkedlist.cloning;

public class CloneTest {
    public static void main(String[] args)
    {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);

        SinglyLinkedList<Integer> linkedList2 = linkedList.clone();
        if(linkedList2!=null) {
            linkedList2.removeFirst();
            System.out.println(linkedList2.first()); //line 1
            System.out.println(linkedList.first()); //line 2
        }
        else System.out.println("linkedList2 is null");
    }
}
