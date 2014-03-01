package mk.ukim.finki.dp.RPNCalculator.operations;

import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorState;

/**
 * Class for the basic operation.
 */
public abstract class AbstractBasicOperation implements Operation {

    private TextView txtDisplayValue;
    private RPNCalculatorStack stack;
    private RPNCalculatorState state;

    protected AbstractBasicOperation(TextView txtDisplayValue, RPNCalculatorStack stack,
                                     RPNCalculatorState state) {
        this.txtDisplayValue = txtDisplayValue;
        this.stack = stack;
        this.state = state;
    }

    public TextView getTxtDisplayValue() {
        return txtDisplayValue;
    }

    public void setTxtDisplayValue(TextView txtDisplayValue) {
        this.txtDisplayValue = txtDisplayValue;
    }

    public RPNCalculatorStack getStack() {
        return stack;
    }

    public void setStack(RPNCalculatorStack stack) {
        this.stack = stack;
    }

    public RPNCalculatorState getState() {
        return state;
    }

    public void setState(RPNCalculatorState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        switch (state.getActiveState()) {
            case DEFAULT:
                defaultStateOperation();
                break;
            case PROGRAM:
                programStateOperation();
                break;
            case STORE:
                storeStateOperation();
                break;
            case RECALL:
                recallStateOperation();
                break;
            default:
                defaultStateOperation();
                break;
        }
    }

    /**
     * Executes if the calculator is in DEFAULT state.
     */
    public abstract void defaultStateOperation();

    /**
     * Executes if the calculator is in PROGRAM state.
     */
    public abstract void programStateOperation();

    /**
     * Executes if the calculator is in STORE state.
     */
    public abstract void storeStateOperation();

    /**
     * Executes if the calculator is in RECALL state.
     */
    public abstract void recallStateOperation();
}
