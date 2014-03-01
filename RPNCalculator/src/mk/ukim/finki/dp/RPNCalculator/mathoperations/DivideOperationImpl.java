package mk.ukim.finki.dp.RPNCalculator.mathoperations;

import mk.ukim.finki.dp.RPNCalculator.configuration.Constants;
import mk.ukim.finki.dp.RPNCalculator.utils.MathOperationsHelper;

/**
 * Implementation of the divide operation.
 */
public class DivideOperationImpl implements MathOperation {
    @Override
    public Double calculate(Double operand1, Double operand2) {
        Double result = 0.0;
        Double zero = MathOperationsHelper.parseStringToDouble(Constants.ZERO);
        if (!operand2.equals(zero)) {
            result = operand1 / operand2;
        } else {
            result = Double.NaN;
        }
        return result;
    }
}
