package list.exercise;
import list.List;

public class ExperimentalAnalysis {
    public static void main(String[] args)
    {
        List<Integer> oldList = new list.ArrayList<>(1);
        List<Integer> newList = new ArrayList<>(1);
        long startNew = System.currentTimeMillis();
        for(int i=0; i<21000000; i++)
        {
            newList.add(0);
        }
        long elapsed = System.currentTimeMillis() - startNew;
        System.out.println("Using new list: " + elapsed);

        long startOld = System.currentTimeMillis();
        for(int i=0; i<21000000; i++)
        {
            oldList.add(0);
        }
        elapsed = System.currentTimeMillis() - startOld;
        System.out.println("Using old list: " + elapsed);

    }
}
