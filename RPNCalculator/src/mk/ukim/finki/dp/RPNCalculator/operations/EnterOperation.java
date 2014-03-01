package mk.ukim.finki.dp.RPNCalculator.operations;

import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorState;
import mk.ukim.finki.dp.RPNCalculator.states.StateType;
import mk.ukim.finki.dp.RPNCalculator.utils.DisplayValueHelper;
import mk.ukim.finki.dp.RPNCalculator.utils.MathOperationsHelper;
import mk.ukim.finki.dp.RPNCalculator.utils.ProgramManipulationHandler;

/**
 * Class for the operation of buttonEnter.
 */
public class EnterOperation extends AbstractBasicOperation {
    public EnterOperation(TextView txtDisplayValue, RPNCalculatorStack stack, RPNCalculatorState state) {
        super(txtDisplayValue, stack, state);
    }

    @Override
    public void defaultStateOperation() {
        Double currentValue = 0.0;
        if (DisplayValueHelper.isLastCharDecimalPoint(getTxtDisplayValue())) {
            DisplayValueHelper.addCharToDisplay(getTxtDisplayValue(), Constants.ZERO);
        }
        currentValue = MathOperationsHelper.parseStringToDouble(getTxtDisplayValue().getText().toString());
        getStack().pushToStack(currentValue);
        DisplayValueHelper.displayStackValues(getStack().getRpnStack());
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
    }

    @Override
    public void programStateOperation() {
        ProgramManipulationHandler.saveProgramSequence();
        getState().setActiveState(StateType.DEFAULT);
        DisplayValueHelper.setDisplayValueToDefault(getTxtDisplayValue());
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
