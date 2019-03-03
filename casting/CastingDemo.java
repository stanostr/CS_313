import interfaces.Operable;

public class CastingDemo {
    public static void main(String[] args)
    {
        //this declares a reference variable;
        Laptop laptop;

        //this initializes an actual laptop object
        //this object now exists in memory
        laptop = new Laptop(1000, 1200, 100000, 100);
        laptop.setCharging(false);

        //laptop qualifies as an operable because it implements the interface
        //in this method we know this is a Laptop, but the doSomething method may not
        doSomething(laptop);

        //this will print 0 because the doSomething method killed all our battery
        System.out.println("Battery left: " + laptop.getBatteryLeft());
    }

    private static void doSomething(Operable operable)
    {
        //we can do this safely because we know that ALL Operables have a run(int) method.
        operable.run(1000);

        //Here we are casting, or "relabeling" the Operable as a laptop.
        //this does not affect what is stored in the actual object
        //this works because we actually passed a laptop.
        Laptop laptop = (Laptop) operable;
        System.out.println(laptop.getProcessorSpeed());

        //This, however, is violating the compiler's trust!
        //The compiler will think that we know what we are doing, and allow us to compile this code.
        //However, the operable we passed in is NOT a Car, and this will crash during runtime
        Car car = (Car) operable;   //ClassCastException thrown here
    }
}
