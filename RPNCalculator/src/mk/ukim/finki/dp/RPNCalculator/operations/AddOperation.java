package mk.ukim.finki.dp.RPNCalculator.operations;

import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.mathoperations.AddOperationImpl;
import mk.ukim.finki.dp.RPNCalculator.mathoperations.MathOperation;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorState;
import mk.ukim.finki.dp.RPNCalculator.states.StateType;
import mk.ukim.finki.dp.RPNCalculator.utils.DisplayValueHelper;
import mk.ukim.finki.dp.RPNCalculator.utils.MathOperationsHelper;
import mk.ukim.finki.dp.RPNCalculator.utils.ProgramManipulationHandler;

/**
 * Class for the operation of buttonAdd.
 */
public class AddOperation extends AbstractBasicOperation {
    public AddOperation(TextView txtDisplayValue, RPNCalculatorStack stack, RPNCalculatorState state) {
        super(txtDisplayValue, stack, state);
    }

    @Override
    public void defaultStateOperation() {
        Double operand1 = 0.0;
        Double operand2 = MathOperationsHelper.parseStringToDouble(getTxtDisplayValue().getText().toString());
        Double result = 0.0;
        MathOperation addOperation = new AddOperationImpl();
        if (!getStack().isStackEmpty()) {
            operand1 = getStack().popFromStack();
        }
        result = addOperation.calculate(operand1, operand2);
        getStack().pushToStack(result);
        DisplayValueHelper.setDisplayValue(getTxtDisplayValue(), result.toString());
        DisplayValueHelper.displayStackValues(getStack().getRpnStack());
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
    }

    @Override
    public void programStateOperation() {
        ProgramManipulationHandler.addProgramCharacter(Constants.PLUS);
        DisplayValueHelper.addCharToDisplay(getTxtDisplayValue(), Constants.PLUS);
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
