package list.exercise;
import list.List;

public class ExperimentalAnalysis {
    public static void main(String[] args)
    {
        List<Integer> newList = new ArrayList<>(134217728*2);
        for(int i=0; i<newList.size(); i++)
        {
            newList.add(1);
        }
        long startNew = System.currentTimeMillis();
        newList.add(0, 1);
        long elapsedNew = System.currentTimeMillis() - startNew;
        System.out.println("Using new list: " + elapsedNew);
        newList = null; //to clean up memory

        List<Integer> oldList = new ArrayList<>(134217728*2);
        for(int i=0; i<oldList.size(); i++)
        {
            oldList.add(1);
        }
        long startOld = System.currentTimeMillis();
        oldList.add(0, 1);
        long elapsedOld = System.currentTimeMillis() - startOld;
        System.out.println("Using old list: " + elapsedOld);
    }
}
