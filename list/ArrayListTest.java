package list;

public class ArrayListTest {
    public static void main(String[] args)
    {
        List<Integer> arrayList = new FixedArrayList<>();
        //what would happen if the next line was not commented out
        //System.out.println(arrayList.get(1));
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(1, 3);
        arrayList.add(4);
        arrayList.add(0, 8);
        arrayList.add(9);
        System.out.println(arrayList.set(0, 7)); //line 1
        System.out.println(arrayList.remove(1)); //line 2
        System.out.println(arrayList.get(1)); //line 3
        
        //what would happen if we did not comment out these lines?
        //for(int i=0; i<6; i++) 
        //    arrayList.add(1);
    }
}
