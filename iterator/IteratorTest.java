package iterator;

import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> iterator1 = list.iterator();
        while(iterator1.hasNext())
        {
            Integer i = iterator1.next();
            System.out.println(i);
            if(i==3) iterator1.remove();
        }
        System.out.println(list.size());

        for(Integer integer: list) {
            System.out.println(integer);
        }
    }
}
