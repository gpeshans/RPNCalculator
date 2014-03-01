package mk.ukim.finki.dp.RPNCalculator.commands;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.operations.Operation;
import mk.ukim.finki.dp.RPNCalculator.operations.OperationFactory;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorState;

/**
 * Class that manages the button listeners.
 */
public class ButtonClickListenersManager {

    private Activity calculatorActivity;
    private RPNCalculatorStack stack;
    private RPNCalculatorState state;

    public ButtonClickListenersManager(Activity calculatorActivity) {
        this.calculatorActivity = calculatorActivity;
        this.stack = RPNCalculatorStack.getInstance();
        this.state = RPNCalculatorState.getInstance();
    }

    /**
     * Sets a clickListener to each button with the appropriate operation for that button.
     * The operation is created by th OperationFactory.
     */
    public void setButtonsClickListeners() {
        TextView txtDisplayValue = (TextView) this.calculatorActivity.findViewById(Constants.TEXT_VIEW_DISPLAY_VALUE);
        Button button = null;
        ButtonClickListener buttonClickListener = null;
        Operation buttonOperation = null;
        for (int i = 0; i < Constants.BUTTONS.length; i++) {
            if (this.calculatorActivity.findViewById(Constants.BUTTONS[i]) == null) {
                continue;
            }
            button = (Button) this.calculatorActivity.findViewById(Constants.BUTTONS[i]);
            buttonOperation = OperationFactory.createOperation(Constants.BUTTONS[i], txtDisplayValue, stack, state);
            buttonClickListener = new ButtonClickListener(buttonOperation);
            button.setOnClickListener(buttonClickListener);
        }
    }
}
