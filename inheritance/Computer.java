package inheritance;

/**
 * Simple example to demonstrate Java lec1_inheritance and lec1_polymorphism.
 */
public class Computer {

    //instance variables, "protected" modifier allows subclasses to access these fields and noone else
    protected long availableRam; //in megabytes
    protected long processorSpeed; //in megahertz
    protected long availableHDDSpace; //in megabytes

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
        availableRam = 4000;
        processorSpeed = 2000; //2 GHz
        availableHDDSpace = 500000;
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
 
