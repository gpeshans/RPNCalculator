package mk.ukim.finki.dp.RPNCalculator.operations;

import android.widget.TextView;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.mathoperations.*;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorState;
import mk.ukim.finki.dp.RPNCalculator.states.StateType;
import mk.ukim.finki.dp.RPNCalculator.utils.DisplayValueHelper;
import mk.ukim.finki.dp.RPNCalculator.utils.MathOperationsHelper;

/**
 * Class for the operation of buttonTangent.
 */
public class TangentOperation extends AbstractBasicOperation {
    public TangentOperation(TextView txtDisplayValue, RPNCalculatorStack stack, RPNCalculatorState state) {
        super(txtDisplayValue, stack, state);
    }

    @Override
    public void defaultStateOperation() {
        Double result = 0.0;
        MathTrigonometricOperation operation = new TangentOperationImpl();
        if (DisplayValueHelper.txtInfoValues[Constants.DISPLAY_INV_INDEX].getText().toString().equals(Constants.INV)) {
            operation = new ArctangentOperationImpl();
        }
        Double operand1 = MathOperationsHelper.parseStringToDouble(getTxtDisplayValue().getText().toString());

        if (DisplayValueHelper.txtInfoValues[Constants.DISPLAY_DEG_RAD_INDEX].getText().toString().equals(Constants.DEG)) {
            if (!DisplayValueHelper.txtInfoValues[Constants.DISPLAY_INV_INDEX].getText().toString().equals(Constants.INV)) {
                operand1 = Math.toRadians(operand1);
                result = operation.calculate(operand1);
            } else {
                result = Math.toDegrees(operation.calculate(operand1));
            }
        } else {
            result = operation.calculate(operand1);
        }
        getStack().pushToStack(result);
        DisplayValueHelper.setDisplayValue(getTxtDisplayValue(), result.toString());
        DisplayValueHelper.displayStackValues(getStack().getRpnStack());
        DisplayValueHelper.displayInvValue(Constants.EMPTY_STRING);
        DisplayValueHelper.operationStatus.setOperationExecuted(true);
    }

    @Override
    public void programStateOperation() {
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
