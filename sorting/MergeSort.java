package sorting;

import queue.LinkedQueue;
import queue.Queue;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
    private MergeSort() {}

    /** Merges contents of sorted arrays array1 and array2 into result array */
    public static <K> void merge(K[] array1, K[] array2, K[] result, Comparator<K> comp)
    {
        int i = 0, j = 0;
        while(i+j < result.length)
        {
            if(j == array2.length || //already reached the end of second array OR
                    //we haven't reached the end of either array
                    //and the element in first array is smaller
                    (i < array1.length && comp.compare(array1[i], array2[j]) < 0))
                result[i+j] = array1[i++]; //copy ith element of array1 and increment
            else
                result[i+j] = array2[j++];
        }
    }

    /** merge sort contents of array */
    public static <K> void mergeSort(K[] array, Comparator<K> comp)
    {
        int n = array.length;
        if(n < 2) return; //already trivially sorted
        //divide
        int mid = n/2;
        K[] part1 = Arrays.copyOfRange(array, 0, mid);
        K[] part2 = Arrays.copyOfRange(array, mid, n);
        //conquer
        mergeSort(part1, comp);
        mergeSort(part2, comp);
        merge(part1, part2, array, comp);
    }

    /** Merge contents of two sorted queues into an empty queue */
    public static <K> void merge(Queue<K> q1, Queue<K> q2, Queue<K> q, Comparator<K> comp)
    {
        while(!q1.isEmpty() && !q2.isEmpty()) {
            if(comp.compare(q1.first(), q2.first()) < 0)
                q.enqueue(q1.dequeue());
            else q.enqueue(q2.dequeue());
        }
        while(!q1.isEmpty()) //if we reached here, either q1 or q1 empty
        {
            q.enqueue(q1.dequeue());
        }
        while(!q2.isEmpty()) //if we reached here, q1 must be empty
        {
            q.enqueue(q2.dequeue());
        }
    }

    /** Merge-sort contents of a queue. */
    public static <K> void mergeSort(Queue<K> queue, Comparator<K> comp)
    {
        int n = queue.size();
        if(n < 2)  return; //already sorted
        //divide
        int mid = n/2;
        Queue<K> part1 = new LinkedQueue<>();
        Queue<K> part2 = new LinkedQueue<>();
        for(int i=0; i<mid; i++)
        {
            part1.enqueue(queue.dequeue());
        }
        for(int j=mid; j<n; j++)
        {
            part2.enqueue(queue.dequeue());
        }
        //conquer
        mergeSort(part1, comp);
        mergeSort(part2, comp);
        //merge results
        merge(part1, part2, queue, comp);
    }

    /** Merges two sorted sections of array "in" into array "out". */
    public static <E> void merge(E[] in, E[] out, Comparator<E> comp, int start, int inc)
    {
        int end1 = Math.min(start + inc, in.length);
        int end2 = Math.min(start + 2 * inc, in.length);
        int x = start; //current index in the first segment
        int y = start+inc; //current index in the second segment
        int z = start; //current index in out
        while(x < end1 && y < end2)
        {
            if(comp.compare(in[x], in[y]) < 0)
                out[z++] = in[x++];
            else out[z++] = in[y++];
        }
        //if we reached past the above while loop, we have finished at least one segment
        //if we have not reached the end of the first, just copy it to out
        if(x < end1) System.arraycopy(in, x, out, z, end1-x);
        //else if we have not reached the end of the second segment, copy that
        else if(y < end2) System.arraycopy(in, y, out, z, end2-y);
    }

    /** Merge-sort contents of data array. */
    public static <E> void mergeSortNonRecursive(E[] array, Comparator<E> comp)
    {
        int n = array.length;
        E[] temp, src = array, dest = (E[]) new Object[n];
        for(int i=1; i < n; i*= 2) //each iteration sorts all runs of length n
        {
            for(int j = 0; j < n; j+= 2*i) //each pass merges two runs of length n
            {
                merge(src, dest, comp, j, i);
            }
            temp = array;
            src = dest;
            dest = temp;
        }
        if(array!=src)
            //additional copy to get result back to original
            System.arraycopy(src, 0, array, 0, n);

    }


}

