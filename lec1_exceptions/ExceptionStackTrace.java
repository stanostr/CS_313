package lec1_exceptions;

public class ExceptionStackTrace {
    public static void main(String[] args)
    {
        methodOne(0);
        System.out.println("Carrying on...");
    }

    private static void methodOne(int num)
    {
        methodTwo(num);
    }

    private static void methodTwo(int num)
    {
        methodThree(num);
    }

    private static void methodThree(int num)
    {
        System.out.println(1/num);
    }

}
