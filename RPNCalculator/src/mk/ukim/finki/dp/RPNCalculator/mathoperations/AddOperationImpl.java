package mk.ukim.finki.dp.RPNCalculator.mathoperations;

/**
 * Implementation for the add operation.
 */
public class AddOperationImpl implements MathOperation {
    @Override
    public Double calculate(Double operand1, Double operand2) {
        return operand1 + operand2;
    }
}
