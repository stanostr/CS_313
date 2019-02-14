package linkedlist.cloning;

public class MethodSpecificityTest {
    public static void main(String[] args) {
        Integer i = 0;
        method(i);
    }

    private static void method(Object o)
    {
        System.out.println("A");
    }

    private static void method(Integer i)
    {
        System.out.println("B");
    }
}

