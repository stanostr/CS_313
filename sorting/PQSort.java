package sorting;

import iterator.List;
import linkedlist.DoublyLinkedList;
import priorityqueue.PriorityQueue;

public class PQSort {

    /** Sorts an array of type T
     * @param <T> element type
     */
    public static <T> void pqSort(T[] data, PriorityQueue<T, ?> priorityQueue)
    {
        int n = data.length;
        for(int j = 0; j < n; j++)
        {
            T element = data[j];
            priorityQueue.insert(element, null); //element is key, null value
        }
        for(int j=0; j<n; j++)
        {
            T element = priorityQueue.removeMin().getKey();
            data[j] = element; //smallest key in pq is placed next in sorted part of array
        }
    }


    /** Sorts a DoublyLinkedList
     * @param <T> element type
     */
    public static <T> void pqSort(DoublyLinkedList<T> data, PriorityQueue<T, ?> priorityQueue)
    {
        int n = data.size();
        for(int j = 0; j < n; j++)
        {
            T element = data.removeFirst();
            priorityQueue.insert(element, null); //element is key, null value
        }
        for(int j=0; j<n; j++)
        {
            T element = priorityQueue.removeMin().getKey();
            data.addLast(element); //smallest key in pq is placed next in original list
        }
    }

    /** Sorts a List
     * @param <T> element type
     */
    public static <T> void pqSort(List<T> data, PriorityQueue<T, ?> priorityQueue)
    {
        int n = data.size();
        for(int j = 0; j < n; j++)
        {
            T element = data.get(j); //O(1) time for get
            priorityQueue.insert(element, null); //element is key, null value
        }
        for(int j=0; j<n; j++)
        {
            T element = priorityQueue.removeMin().getKey();
            data.set(j, element); //smallest key in pq is placed next in original list
        }
    }
}
