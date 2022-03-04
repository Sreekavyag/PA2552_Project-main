package se.bth.pa2552_project;

// This file will contain all business logic behind the application.
// In our case it contains the converter functions.
// The reason we separate it from the application is to keep the code generic,
// This way we can perform low level unit tests based on the code in here,
// without it accidentally being influenced by the application itself.

public class UnitConversion {
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0/9.0;
    }

    public static double metersPerSecondToKilometersPerHour(double mps) {
        return mps * 18.0/5.0;
    }

    public static double minutesToHours(double minutes) {
        return minutes / 60.0;
    }

    public static double gallonToLiter(double gallons) {
        return gallons * 3.785;
    }

    public static double gramsToOunces(double grams) {
        return grams * 0.035274;
    }
}
