package sorting;

import queue.LinkedQueue;
import queue.Queue;

public class MergeSortTest {
    public static void main(String[] args)
    {
        testArrayMergeSort();
        System.out.println();//line break
        testQueueMergeSort();
        System.out.println(); //line break
        testNonRecursiveMergeSort();
    }

    private static void testNonRecursiveMergeSort() {
        //we have to make it Integer not int to avoid compiler whining
        Integer[] array = {12, 31, 11, 14, 18, 82, 21, 14};
        MergeSort.mergeSortNonRecursive(array, new DefaultComparator<>()); //sort
        //print results
        for(Integer i: array)
        {
            System.out.print(i + " ");
        }
    }

    private static void testQueueMergeSort() {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(12);
        queue.enqueue(31);
        queue.enqueue(11);
        queue.enqueue(14);
        queue.enqueue(18);
        queue.enqueue(82);
        queue.enqueue(21);
        queue.enqueue(14);
        MergeSort.mergeSort(queue, new DefaultComparator<>());
        int n = queue.size();
        for(int i=0; i<n; i++)
        {
            System.out.print(queue.dequeue() + " ");
        }
    }

    private static void testArrayMergeSort() {
        //we have to make it Integer not int to avoid compiler whining
        Integer[] array = {12, 31, 11, 14, 18, 82, 21, 14};
        MergeSort.mergeSort(array, new DefaultComparator<>()); //sort
        //print results
        for(Integer i: array)
        {
            System.out.print(i + " ");
        }
    }


}
