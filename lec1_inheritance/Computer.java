package lec1_inheritance;

/**
 * Simple example to demonstrate Java lec1_inheritance and lec1_polymorphism.
 */
public class Computer {
    //final constants, conventionally in caps
    private static final int ONE_BILLION = 1000000000; // for Gigabytes or Gigahertz

    //instance variables, "protected" modifier allows subclasses to access these fields and noone else
    protected long availableRam; //in bytes
    protected long processorSpeed; //in hertz
    protected long availableHDDSpace; //in bytes

    //constructors are called to create new objects of this class
    public Computer(long ram, int speed, int hDDspace)
    {
        availableRam = ram;
        processorSpeed = speed;
        availableHDDSpace = hDDspace;
    }

    //default constructor, takes no parameters
    public Computer()
    {
        //generic low-end laptop in 2017
        availableRam = 4 * ONE_BILLION;
        processorSpeed = 2 * ONE_BILLION; //2 GHz
        availableHDDSpace = 500 * ONE_BILLION;
    }

    //instance variables are accessed via public getters
    public long getAvailableRam() {
        return availableRam;
    }

    //instance variables are assigned using public setters
    public void setAvailableRam(long availableRam) {
        this.availableRam = availableRam;
    }

    public long getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(long processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public long getAvailableHDDSpace() {
        return availableHDDSpace;
    }

    public void setAvailableHDDSpace(long availableHDDSpace) {
        this.availableHDDSpace = availableHDDSpace;
    }
}
 
