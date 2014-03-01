package mk.ukim.finki.dp.RPNCalculator.operations;

import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorState;
import mk.ukim.finki.dp.RPNCalculator.states.StateType;
import mk.ukim.finki.dp.RPNCalculator.utils.DisplayValueHelper;
import mk.ukim.finki.dp.RPNCalculator.utils.MathOperationsHelper;
import mk.ukim.finki.dp.RPNCalculator.utils.ProgramManipulationHandler;
import mk.ukim.finki.dp.RPNCalculator.utils.StorageManipulationHelper;

/**
 * Class for the operation of button6.
 */
public class NumberSixOperation extends AbstractBasicOperation {
    public NumberSixOperation(TextView txtDisplayValue, RPNCalculatorStack stack, RPNCalculatorState state) {
        super(txtDisplayValue, stack, state);
    }

    @Override
    public void defaultStateOperation() {
        DisplayValueHelper.addCharToDisplay(getTxtDisplayValue(), Constants.SIX);
    }

    @Override
    public void programStateOperation() {
        ProgramManipulationHandler.addProgramCharacter(Constants.SIX);
        DisplayValueHelper.addCharToDisplay(getTxtDisplayValue(), Constants.SIX);
    }

    @Override
    public void storeStateOperation() {
        double value = MathOperationsHelper.parseStringToDouble(getTxtDisplayValue().getText().toString());
        int index = MathOperationsHelper.parseStringToInteger(Constants.SIX);
        StorageManipulationHelper.setValueToRegister(value, index);
        getStack().pushToStack(value);
        getState().setActiveState(StateType.DEFAULT);
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
        DisplayValueHelper.displayStateValue(Constants.STATE_DEFAULT);
    }

    @Override
    public void recallStateOperation() {
        int index = MathOperationsHelper.parseStringToInteger(Constants.SIX);
        Double value = StorageManipulationHelper.getValueFromRegister(index);
        Double displayValue = MathOperationsHelper.parseStringToDouble(getTxtDisplayValue().getText().toString());
        getStack().pushToStack(displayValue);
        DisplayValueHelper.setDisplayValue(getTxtDisplayValue(), value.toString());
        getState().setActiveState(StateType.DEFAULT);
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
        DisplayValueHelper.displayStateValue(Constants.STATE_DEFAULT);
    }
}
