package mk.ukim.finki.dp.RPNCalculator.utils;

import android.app.Activity;
import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.mathoperations.MathOperation;
import mk.ukim.finki.dp.RPNCalculator.operations.OperationStatusKeeper;

import java.util.Stack;

/**
 * Class for general helper methods.
 */
public class DisplayValueHelper {

    public static TextView txtStackValues[] = new TextView[4];
    public static TextView txtInfoValues[] = new TextView[3];
    // 0 is state, 1 is inv, 2 is deg/rad

    public static String defaultInfoValues[] = {Constants.STATE_DEFAULT, Constants.EMPTY_STRING, Constants.DEG};

    /**
     * Initializes the text of the 4 last values of the stack that are shown on the display.
     *
     * @param activity the current activity
     */
    public static void initializeStackTxtValues(Activity activity) {
        for (int i = 0; i < Constants.TEXT_VIEWS_STACK.length; i++) {
            if (activity.findViewById(Constants.TEXT_VIEWS_STACK[i]) != null) {
                txtStackValues[i] = (TextView) activity.findViewById(Constants.TEXT_VIEWS_STACK[i]);
                txtStackValues[i].setText(Constants.DECIMAL_ZERO);
            }
        }
    }

    /**
     * Initializes the value of the status information shown on the display (INV, DEG/RAD, STATE ...).
     *
     * @param activity the current activity
     */
    public static void initializeInfoTxtValues(Activity activity) {
        for (int i = 0; i < Constants.TEXT_VIEWS_INFO.length; i++) {
            if (activity.findViewById(Constants.TEXT_VIEWS_INFO[i]) != null) {
                txtInfoValues[i] = (TextView) activity.findViewById(Constants.TEXT_VIEWS_INFO[i]);
                txtInfoValues[i].setText(defaultInfoValues[i]);
            }
        }
    }

    /**
     * Sets the last 4 values of the stack on the display.
     *
     * @param stack the calculator's stack
     */
    public static void displayStackValues(Stack<Double> stack) {
        for (int i = 0; i < txtStackValues.length; i++) {
            int index = stack.size() - i - 1;
            if (index < 0 || stack.get(index) == null) {
                txtStackValues[i].setText(Constants.DECIMAL_ZERO);
                continue;
            }
            txtStackValues[i].setText(stack.get(index).toString());
        }
    }

    /**
     * Displays the state on the display.
     *
     * @param state the calculator's state
     */
    public static void displayStateValue(String state) {
        txtInfoValues[Constants.DISPLAY_STATE_INDEX].setText(state);
    }

    /**
     * Displays the INV status on the display.
     *
     * @param inv the current INV status
     */
    public static void displayInvValue(String inv) {
        txtInfoValues[Constants.DISPLAY_INV_INDEX].setText(inv);
    }

    /**
     * Displays the DegRad status on the display.
     *
     * @param degRad the current Deg/Rad status
     */
    public static void displayDegRadValue(String degRad) {
        txtInfoValues[Constants.DISPLAY_DEG_RAD_INDEX].setText(degRad);
    }

    public static OperationStatusKeeper operationStatus = OperationStatusKeeper.getInstance();

    /**
     * Adds character to the display.
     *
     * @param txtDisplayValue the display TextView
     * @param value           the character to be added
     */
    public static void addCharToDisplay(TextView txtDisplayValue, String value) {
        if (operationStatus.isOperationExecuted()) {
            setDisplayValueToDefault(txtDisplayValue);
            operationStatus.setOperationExecuted(false);
        }
        if (isDisplayValueZero(txtDisplayValue) && !value.equals(Constants.DECIMAL_POINT)) {
            clearDisplayValue(txtDisplayValue);
        }
        txtDisplayValue.setText(txtDisplayValue.getText().toString() + value);
    }

    /**
     * Sets value to the display.
     *
     * @param txtDisplayValue the display TextView
     * @param value           the value to be set
     */
    public static void setDisplayValue(TextView txtDisplayValue, String value) {
        txtDisplayValue.setText(value);
    }

    /**
     * Sets the display to default value (0.0)
     *
     * @param txtDisplayValue the display TextView
     */
    public static void setDisplayValueToDefault(TextView txtDisplayValue) {
        txtDisplayValue.setText(Constants.ZERO);
    }

    /**
     * Clears the display value.
     *
     * @param txtDisplayValue the display TextView
     */
    public static void clearDisplayValue(TextView txtDisplayValue) {
        txtDisplayValue.setText(Constants.EMPTY_STRING);
    }

    /**
     * Checks if the display value is zero.
     *
     * @param txtDisplayValue the display TextView
     * @return true if the display value is zero, false otherwise
     */
    public static boolean isZeroValid(TextView txtDisplayValue) {
        return !txtDisplayValue.getText().toString().equals(Constants.ZERO);
    }

    /**
     * Checks if there is a decimal point on the display so that new shouldn't be added.
     *
     * @param txtDisplayValue the display TextView
     * @return true if there is decimal point on the display, false otherwise.
     */
    public static boolean isDecimalPointValid(TextView txtDisplayValue) {
        return !txtDisplayValue.getText().toString().contains(Constants.DECIMAL_POINT);
    }

    /**
     * Checks if hte last character on the display is decimal point.
     *
     * @param txtDisplayValue the display TextView
     * @return true if the last character is decimal point, false otherwise
     */
    public static boolean isLastCharDecimalPoint(TextView txtDisplayValue) {
        return txtDisplayValue.getText().toString().endsWith(Constants.DECIMAL_POINT);
    }

    /**
     * Checks if the display value is zero.
     *
     * @param txtDisplayValue the display TextView
     * @return true if the display value is zero, false otherwise
     */
    public static boolean isDisplayValueZero(TextView txtDisplayValue) {
        return txtDisplayValue.getText().toString().equals(Constants.ZERO);
    }

    /**
     * Deletes the last character of the display.
     *
     * @param txtDisplayValue the display TextView
     */
    public static void deleteLastCharacter(TextView txtDisplayValue) {
        if (txtDisplayValue.getText().length() > 1) {
            if (MathOperationsHelper.parseStringToDouble(txtDisplayValue.getText().toString()).equals(Double.NaN)) {
                setDisplayValueToDefault(txtDisplayValue);
            } else {
                txtDisplayValue.setText(txtDisplayValue.getText()
                        .subSequence(0, txtDisplayValue.getText().length() - 1));
            }
            if (isLastCharDecimalPoint(txtDisplayValue)) {
                txtDisplayValue.setText(txtDisplayValue.getText()
                        .subSequence(0, txtDisplayValue.getText().length() - 1));
            }

            if (txtDisplayValue.getText().toString().equals(Constants.OPERATOR_MINUS)) {
                txtDisplayValue.setText(Constants.ZERO);
            }
        } else {
            txtDisplayValue.setText(Constants.ZERO);
        }
    }
}
