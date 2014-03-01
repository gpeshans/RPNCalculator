package mk.ukim.finki.dp.RPNCalculator.commands;

import android.view.View;
import mk.ukim.finki.dp.RPNCalculator.operations.Operation;

/**
 * Parent class for the calculator's buttons click listeners.
 */
public class ButtonClickListener implements View.OnClickListener {
    private Operation operation;

    public ButtonClickListener(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        this.operation.execute();
    }
}
