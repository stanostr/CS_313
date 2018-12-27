package lec1_inheritance;

import static lec1_inheritance.Car.FuelType.*;

/**
 * A simple class to represent a car
 */
public class Car {

    //enumtype to represent types of fuel
    public enum FuelType {
        GAS, DIESEL, ELECTRIC, HYBRID
    }

    //instance variables
    private FuelType fuelType;
    private int curbWeight;
    private int horsepower;
    private int fuelRemaining; //percent
    private int RPM; //rotations per minute

    //default constructor with default values
    public Car()
    {
        fuelType = GAS;
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
