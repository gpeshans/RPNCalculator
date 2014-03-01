package mk.ukim.finki.dp.RPNCalculator.operations;

import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorState;
import mk.ukim.finki.dp.RPNCalculator.states.StateType;
import mk.ukim.finki.dp.RPNCalculator.utils.DisplayValueHelper;

/**
 * Class for the operation of buttonInverse.
 */
public class InverseOperation extends AbstractBasicOperation {
    public InverseOperation(TextView txtDisplayValue, RPNCalculatorStack stack, RPNCalculatorState state) {
        super(txtDisplayValue, stack, state);
    }

    @Override
    public void defaultStateOperation() {
        if (DisplayValueHelper.txtInfoValues[Constants.DISPLAY_INV_INDEX].getText().toString().equals(Constants.INV)) {
            DisplayValueHelper.displayInvValue(Constants.EMPTY_STRING);
        } else {
            DisplayValueHelper.displayInvValue(Constants.INV);
        }
    }

    @Override
    public void programStateOperation() {
        if (DisplayValueHelper.txtInfoValues[Constants.DISPLAY_INV_INDEX].getText().toString().equals(Constants.INV)) {
            DisplayValueHelper.displayInvValue(Constants.EMPTY_STRING);
        } else {
            DisplayValueHelper.displayInvValue(Constants.INV);
        }
        getState().setActiveState(StateType.DEFAULT);
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
        DisplayValueHelper.displayStateValue(Constants.STATE_DEFAULT);
    }

    @Override
    public void storeStateOperation() {
        if (DisplayValueHelper.txtInfoValues[Constants.DISPLAY_INV_INDEX].getText().toString().equals(Constants.INV)) {
            DisplayValueHelper.displayInvValue(Constants.EMPTY_STRING);
        } else {
            DisplayValueHelper.displayInvValue(Constants.INV);
        }
        getState().setActiveState(StateType.DEFAULT);
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
        DisplayValueHelper.displayStateValue(Constants.STATE_DEFAULT);
    }

    @Override
    public void recallStateOperation() {
        if (DisplayValueHelper.txtInfoValues[Constants.DISPLAY_INV_INDEX].getText().toString().equals(Constants.INV)) {
            DisplayValueHelper.displayInvValue(Constants.EMPTY_STRING);
        } else {
            DisplayValueHelper.displayInvValue(Constants.INV);
        }
        getState().setActiveState(StateType.DEFAULT);
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
        DisplayValueHelper.displayStateValue(Constants.STATE_DEFAULT);
    }
}
