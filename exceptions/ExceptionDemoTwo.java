package exceptions;

public class ExceptionDemoTwo {
    public static void main(String[] args)
    {
        try {
           printNumber(args[0]);
           int i = 10/(Integer.valueOf(args[0]));
        }
        catch (ArrayIndexOutOfBoundsException OutOfBoundsException) {
            System.out.println("ArrayIndexOutOfBoundsException occurred");
        }
        catch (NumberFormatException numberFormatException)
        {
            System.out.println("NumberFormatException occurred");
        }
        finally {
            System.out.println("Always say goodbye!");
        }

        System.out.println("Program still running :)");
    }

    private static void printNumber(String string) throws NumberFormatException
    {
        int number = Integer.valueOf(string);
        System.out.println(number);
    }
}
