package lec1_polymorphism;

/**
 * Simple example to demonstrate Java lec1_inheritance and lec1_polymorphism.
 */
public class Computer {
    public long ONE_BILLION = 1000000000;

    protected long availableRam; //in bytes
    protected long processorSpeed; //in hertz
    protected long availableHDDSpace; //in bytes

    public Computer(long ram, long speed, long hDDspace)
    {
        availableRam = ram;
        processorSpeed = speed;
        availableHDDSpace = hDDspace;
    }

    public Computer()
    {
        //generic low-end laptop in 2017
        availableRam = 4 * ONE_BILLION;
        processorSpeed = 2 * ONE_BILLION; //2 GHz
        availableHDDSpace = 500 * ONE_BILLION;
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
 