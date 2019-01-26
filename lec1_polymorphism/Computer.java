package lec1_polymorphism;

/**
 * Simple example to demonstrate Java lec1_inheritance and lec1_polymorphism.
 */
public class Computer {

    protected long availableRam; //in megabytes
    protected long processorSpeed; //in megahertz
    protected long availableHDDSpace; //in megabytes

    public Computer(long ram, long speed, long hDDspace)
    {
        availableRam = ram;
        processorSpeed = speed;
        availableHDDSpace = hDDspace;
    }

    public Computer()
    {
        //generic low-end laptop in 2017
        availableRam = 4000; //4GB
        processorSpeed = 2000; //2 GHz
        availableHDDSpace = 5000000; //500 GB
    }

    public long getAvailableRam() {
        return availableRam;
    }

    public void setAvailableRam(int availableRam) {
        this.availableRam = availableRam;
    }

    public long getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(int processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public long getAvailableHDDSpace() {
        return availableHDDSpace;
    }

    public void setAvailableHDDSpace(int availableHDDSpace) {
        this.availableHDDSpace = availableHDDSpace;
    }
}
 
