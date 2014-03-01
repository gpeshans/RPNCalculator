package mk.ukim.finki.dp.RPNCalculator.mathoperations;

/**
 * Implementation for the multiply operation.
 */
public class MultiplyOperationImpl implements MathOperation {
    @Override
    public Double calculate(Double operand1, Double operand2) {
        return operand1 * operand2;
    }
}
