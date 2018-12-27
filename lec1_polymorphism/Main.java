package lec1_polymorphism;

import static lec1_polymorphism.Car.FuelType.*;

public class Main {
    public static void main(String[] args)
    {
        Car myCar = new Car(GAS, 4000, 200, 50);
        Laptop myLaptop = new Laptop();

        System.out.println("myLaptop has " + myLaptop.getAvailableRam() + " of available ram");
        myLaptop.turnOn();
        System.out.println("myLaptop turned on");
        System.out.println("myLaptop now has " + myLaptop.getAvailableRam() + " of available ram"); //has decreased

        System.out.println("myCar is running at " + myCar.getRPM() + " RPM");
        System.out.println("myCar turned on");
        myCar.turnOn();
        System.out.println("myCar is now running at " + myCar.getRPM() + " RPM"); //Has increased

        myCar.run(4*60); //run for 4 hours eeek!

        myLaptop.setCharging(false); //unplug battery
        myLaptop.run(4*60); //run for two hours

        myCar.run(60); //run for another 60 minutes ... bad idea

    }
}
