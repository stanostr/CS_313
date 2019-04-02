package sorting;

public class ArraySortingAlgorithms {

    public static void insertionSort(char[] data)
    {
        //start with the second element, first is trivially sorted
        int n = data.length;
        for(int k = 1; k<n; k++)
        {
            char current = data[k];
            int j = k;

            //go through the previously sorted part of the array
            //until either a smaller element is found, or
            //we reach the start of array (i.e. current is smallest)
            while(j > 0 && data[j-1] > current)
            {
                 data[j] = data[j-1];
                 j--;
            }
            data[j] = current;
        }
    }

    public static void selectionSort(char[] data)
    {
        int n = data.length;
        for(int i = 0; i < n; i++)
        {
            //searches for smallest element
            int lowestIndex = i;
            for(int j= i + 1; j < n; j++)
            {
                if(data[j] < data[lowestIndex])
                    lowestIndex = j;
            }
            //swaps lowest with current
            char smallest = data[lowestIndex];
            data[lowestIndex] = data[i];
            data[i] = smallest;
        }
    }

    //demonstration
    public static void main(String[] args)
    {
        char[] data =  {'z', 'x', 'w', 'a', 'c', 'b'};
        System.out.print(" Before sort: ");
        for(int i=0; i<data.length; i++)
        {
            System.out.print(data[i]);
        }
        insertionSort(data);
        System.out.print("\n After insertion sort ");
        for(int i=0; i<data.length; i++)
        {
            System.out.print(data[i]);
        }

        char[] data2 =  {'f', 'y', 'a', 'a', 'c', 'b'};
        System.out.print("\n Before sort: ");
        for(int i=0; i<data2.length; i++)
        {
            System.out.print(data2[i]);
        }
        selectionSort(data2);
        System.out.print("\n After selection sort ");
        for(int i=0; i<data2.length; i++)
        {
            System.out.print(data2[i]);
        }

    }
}
