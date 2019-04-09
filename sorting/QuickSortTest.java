package sorting;

import queue.LinkedQueue;
import queue.Queue;

public class QuickSortTest {
    public static void main(String[] args)
    {
        testQuickSort();
        System.out.println(); //line break
        testQuickSortInPlace();
    }

    private static void testQuickSort() {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(12);
        queue.enqueue(31);
        queue.enqueue(11);
        queue.enqueue(14);
        queue.enqueue(18);
        queue.enqueue(82);
        queue.enqueue(21);
        queue.enqueue(14);
        QuickSort.quickSort(queue, new DefaultComparator<>());
        int n = queue.size();
        for(int i=0; i<n; i++)
        {
            System.out.print(queue.dequeue() + " ");
        }
    }

    private static void testQuickSortInPlace() {
        //we have to make it Integer not int to avoid compiler whining
        Integer[] array = {12, 31, 11, 14, 18, 82, 21, 14};
        QuickSort.quickSortInPlace(array, new DefaultComparator<>(), 0, array.length-1); //sort
        //print results
        for(Integer i: array)
        {
            System.out.print(i + " ");
        }
    }

}
