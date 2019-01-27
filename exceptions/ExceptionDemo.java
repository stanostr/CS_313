package exceptions;

public class ExceptionDemo {
    public static void main(String[] args)
    {
        System.out.println("Hello!"); //outside of exception block
        try {
            String aString = args[0];
            System.out.println(aString);
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("ArrayIndexOutOfBoundsException occurred");
        }
        finally {
            //this gets run no matter what exceptions get thrown
            //may not get run if program terminates by System.exit(), power outage, etc.
            System.out.println("Always say goodbye!");
        }
    }
}
