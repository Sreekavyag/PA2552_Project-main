package se.bth.pa2552_project.system;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.ApplicationTest;
import se.bth.pa2552_project.UnitConverterApplication;
import se.bth.pa2552_project.system.utils.HeadlessHelper;
import static org.assertj.core.api.Assertions.assertThat;


// This is our Java class which will perform our system tests
@ExtendWith(ApplicationExtension.class)
class UnitConverterSystemTest {
    // Before we do any test we have to make sure we have the correct access.
    @BeforeAll
    public static void setupForHeadlessTesting() {
        HeadlessHelper.setupForHeadlessTesting();
    }

    //We also verify that we are able to launch the application before we try to test it
    @BeforeEach
    public void setup() throws Exception {
        ApplicationTest.launch(UnitConverterApplication.class);
    }

    // When you have an input field it's common to test what input it receives to prevent the program from crashing
    // This is why we check to see if the input field is empty
    // If it is, we then assert to make sure it displays text to give feedback to the user of why it failed.
    @Test
    public void testEmptyInputValidation(FxRobot robot) {
        // Step 1: Fetch everything the robot will need.
        Button convertButton = robot.lookup("#temperatureConvert").queryButton();
        TextField fahrenheitInput = robot.lookup("#fahrenheitInput").queryAs(TextField.class);
        Label celsiusOutput = robot.lookup("#celsiusOutput").queryAs(Label.class);
        Label errorText = robot.lookup("#errorText").queryAs(Label.class);

        // Step 2: Tell the robot to input something into the field that will generate the result you want
        fahrenheitInput.setText("");
        // Step 3: click the convert button
        robot.clickOn(convertButton);

        // Step 4: verify the result.
        // In this case we want the output to be empty
        assertThat(celsiusOutput.getText())
                .isEmpty();
        // We also want to make sure that the error message is displayed with the correct message
        assertThat(errorText.getText())
                .isNotEmpty()
                .isEqualTo("You need to input at least one digit to convert!");
    }

    @Test
    public void testLetterInputValidation(FxRobot robot) {
        // Step 1: Fetch everything the robot will need.
        Button convertButton = robot.lookup("#temperatureConvert").queryButton();
        TextField fahrenheitInput = robot.lookup("#fahrenheitInput").queryAs(TextField.class);
        Label celsiusOutput = robot.lookup("#celsiusOutput").queryAs(Label.class);
        Label errorText = robot.lookup("#errorText").queryAs(Label.class);

        // Step 2: Tell the robot to input something into the field that will generate the result you want
        fahrenheitInput.setText("Hello! äöü=!=? \"exit()\"");
        // Step 3: click the convert button
        robot.clickOn(convertButton);

        // Step 4: verify the result.
        // In this case we want the output to be empty
        assertThat(celsiusOutput.getText())
                .isEmpty();
        // We also want to make sure that the error message is displayed with the correct message
        assertThat(errorText.getText())
                .isNotEmpty()
                .isEqualTo("You need to enter a number!");
    }

    // This is our system test, the purpose of it is to simulate a user using the application
    // This is done by using the FxRobot, you basically just tell the robot what you want it to do.
    // Then you need to use the assertThat() function to verify that the test generated the result you expected.
    @Test
    public void fahrenheitToCelsiusSystemTest(FxRobot robot) {
        // Step 1: Fetch everything the robot will need.
        // This is done by using their ID, which can be found in the main-screen.fxml file
        Button convertButton = robot.lookup("#temperatureConvert").queryButton();
        TextField fahrenheitInput = robot.lookup("#fahrenheitInput").queryAs(TextField.class);
        Label celsiusOutput = robot.lookup("#celsiusOutput").queryAs(Label.class);

        // Step 2: Tell the robot to input something into the field that will generate the result you want
        fahrenheitInput.setText("67");

        // Step 3: click the convert button
        robot.clickOn(convertButton);

        // Step 4: look at the label to make sure it is not empty and contains the value we expect
        assertThat(celsiusOutput.getText())
                .isNotEmpty()
                .isEqualTo("19.44");
        // Test has now officially passed!
    }

    @Test
    public void metersPerSecondToKilometersPerHourSystemTest(FxRobot robot) {
        //TODO: WRITE SYSTEM TEST HERE
        //Step 1: Fetch every thing the robot will be needed to test.
        ///This is done by using their ID, which can be found in the main-screen.fxml file
        Button convertButton = robot.lookup("#speedConvert").queryButton();
        TextField mpsInput = robot.lookup("#mpsInput").queryAs(TextField.class);
        Label kmhOutput = robot.lookup("#kmhOutput").queryAs(Label.class);

        // Step 2: Tell the robot to input something into the field that will generate the result you want
        mpsInput.setText("7500");

        // Step 3: click the convert button
        robot.clickOn(convertButton);

        // Step 4: look at the label to make sure it is not empty and contains the value we expect
        assertThat(kmhOutput.getText())
                .isNotEmpty()
                .isEqualTo("7.5");
        // Test has now officially passed!

    }

    @Test
    public void minutesToHoursSystemTest(FxRobot robot) {
        //TODO: WRITE SYSTEM TEST HERE
        //TODO: WRITE SYSTEM TEST HERE
        //Step 1: Fetch every thing the robot will be needed to test.
        ///This is done by using their ID, which can be found in the main-screen.fxml file
        Button convertButton = robot.lookup("#onTimeConvert").queryButton();
        TextField minuteInput = robot.lookup("#minuteInput").queryAs(TextField.class);
        Label hourOutput = robot.lookup("#hourOutput").queryAs(Label.class);

        // Step 2: Tell the robot to input something into the field that will generate the result you want
        minuteInput.setText("180");

        // Step 3: click the convert button
        robot.clickOn(convertButton);

        // Step 4: look at the label to make sure it is not empty and contains the value we expect
        assertThat(hourOutput.getText())
                .isNotEmpty()
                .isEqualTo("3");
        // Test has now officially passed!
    }

    @Test
    public void gallonToLiterSystemTest(FxRobot robot) {
        //TODO: WRITE SYSTEM TEST HERE
    }

    @Test
    public void gramsToOuncesSystemTest(FxRobot robot) {
        //TODO: WRITE SYSTEM TEST HERE
    }
}
