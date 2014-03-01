package mk.ukim.finki.dp.RPNCalculator.operations;

import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.mathoperations.DivideOperationImpl;
import mk.ukim.finki.dp.RPNCalculator.mathoperations.MathOperation;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorState;
import mk.ukim.finki.dp.RPNCalculator.states.StateType;
import mk.ukim.finki.dp.RPNCalculator.utils.DisplayValueHelper;
import mk.ukim.finki.dp.RPNCalculator.utils.MathOperationsHelper;
import mk.ukim.finki.dp.RPNCalculator.utils.ProgramManipulationHandler;

/**
 * Class for the operation of buttonDivide.
 */
public class DivideOperation extends AbstractBasicOperation {
    public DivideOperation(TextView txtDisplayValue, RPNCalculatorStack stack, RPNCalculatorState state) {
        super(txtDisplayValue, stack, state);
    }

    @Override
    public void defaultStateOperation() {
        Double operand1 = 0.0;
        Double operand2 = MathOperationsHelper.parseStringToDouble(getTxtDisplayValue().getText().toString());
        Double result = 0.0;

        MathOperation divideOperation = new DivideOperationImpl();

        if (!getStack().isStackEmpty()) {
            operand1 = getStack().popFromStack();
        }
        result = divideOperation.calculate(operand1, operand2);
        getStack().pushToStack(result);
        DisplayValueHelper.setDisplayValue(getTxtDisplayValue(), result.toString());
        DisplayValueHelper.displayStackValues(getStack().getRpnStack());
        DisplayValueHelper.operationStatus.setOperationExecuted(true);

    }

    @Override
    public void programStateOperation() {
        ProgramManipulationHandler.addProgramCharacter(Constants.SLASH);
        DisplayValueHelper.addCharToDisplay(getTxtDisplayValue(), Constants.SLASH);
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
