package generics;

public class Main {
    public static void main(String[] args)
    {
        //correct way to use generics
        GenericPair<String, Integer> pair = new GenericPair<>();
        System.out.println(pair.first);
        System.out.println(pair.second);

        pair.setFirst("Hello");
        pair.setSecond(26);

        System.out.println(pair.first);
        System.out.println(pair.second);

        //bonus example, do not code like this!
        GenericPair pair2 = new GenericPair<>("Hello", 34);
        pair2.setFirst("Hello");
        pair2.setSecond(pair);

        System.out.println(pair2.first);
        System.out.println( ((GenericPair) pair2.second).getSecond() ); //prints 26
    }
}
