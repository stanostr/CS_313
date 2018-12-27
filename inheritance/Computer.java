package inheritance;

/**
 * Simple example to demonstrate Java inheritance and polymorphism.
 */
public class Computer {
    //final constants, conventionally in caps
    private int ONE_BILLION = 1000000000; // for Gigabytes or Gigahertz

    //instance variables, "protected" modifier allows subclasses to access these fields and noone else
    protected int availableRam; //in bytes
    protected int numberOfProcessors;
    protected int processorSpeed; //in hertz
    protected int availableHDDSpace; //in bytes

    //constructors are called to create new objects of this class
    public Computer(int ram, int numCores, int speed, int hDDspace)
    {
        availableRam = ram;
        numberOfProcessors = numCores;
        processorSpeed = speed;
        availableHDDSpace = hDDspace;
    }

    //default constructor, takes no parameters
    public Computer()
    {
        //generic low-end laptop in 2017
        availableRam = 4 * ONE_BILLION;
        numberOfProcessors = 2;
        processorSpeed = 2 * ONE_BILLION; //2 GHz
        availableHDDSpace = 500 * ONE_BILLION;
    }

    //instance variables are accessed via public getters
    public int getAvailableRam() {
        return availableRam;
    }

    //instance variables are assigned using public setters
    public void setAvailableRam(int availableRam) {
        this.availableRam = availableRam;
    }

    public int getNumberOfProcessors() {
        return numberOfProcessors;
    }

    public void setNumberOfProcessors(int numberOfProcessors) {
        this.numberOfProcessors = numberOfProcessors;
    }

    public int getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(int processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public int getAvailableHDDSpace() {
        return availableHDDSpace;
    }

    public void setAvailableHDDSpace(int availableHDDSpace) {
        this.availableHDDSpace = availableHDDSpace;
    }
}
 