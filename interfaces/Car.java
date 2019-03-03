package interfaces;


/**
 * Simple class to represent a car
 */
public class Car implements Operable {
    //enumtype to represent types of fuel
    public enum FuelType {
        GAS, DIESEL, ELECTRIC, HYBRID
    }

    //instance variables
    private FuelType fuelType;
    private int curbWeight;
    private int horsepower;
    private int fuelRemaining; //percent
    private int RPM; //engine rotations per minute

    //default constructor with default values
    public Car()
    {
        fuelType = FuelType.GAS;
        horsepower = 100;
        curbWeight = 3000;
        fuelRemaining = 100; //default is full tank
        RPM = 0; //default is car off
    }

    public Car(FuelType fuelType, int curbWeight, int horsepower, int fuelRemaining)
    {
        this.fuelType = fuelType;
        this.curbWeight = curbWeight;
        this.horsepower = horsepower;
        this.fuelRemaining = fuelRemaining;
        RPM = 0;
    }

    @Override
    public void turnOn() {
        //let's say idling engine spins at 1000 rotations per minute;
        RPM =  1000;
    }

    @Override
    public void run(int minutes) {
        //let's say that idling burns 0.2% of the fuel capacity per minute
        fuelRemaining = (int) (fuelRemaining - 0.2 * minutes); //note the cast

        //if fuel runs low display low fuel message
        if(fuelRemaining < 5 && fuelRemaining > 0)
            displayLowFuel();
        if(fuelRemaining <= 0)
        {
            System.out.println("You are out of fuel... car shutting down :( ");
            RPM = 0;
            fuelRemaining = 0;
        }
    }

    private void displayLowFuel()
    {
        System.out.println("You are low on fuel!");
    }


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
