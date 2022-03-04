package se.bth.pa2552_project.unit;

import org.junit.jupiter.api.Test;
import se.bth.pa2552_project.UnitConversion;

import static org.junit.jupiter.api.Assertions.*;

class UnitConversionTest {

    @Test
    void fahrenheitToCelsius() {
        assertEquals(UnitConversion.fahrenheitToCelsius(99),37.22222222222222);
    }

    @Test
    void metersPerSecondToKilometersPerHour() {
        //TODO: WRITE UNIT TEST HERE
        assertEquals(UnitConversion.metersPerSecondToKilometersPerHour(7500),7.5);
    }

    @Test
    void minutesToHours() {
        // We insert the input 120 minutes
        // We expect the output 2 hours
        // We assert to make sure it generates the expected output
        // The functions can be found in the UnitConversion file.
        assertEquals(UnitConversion.minutesToHours(120), 2);
    }

    @Test
    void gallonToLiter() {
        //TODO: WRITE UNIT TEST HERE
    }

    @Test
    void gramsToOunces() {
        //TODO: WRITE UNIT TEST HERE
    }
}