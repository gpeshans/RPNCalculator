package mk.ukim.finki.dp.RPNCalculator.operations;

import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorState;

/**
 * Class with factory method that creates operations for the buttons.
 */
public class OperationFactory {
    /**
     * Creates operation object for a certain button.
     * @param BUTTON the button id/type
     * @param txtDisplayValue the displayTextView
     * @param stack the calculator's stack
     * @param state the calculator's state
     * @return Operation object
     */
    public static Operation createOperation(int BUTTON, TextView txtDisplayValue, RPNCalculatorStack stack, RPNCalculatorState state) {
        Operation operation = null;
        if (BUTTON == Constants.BUTTON_NUMBER_0) {
            operation = new NumberZeroOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_NUMBER_1) {
            operation = new NumberOneOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_NUMBER_2) {
            operation = new NumberTwoOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_NUMBER_3) {
            operation = new NumberThreeOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_NUMBER_4) {
            operation = new NumberFourOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_NUMBER_5) {
            operation = new NumberFiveOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_NUMBER_6) {
            operation = new NumberSixOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_NUMBER_7) {
            operation = new NumberSevenOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_NUMBER_8) {
            operation = new NumberEightOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_NUMBER_9) {
            operation = new NumberNineOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_DECIMAL_POINT) {
            operation = new DecimalPointOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_ENTER) {
            operation = new EnterOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_ADD) {
            operation = new AddOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_SUBTRACT) {
            operation = new SubtractOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_MULTIPLY) {
            operation = new MultiplyOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_DIVIDE) {
            operation = new DivideOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_CHANGE_SIGN) {
            operation = new ChangeSignOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_DROP) {
            operation = new DropOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_SWAP) {
            operation = new SwapOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_STORE) {
            operation = new StoreOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_RECALL) {
            operation = new RecallOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_PROGRAM) {
            operation = new ProgramOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_EXECUTE) {
            operation = new ExecuteOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_BACK) {
            operation = new BackOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_UNDO) {
            operation = new UndoOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_REDO) {
            operation = new RedoOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_SINE) {
            operation = new SineOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_COSINE) {
            operation = new CosineOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_TANGENT) {
            operation = new TangentOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_INVERSE) {
            operation = new InverseOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_DEG) {
            operation = new DegOperation(txtDisplayValue, stack, state);
        } else if (BUTTON == Constants.BUTTON_COMMAND_RAD) {
            operation = new RadOperation(txtDisplayValue, stack, state);
        }
        return operation;
    }
}
