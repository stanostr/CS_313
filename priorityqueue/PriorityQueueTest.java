package priorityqueue;

public class PriorityQueueTest {
    public static void main(String[] args)
    {
        PriorityQueue<Integer, String> unsortedpq = new UnsortedPriorityQueue<>();
        unsortedpq.insert(4, "Sven");
        unsortedpq.insert(11, "Helga");
        unsortedpq.insert(23, "William");
        unsortedpq.insert(3, "Olaf");
        System.out.println(unsortedpq.insert(7, "Vlad").getValue()); //line 1
        System.out.println("Current size: " + unsortedpq.size()); //line 2
        System.out.println(unsortedpq.min().getValue()); //line 3
        System.out.println(unsortedpq.removeMin().getValue()); //line 4
        System.out.println(unsortedpq.min().getValue()); //line 5
        System.out.println(unsortedpq.min().getKey()); //line 6
    }
}
