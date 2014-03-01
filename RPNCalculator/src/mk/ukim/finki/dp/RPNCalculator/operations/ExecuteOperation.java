package mk.ukim.finki.dp.RPNCalculator.operations;

import android.widget.TextView;
import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;
import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorStack;
import mk.ukim.finki.dp.RPNCalculator.model.RPNCalculatorState;
import mk.ukim.finki.dp.RPNCalculator.states.StateType;
import mk.ukim.finki.dp.RPNCalculator.utils.DisplayValueHelper;
import mk.ukim.finki.dp.RPNCalculator.utils.ProgramManipulationHandler;

/**
 * Class for the operation of buttonExecute.
 */
public class ExecuteOperation extends AbstractBasicOperation {
    public ExecuteOperation(TextView txtDisplayValue, RPNCalculatorStack stack, RPNCalculatorState state) {
        super(txtDisplayValue, stack, state);
    }

    @Override
    public void defaultStateOperation() {
        String programSequence = ProgramManipulationHandler.getProgramSequence();
        Double result = 0.0;
        Calculable calc = null;
        try {
            calc = new ExpressionBuilder(programSequence).build();
            result = calc.calculate();
        } catch (UnknownFunctionException e) {
            result = Double.NaN;
            e.printStackTrace();
        } catch (UnparsableExpressionException e) {
            result = Double.NaN;
            e.printStackTrace();
        } catch (Exception e) {
            result = Double.NaN;
            e.printStackTrace();
        }
        getStack().pushToStack(result);
        DisplayValueHelper.setDisplayValue(getTxtDisplayValue(), result.toString());
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
