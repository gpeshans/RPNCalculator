package mk.ukim.finki.dp.RPNCalculator.operations;

import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorState;
import mk.ukim.finki.dp.RPNCalculator.states.StateType;
import mk.ukim.finki.dp.RPNCalculator.utils.DisplayValueHelper;
import mk.ukim.finki.dp.RPNCalculator.utils.ProgramManipulationHandler;

/**
 * Class for the operation of buttonDrop.
 */
public class DropOperation extends AbstractBasicOperation {
    public DropOperation(TextView txtDisplayValue, RPNCalculatorStack stack, RPNCalculatorState state) {
        super(txtDisplayValue, stack, state);
    }

    @Override
    public void defaultStateOperation() {
        Double value = 0.0;
        if (!getStack().isStackEmpty()) {
            getStack().popFromStack();
            if (!getStack().isStackEmpty()) {
                value = getStack().getRpnStack().get(getStack().getRpnStack().size() - 1);
            }
        }
        DisplayValueHelper.displayStackValues(getStack().getRpnStack());
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
    }

    @Override
    public void programStateOperation() {
        ProgramManipulationHandler.resetProgramSequence();
        getState().setActiveState(StateType.DEFAULT);
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
        DisplayValueHelper.displayStateValue(Constants.STATE_DEFAULT);
    }

    @Override
    public void storeStateOperation() {
        getState().setActiveState(StateType.DEFAULT);
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
        DisplayValueHelper.displayStateValue(Constants.STATE_DEFAULT);
    }

    @Override
    public void recallStateOperation() {
        getState().setActiveState(StateType.DEFAULT);
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
        DisplayValueHelper.displayStateValue(Constants.STATE_DEFAULT);
    }
}
