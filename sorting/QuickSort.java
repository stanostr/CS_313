package sorting;

import queue.LinkedQueue;
import queue.Queue;

import java.util.Comparator;

public class QuickSort {
    /** Quick sort contents of a queue using first element as pivot */
    public static <K> void quickSort(Queue<K> data, Comparator<K> comp)
    {
        int n = data.size();
        if(n<2) return; //already sorted
        //divide
        K pivot = data.first();
        Queue<K> less = new LinkedQueue<>();
        Queue<K> equal = new LinkedQueue<>();
        Queue<K> greater = new LinkedQueue<>();
        while(!data.isEmpty())
        {
            K element = data.dequeue();
            int c = comp.compare(element, pivot);
            if(c<0) less.enqueue(element);
            else if(c==0) equal.enqueue(element);
            else greater.enqueue(element);
        }
        //conquer
        quickSort(less, comp);
        quickSort(greater, comp);
        //combine results again
        while(!less.isEmpty())
            data.enqueue(less.dequeue());
        while(!equal.isEmpty())
            data.enqueue(equal.dequeue());
        while(!greater.isEmpty())
            data.enqueue(greater.dequeue());
    }

    /** sort the sub-array data[a ... b], inclusive */
    public static <E> void quickSortInPlace(E[] data, Comparator<E> comp, int a, int b)
    {
        if(a >= b) return;
        int left = a;
        int right = b-1;
        //selects last element for pivot
        E pivot = data[b];
        E temp; //used for swaps
        while(left <= right) {
            while(left <= right && comp.compare(data[left], pivot) < 0) left++;
            while(left <= right && comp.compare(data[right], pivot) > 0) right--;
            if(left <= right) {
                temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++; right--;
            }
        }

        //put pivot in its correct place
        temp = data[left];
        data[left] = data[b];
        data[b] = temp;

        //recurse
        quickSortInPlace(data, comp, a, left-1);
        quickSortInPlace(data, comp, left+1, b);
    }
}
