package iterator;

import java.util.Iterator;
import java.util.Random;
import static java.lang.Thread.sleep;

/**
 * To illustrate the possibly problems of using a "lazy iterator" in a multithreaded environment.
 * Running the main method will cause an exception about half of the time.
 * @author Stanislav Ostrovskii
 */
public class LazyIteratorFail {
    public static void main(String[] args)
    {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        arrayList.add("13");
        arrayList.add("14");
        arrayList.add("15");

        /**
         *  Runs two threads, each of which creates their own Iterator instance.
         *  One is supposed to print all the elements in the ArrayList using an Iterator.
         *  The other just removes all elements using remove()
         */
        new Thread(new printerRunnable(arrayList)).start();
        new Thread(new removerRunnable(arrayList)).start();
    }

    /**
     * A Runnable that prints all the Strings in an array list using an iterator.
     */
    private static class printerRunnable implements Runnable  {
        ArrayList<String> arrayList;
        public printerRunnable(ArrayList<String> arrayList)
        {
            this.arrayList = arrayList;
        }

        @Override
        public void run() {
            Iterator iter = arrayList.iterator();
            for(int i=0; i<arrayList.size(); i++)
            {
                if(iter.hasNext())
                {
                    //sleeps a random number of milliseconds, just to help us break it :)
                    try {
                        sleep( new Random().nextInt(10)+1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(iter.next());
                }
            }
        }
    }

    /**
     * A Runnable that prints all the Strings in an array list using an iterator
     */
    private static class removerRunnable implements Runnable  {
        ArrayList<String> arrayList;
        public removerRunnable(ArrayList<String> arrayList)
        {
            this.arrayList = arrayList;
        }

        @Override
        public void run() {
            Iterator iter = arrayList.iterator();
            for(int i=0; i<arrayList.size(); i++)
            {
                if(iter.hasNext())
                {
                    iter.next();
                    try {
                        sleep( new Random().nextInt(10)+1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    iter.remove();
                }
            }
        }
    }
}
