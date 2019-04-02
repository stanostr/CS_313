package sorting;

import iterator.ArrayList;
import iterator.List;
import priorityqueue.SortedPriorityQueue;

public class PQSortTest {
    public static void main(String[] args)
    {
        //testing with Integer data
        Integer[] data = {1, 2, 41, 123, 11, 8};
        System.out.print(" Before sort: ");
        for(int i=0; i<data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
        PQSort.pqSort(data, new SortedPriorityQueue<>());
        System.out.print("\n After PQSort: ");
        for(int i=0; i<data.length; i++)
        {
            System.out.print(data[i] + " ");
        }

        System.out.println(); //line break

        //testing with String data
        String[] data2 = {"abc", "abcd", "abd", "bac", "badc", "z"};
        System.out.print(" Before sort: ");
        for(int i=0; i<data2.length; i++)
        {
            System.out.print(data2[i] + " ");
        }
        PQSort.pqSort(data2, new SortedPriorityQueue<>());
        System.out.print("\n After PQSort: ");
        for(int i=0; i<data2.length; i++)
        {
            System.out.print(data2[i] + " ");
        }

        System.out.println(); //line break

        //testing with ArrayList of Integers

        List<Integer> data3 = new ArrayList<>();
        data3.add(7);
        data3.add(9);
        data3.add(5);
        data3.add(3);
        data3.add(4);

        System.out.print(" Before sort: ");
        for(int i=0; i<data3.size(); i++)
        {
            System.out.print(data3.get(i) + " ");
        }
        PQSort.pqSort(data3, new SortedPriorityQueue<>());
        System.out.print("\n After PQSort: ");
        for(int i=0; i<data3.size(); i++)
        {
            System.out.print(data3.get(i) + " ");
        }
    }
}
