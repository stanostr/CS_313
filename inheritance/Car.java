package inheritance;

public class Car {

    //enumtype to represent types of fuel
    public enum FuelType {
        GAS, DIESEL, ELECTRIC, HYBRID
    }

    //instance variables
    private FuelType fuelType;
    private int curbWeight;
    private int horsepower;
    private int length;
    private int fuelRemaining; //percent
    private int RPM; //rotations per minute

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public int getCurbWeight() {
        return curbWeight;
    }

    public void setCurbWeight(int curbWeight) {
        this.curbWeight = curbWeight;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFuelRemaining() {
        return fuelRemaining;
    }

    public void setFuelRemaining(int fuelRemaining) {
        this.fuelRemaining = fuelRemaining;
    }

    public int getRPM() {
        return RPM;
    }

    public void setRPM(int RPM) {
        this.RPM = RPM;
    }
}
