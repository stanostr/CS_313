package project3_files;

public class PriorityQueueTest {
    public static void main(String[] args)
    {
        PriorityQueue<Integer, String> priorityQueue = new LinkedHeapPQ<Integer, String>();
        priorityQueue.removeMin();
        priorityQueue.insert(4, "String 0");
        priorityQueue.insert(11, "String 1");
        priorityQueue.insert(23, "String 2");
        priorityQueue.insert(3, "String 3");
        priorityQueue.insert(4, "String 4");
        priorityQueue.insert(12, "String 5");
        priorityQueue.insert(24, "String 6");
        priorityQueue.insert(31, "String 7");
        priorityQueue.insert(42, "String 8");
        priorityQueue.insert(18, "String 9");
        priorityQueue.insert(25, "String 10");
        priorityQueue.insert(2, "String 11");
        priorityQueue.insert(43, "String 12");
        priorityQueue.insert(44, "String 13");
        priorityQueue.insert(236, "String 14");
        priorityQueue.insert(38, "String 15");
        System.out.println(priorityQueue.insert(7, "Another String").getValue()); //line 1
        System.out.println("Current size: " + priorityQueue.size()); //line 2
        System.out.println(priorityQueue.min().getValue()); //line 3
        System.out.println(priorityQueue.removeMin().getValue()); //line 4
        System.out.println(priorityQueue.min().getValue()); //line 5
        System.out.println(priorityQueue.min().getKey()); //line 6

        /* Expected output:
         * Another String
         * 17
         * String 11
         * String 11
         * 3
         */
    }
}
