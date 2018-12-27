package lec1_polymorphism;

/**
 * a class that extends Computer,
 * i.e. Computer is a "superclass" of this class
 * and Laptop is a "subclass" of Computer
 * * Now this class implements the Operable interface.
 */
public class Laptop extends Computer implements Operable{
    //addtional instance variables
    private int batteryLeft; //in percent
    private boolean isCharging;

    //new default constructor
    public Laptop()
    {
        super(); //call to superclass default constructor, super calls must be first line in constructor
        batteryLeft = 100;
    }

    //new constructor with parameters
    public Laptop(int ram, int numCores, int speed, int hDDspace, int batteryLeft)
    {
        super(ram, numCores, speed, hDDspace);
        this.batteryLeft = batteryLeft;
    }


    //implementations for these two methods are REQUIRED because we are implementing Operable
    @Override
    public void turnOn() {
        //turning on consumes 2 Gigabytes of RAM
        availableRam = availableRam - 2 * ONE_BILLION;
    }

    @Override
    public void run(int minutes) {
        //if laptop not charging, running depletes laptop by 1% a minute
        if(!isCharging)
        {
            batteryLeft = batteryLeft - minutes;

            //if battery falls to zero, laptop turns off
            if(batteryLeft<=0) {
                batteryLeft = 0;
                System.out.println("Laptop ran out of memory and turned off");
            }
        }
        else //laptop is charging
        {
            //charges 2% per minute
            batteryLeft = batteryLeft + minutes;
            if(batteryLeft>100)
                batteryLeft = 100;
        }
    }

    public int getBatteryLeft() {
        return batteryLeft;
    }

    public void setBatteryLeft(int batteryLeft) {
        this.batteryLeft = batteryLeft;
    }
}
