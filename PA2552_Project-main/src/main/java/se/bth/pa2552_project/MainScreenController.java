package se.bth.pa2552_project;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.function.Function;

// To use fxml and style sheets you need a controller
// here we define all the types of components together with how they work.
public class MainScreenController {
    // Error text label
    public Label errorText;

    // The input fields
    public TextField fahrenheitInput;
    public TextField mpsInput;
    public TextField minuteInput;
    public TextField gallonInput;
    public TextField gramsInput;

    // The labels presenting the result
    public Label celsiusOutput;
    public Label kmhOutput;
    public Label hourOutput;
    public Label litersOutput;
    public Label ouncesOutput;

    // As for all unit conversions we perform some common actions
    // This is way we have a generic function.
    // It takes the text input, checks if it's a valid input, and then parses it to the given function,
    // which then spits out a double that we convert back into text.
    public static void handleConversion(TextField input, Label output, Label errorText, Function<Double, Double> converter) {
        String inputString = input.getText();
        if (inputString.length() < 1) {
            errorText.setText("You need to input at least one digit to convert!");
            output.setText("");
        } else {
            try {
                double inputVal = Double.parseDouble(inputString);
                double outputVal = converter.apply(inputVal);
                output.setText(String.format("%.2f", outputVal));
                errorText.setText("");
            } catch (NumberFormatException e) {
                output.setText("");
                errorText.setText("You need to enter a number!");
            }
        }
    }

    // And these are our buttons,
    // they are a special sense the only call a single function, therefore we do not need to redefine them in this file.
    // It's enough that they are defined in the main-screen.fxml file.
    public void onTemperatureConvert() {
        handleConversion(fahrenheitInput, celsiusOutput, errorText, UnitConversion::fahrenheitToCelsius);
    }

    public void onSpeedConvert() {
        handleConversion(mpsInput, kmhOutput, errorText, UnitConversion::metersPerSecondToKilometersPerHour);
    }

    public void onTimeConvert() {
        handleConversion(minuteInput, hourOutput, errorText, UnitConversion::minutesToHours);
    }

    public void onVolumeConvert() {
        handleConversion(gallonInput, litersOutput, errorText, UnitConversion::gallonToLiter);
    }

    public void onWeightConvert() {
        handleConversion(gramsInput, ouncesOutput, errorText, UnitConversion::gramsToOunces);
    }
}
