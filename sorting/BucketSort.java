package sorting;

import queue.DoublyLinkedList;
import queue.LinkedQueue;
import queue.Queue;

/** Homework exercise solution
 * @author Stanislav Ostrovskii
 */
public class BucketSort {

    /**
     * Bucket-sorts a Queue of Integers
     * @param N range of possible Integer keys must between 0 and N-1
     */
    public static void bucketSort(Queue<Integer> queue, int N)
    {
        int n = queue.size();
        if(n < 2)  return; //already sorted
        Queue[] B = new LinkedQueue[N];
        for(int i=0; i<n; i++)
        {
            int value = queue.dequeue();
            if(B[value]==null) B[value] = new LinkedQueue<Integer>();
            B[value].enqueue(value);
        }
        for(int j=0; j<N; j++)
        {
            if(B[j]!=null) {
                int seqSize = B[j].size();
                for (int k = 0; k < seqSize; k++)
                    queue.enqueue((Integer) B[j].dequeue());
            }
        }
    }

    /**
     * Bucket-sorts a DoublyLinkedList of Integers
     * @param N range of possible Integer keys must between 0 and N-1
     */
    public static void bucketSort(DoublyLinkedList<Integer> list, int N)
    {
        int n = list.size();
        if(n < 2)  return; //already sorted
        Queue[] B = new LinkedQueue[N];
        for(int i=0; i<n; i++)
        {
            int value = list.removeFirst();
            if(B[value]==null)  B[value] = new LinkedQueue<Integer>();
            B[value].enqueue(value);
        }
        for(int j=0; j<N; j++)
        {
            if(B[j]!=null) {
                int seqSize = B[j].size();
                for (int k = 0; k < seqSize; k++)
                    list.addLast((Integer) B[j].dequeue());
            }
        }
    }
}
